import React, { Component, useEffect, useState } from 'react';
import { useFormik } from 'formik'
// import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../Stylesheets/Signup.css'
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css"
import axios from 'axios'
import moment from 'moment'

function EditServices(props) {
    console.log("heiiiiii")
    console.log(props)
    var serviceId=props.location.serviceid
    const [initvalues, setInitValues] = useState({});
    const [services, setServices] = useState([]);
    const formik = useFormik({
        initialValues: {
            serviceName: "",
            isActive: true
        },
        onSubmit: values => {
            console.log('Form data', values)
        },
        validate: values => {
            let errors = {}
            if (!values.serviceName) {
                errors.serviceName = "Enter Service Name"
            }
            return errors
        }
    })

    useEffect(() => {
        axios.get('http://localhost:8080/services')
            .then(response => {
                console.log(response)
                setServices(response.data)

                //use props for the getting and setting serviceId here
                //const serviceId = 9
                var indexpos = null;
                for (var i = 0; i < response.data.length; i++) {
                    if (response.data[i].serviceId === serviceId) {
                        indexpos = i
                        setInitValues(response.data[i])
                    }
                }

                formik.setFieldValue('serviceName', response.data[indexpos].serviceName)
                formik.setFieldValue('isActive', response.data[indexpos].active)

            })
            .catch(error => {
                console.log(error)
            })

    }, [])


    function EditServiceByAdminVendor() {

        axios.patch(`http://localhost:8080/services/Active/${initvalues.serviceId}`, {}, { params: { isActive: formik.values.isActive } })
            .then(response => {
                console.log(response)
                alert("Service Successfully Updated");
            })
            .catch(error => {
                console.log(error)
                alert("Error Updating service");
            });
    }

    return (
        <div className="container pb-3 mt-5 border" style={{textAlign:"left"}}>

            <form className="ml-5 mr-5 pt-3" onSubmit={formik.handleSubmit}>
                <h2 >Edit Services</h2><br />
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label htmlFor='serviceName'>Name:</label><br />
                        <input className="perftext" disabled="disabled" type='text' id='serviceName' name='serviceName' value={formik.values.serviceName} onChange={formik.handleChange} />
                        {formik.errors.serviceName ? <div style={{ color: 'red' }}>{formik.errors.serviceName}</div> : null}
                    </div>
                    <div className="form-group col-md-4">
                        <br />
                        <label>
                            <input type="checkbox" style={{ zoom: 1.5 }}
                                name="isActive"
                                value={formik.values.isActive}
                                checked={formik.values.isActive}
                                onChange={formik.handleChange}
                            />
                            <span> Activate</span>
                        </label>
                    </div>
                </div>

                {/* Write edit course accordingly in place of add course */}
                <button type='submit' onClick={EditServiceByAdminVendor} className="btn addcoursebut" >Edit Service</button>
            </form>
        </div >
    )
}

export default EditServices