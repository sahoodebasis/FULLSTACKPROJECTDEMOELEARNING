import React, { Component, useEffect, useState } from 'react';
import { useFormik } from 'formik'
// import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../Stylesheets/Signup.css'
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css"
import axios from 'axios'
import moment from 'moment'

function AddServices(props) {
    const [initvalues, setInitValues] = useState({});
    const [services, setServices] = useState([]);
    const [vendors, setVendors] = useState([]);
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

    function AddServiceByAdminVendor() {

        const data = {
            //no need to give courseId while adding course but we need to give courseId while updating course
            serviceName: formik.values.serviceName,
            active: formik.values.isActive

        }
        console.log("Hi activation test", data)
        if (Object.values(formik.errors).length === 0) {
        axios.post('http://localhost:8080/services/service', data)
            .then(response => {
                console.log(response)
                alert("Service Successfully added");
            })
            .catch(error => {
                console.log(error)
                alert("Error Adding service");
            });
        }
        else {
            alert('Fill all entries')
        }
    }

    return (
        <div className="container pb-3 mt-5 border" style={{textAlign:"left"}}>

            <form className="ml-5 mr-5 pt-3" onSubmit={formik.handleSubmit}>
                <h2 >Add Services</h2><br />
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label htmlFor='serviceName'>Name:</label><br />
                        <input className="perftext" type='text' id='serviceName' name='serviceName' value={formik.values.serviceName} onChange={formik.handleChange} />
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
                <button type='submit' onClick={AddServiceByAdminVendor} className="btn addcoursebut" >Add Service</button>
            </form>
        </div >
    )
}

export default AddServices