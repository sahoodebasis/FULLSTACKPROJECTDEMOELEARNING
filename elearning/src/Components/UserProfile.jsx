import React, { Component, useEffect, useState } from 'react';
import { useFormik } from 'formik'
// import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../Stylesheets/Signup.css'
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css"
import axios from 'axios'
import { confirmAlert } from 'react-confirm-alert'; // Import
import AuthenticationService from "./AuthenticationService.js";
import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

//install npm install react-confirm-alert --save
function UserProfile(props) {
    var userid=AuthenticationService.getUserIdLoggedin()
    var role=AuthenticationService.getRoleLoggedin()
    var eMail=AuthenticationService.getEmailLoggedin()
    //take rest required data from props or session storage
    //we only need to give props for emailId we can nullify the upper comment
    const [initvalues, setInitValues] = useState({});
    const formik = useFormik({
        initialValues: {
            name: "",
            contact: "",
            dob: new Date(),
            userid: null,
            email: "",
            password: "",
            confpass: "",
            hasSubscribed: false
        },

        onSubmit: values => {
            console.log('Form data', values)
        },
        validate: values => {
            let errors = {}
            if (!/^\d{10}$/.test(values.contact)) {
                errors.contact = "10-digit ContactNo. is Required"
            }
            if (getAge(values.dob) < 18) {
                errors.dob = "Age should be greater than 18"
            }
            if (!values.email) {
                errors.email = "Email is Required"
            } else if (!/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/.test(values.email)) {
                errors.email = "Invalid Email format"
            }
            if (values.password.length < 6 || !/^(?=.*[!@#$%^&*])/.test(values.password)) {
                errors.password = "Create Password(Minimum 6 char and one special character)"
            }
            if (values.confpass.length < 6 || !/^(?=.*[!@#$%^&*])/.test(values.confpass)) {
                errors.confpass = "Confirm Password"
            }
            return errors
        }
    })

    useEffect(() => {

         axios.get(`http://localhost:8080/users/${eMail}`)
        //axios.get('http://localhost:8080/users/yash@gmail.com')
            .then(response => {
                console.log("hi")
                const userData = response.data
                setInitValues(response.data)
                console.log(initvalues.name)
                formik.setFieldValue('name', response.data.name)
                formik.setFieldValue('contact', response.data.contactNo)
                formik.setFieldValue('dob', new Date(response.data.dateOfBirth))
                formik.setFieldValue('userid', response.data.userId)
                formik.setFieldValue('email', response.data.email)
                formik.setFieldValue('password', response.data.password)
                formik.setFieldValue('confpass', response.data.password)
                formik.setFieldValue('hasSubscribed', response.data.hasSubscribed)
                console.log(response)
            })
            .catch(error => {
                console.log(error)
                alert("Error in Profile");
            });

    }, [])

    //function to check that age is greater than 18
    function getAge(DOB) {
        var today = new Date();
        var birthDate = new Date(DOB);
        var age = today.getFullYear() - birthDate.getFullYear();
        var m = today.getMonth() - birthDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
            age--;
        }
        return age;
    }

    //Save Detaiils button onclick Handler
    function UpdateUserDetail() {

        const data = {
            userId: formik.values.userid,
            email: formik.values.email,
            name: formik.values.name,
            contactNo: formik.values.contact,
            password: formik.values.password,
            role: initvalues.role,
            isActive: initvalues.isActive,
            dateOfBirth: formatDate(formik.values.dob),
            hasSubscribed: formik.values.hasSubscribed
        }
        if (formik.values.password === formik.values.confpass && Object.values(formik.errors).length === 0) {
            axios.put('http://localhost:8080/update', data)
                .then(response => {
                    console.log(response)
                    alert("Details Successfully Updated");
                })
                .catch(error => {
                    console.log(error)
                    alert("Error Updating");
                    console.log(data);
                });
        }
        else {
            if (!(Object.values(formik.errors).length === 0)) {
                console.log("formik error empty or not", Object.values(formik.errors).length === 0)
                console.log(formik.errors)
                alert('Fill all form data')
            }
            else {
                console.log("formik error empty or not", Object.values(formik.errors).length === 0)
                console.log(formik.errors)
                alert('Password and Confirm password do not match')
            }
        }
    }

    //Deactivate account button
    function DeactivateAccount() {

        confirmAlert({
            title: 'Confirm to submit',
            message: 'Are you sure to do this.',
            buttons: [
                {
                    label: 'Yes',
                    onClick: () => {
                        const data = {
                            userId: formik.values.userid,
                            email: formik.values.email,
                            name: formik.values.name,
                            contactNo: formik.values.contact,
                            password: formik.values.password,
                            role: initvalues.role,
                            isActive: false,
                            dateOfBirth: formatDate(formik.values.dob),
                            hasSubscribed: initvalues.hasSubscribed
                        }
                        axios.put('http://localhost:8080/update', data)
                            .then(response => {
                                console.log(response)
                                alert("Successfully Updated");
                            })
                            .catch(error => {
                                console.log(error)
                                alert("Error Updating");
                                console.log(data);
                            });
                    }
                },
                {
                    label: 'No',
                    onClick: () => alert("Deactivation of account aborted")
                }
            ]
        });


    }

    //To format the react date into normal format of yyyy-mm-dd
    function formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;
        return [year, month, day].join('-');
    }

    return (
        <div className="container pb-3 mt-5 border" style={{textAlign:"left"}}>

            <form className="ml-5 mr-5 pt-3" onSubmit={formik.handleSubmit}>
                <h2>Profile Details</h2>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label htmlFor='name'>Name:</label><br />
                        <input className="perftext" disabled="disabled" type='text' id='name' name='name' value={formik.values.name} onChange={formik.handleChange} />

                    </div>
                    <div className="form-group col-md-4">
                        <label htmlFor='name'>UserId:</label><br />
                        <input className="perftext" disabled="disabled" type='text' id='userId' name='userId' value={formik.values.userid} onChange={formik.handleChange} />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-group  col-md-4">
                        <label htmlFor='contact'>Contact:</label><br />
                        <input className="perftext" type='text' id='contact' name='contact' value={formik.values.contact} onChange={formik.handleChange} />
                        {formik.errors.contact ? <div style={{ color: 'red' }}>{formik.errors.contact}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='dob'>Date Of Birth:</label><br />
                        {/* <input className="perftext" type='text' id='dob' name='dob' value={formik.values.dob} onChange={formik.handleChange} /> */}
                        <DatePicker
                            className="perftext"
                            selected={formik.values.dob}
                            onChange={date => formik.setFieldValue('dob', date)}
                            name="dob"
                            dateFormat="yyyy-MM-dd"
                        />
                    {formik.errors.dob ? <div style={{ color: 'red' }}>{formik.errors.dob}</div> : null}

                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group  col-md-4">
                        <label htmlFor='email'>Email Id:</label><br />
                        <input className="perftext" type='text' id='email' name='email' value={formik.values.email} onChange={formik.handleChange} />
                        {formik.errors.email ? <div style={{ color: 'red' }}>{formik.errors.email}</div> : null}
                    </div>
                    <div className="form-group col-md-4">
                        <br />
                        <label>
                            <input type="checkbox" style={{ zoom: 1.5 }}
                                name="hasSubscribed"
                                value={formik.values.hasSubscribed}
                                checked={formik.values.hasSubscribed}
                                onChange={formik.handleChange}
                            />
                            <span> Subscribe </span>
                        </label>
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group  col-md-4">
                        <label htmlFor='password'>Password:</label><br />
                        <input className="perftext" type='password' id='password' name='password' value={formik.values.password} onChange={formik.handleChange} />
                        {formik.errors.password ? <div style={{ color: 'red' }}>{formik.errors.password}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='confpass'>Confirm Password:</label><br />
                        <input className="perftext" type='password' id='confpass' name='confpass' value={formik.values.confpass} onChange={formik.handleChange} />
                        {formik.errors.confpass ? <div style={{ color: 'red' }}>{formik.errors.confpass}</div> : null}
                    </div>
                </div>
                <div>
                    <button type='submit' onClick={UpdateUserDetail} className="btn savedetailsbut mr-5">Save Details</button>
                    <button type='submit' onClick={DeactivateAccount} className="btn savedetailsbut">Deactivate your Account</button>
                </div>
            </form>
        </div>
    )
}

export default UserProfile