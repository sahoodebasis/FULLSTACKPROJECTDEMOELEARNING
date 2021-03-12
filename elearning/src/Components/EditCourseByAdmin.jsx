import React, { Component, useEffect, useState } from 'react';
import { useFormik } from 'formik'
// import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../Stylesheets/Signup.css'
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css"
import axios from 'axios'
import moment from 'moment'
import AuthenticationService from "./AuthenticationService.js";
import { useHistory } from 'react-router-dom'

function EditCourseByAdmin(props) {
    let history = useHistory()
    const [initvalues, setInitValues] = useState({});
    const [services, setServices] = useState([]);
    const formik = useFormik({
        initialValues: {
            courseId: null,
            courseName: "",
            courseCategory: "",
            shortDescription: "",
            vendorId: null,
            isActive: true,
            price: null,
            duration: null,
            dateOfLaunch: new Date(),
            imgurl: "",
            languages: "",
            learninggoals: "",
            requirements: "",
            courseDescription: "",
            author: "",
            serviceId: null
        },
        onSubmit: values => {
            console.log('Form data', values)
        },
        validate: values => {
            let errors = {}
            if (!values.courseName) {
                errors.courseName = "Course Name is Required"
            }
            if (!values.courseCategory) {
                errors.courseCategory = "Course Category  is Required"
            }
            if (!values.shortDescription) {
                errors.shortDescription = "Enter short description about the course"
            }
            if (!values.price) {
                errors.price = "Enter price"
            }
            if (!values.duration) {
                errors.duration = "Enter course duration in hrs"
            }
            if (!values.imgurl) {
                errors.imgurl = "Enter image link"
            }
            if (!values.languages) {
                errors.languages = "Enter course languages"
            }
            if (!values.learninggoals) {
                errors.learninggoals = "Enter learning goals of course"
            }
            if (!values.requirements) {
                errors.requirements = "Enter course requirements"
            }
            if (!values.courseDescription) {
                errors.courseDescription = "Enter course description"
            }
            if (!values.author) {
                errors.author = "Enter author Name"
            }
            if (!values.serviceId) {
                errors.serviceId = "Select Some Service"
            }
            return errors
        }
    })

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

    //fetching all services
    useEffect(() => {
        axios.get('http://localhost:8080/services')
            .then(response => {
                console.log(response)
                setServices(response.data)
            })
            .catch(error => {
                console.log(error)
            })

        //give courseId using props here
        // axios.get('`http://localhost:8080/getcoursedetails/${props.courseId}`)
        var userid=AuthenticationService.getUserIdLoggedin();
        var cId = props.location.state.cId;
        axios.get(`http://localhost:8080/getcoursedetails/${cId}`)
            .then(response => {
                // response.data.foreach()

                console.log("hi")
                setInitValues(response.data)
                formik.setFieldValue('courseId', response.data.courseId)
                formik.setFieldValue('courseName', response.data.name)
                formik.setFieldValue('courseCategory', response.data.courseCategory)
                formik.setFieldValue('shortDescription', response.data.shortDescription)
                formik.setFieldValue('dateOfLaunch', new Date(response.data.dateOfLaunch))
                formik.setFieldValue('price', response.data.price)
                formik.setFieldValue('duration', response.data.duration)
                formik.setFieldValue('isActive', response.data.active)
                formik.setFieldValue('serviceId', response.data.service.serviceId)
                formik.setFieldValue('imgurl', response.data.picture)
                formik.setFieldValue('languages', response.data.languages)
                formik.setFieldValue('learninggoals', response.data.learningGoals)
                formik.setFieldValue('requirements', response.data.requirements)
                formik.setFieldValue('courseDescription', response.data.description)
                formik.setFieldValue('author', response.data.author)
                console.log(response)
            })
            .catch(error => {
                console.log(error)
                alert("Error Registering");
            });



    }, [])

    function EditCourseDetail() {

        var indexser = {}
        for (var i = 0; i < services.length; i++) {
            if (services[i].serviceId === parseInt(formik.values.serviceId, 10)) {
                indexser = services[i]
                console.log("indexser", indexser)
                break;
            }

        }

        const data = {
            //no need to give courseId while adding course but we need to give courseId while updating course
            courseId: formik.values.courseId,
            name: formik.values.courseName,
            courseCategory: formik.values.courseCategory,
            shortDescription: formik.values.shortDescription,
            vendorId: initvalues.vendorId,
            price: formik.values.price,
            active: formik.values.isActive,
            duration: formik.values.duration,
            dateOfLaunch: formatDate(formik.values.dateOfLaunch),
            picture: formik.values.imgurl,
            languages: formik.values.languages,
            learningGoals: formik.values.learninggoals,
            requirements: formik.values.requirements,
            description: formik.values.courseDescription,
            author: formik.values.author,
            service: indexser

        }
        console.log("Hi activation test", data)
        if (Object.values(formik.errors).length === 0) {
            axios.post('http://localhost:8080/addcourses', data)
            .then(response => {
                console.log(response)
                alert("Course Successfully Updated");
                
            })
            .catch(error => {
                console.log(error)
                alert("Error Updating course");
                
            });
        }
        else {
            alert('Fill all entries')
        }
    }

    return (
        
        
        <div className="container pb-3 mt-5 border" style={{textAlign:"left"}}>

            <form className="ml-5 mr-5 pt-3" onSubmit={formik.handleSubmit}>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <h2 >Edit Course</h2>
                    </div>
                    <div className="form-group col-md-4">
                    </div>
                    <div className="form-group col-md-4">
                        <h5>VendorId: {initvalues.vendorId}</h5>
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group col-md-4">
                        <label htmlFor='courseName'>Name:</label><br />
                        <input className="perftext" type='text' id='courseName' name='courseName' value={formik.values.courseName} onChange={formik.handleChange} />
                        {formik.errors.courseName ? <div style={{ color: 'red' }}>{formik.errors.courseName}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='courseCategory'>Course Category</label><br />
                        {/* <input className="perftext" type='number' id='courseCategory' name='courseCategory' value={formik.values.courseCategory} onChange={formik.handleChange} /> */}
                        <select className="perftext" id="courseCategory" name="courseCategory" value={formik.values.courseCategory} onChange={formik.handleChange}>
                            <option hidden selected>choose...</option>
                            <option value="self-learning">Self-Learning</option>
                            <option value="instructor-led">Instructor-Led</option>
                            <option value="assessment">Assessment</option>
                        </select>
                        {formik.errors.courseCategory ? <div style={{ color: 'red' }}>{formik.errors.courseCategory}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='shortDescription'>Short Description:</label><br />
                        <input className="perftext" type='text' id='shortDescription' name='shortDescription' value={formik.values.shortDescription} onChange={formik.handleChange} />
                        {formik.errors.shortDescription ? <div style={{ color: 'red' }}>{formik.errors.shortDescription}</div> : null}
                    </div>

                </div>

                <div className="form-row">
                    <div className="form-group  col-md-4">
                        <label htmlFor='dateOfLaunch'>Date Of Launch:</label><br />
                        {/* <input className="perftext" type='text' id='dob' name='dob' value={formik.values.dob} onChange={formik.handleChange} /> */}
                        <DatePicker
                            className="perftext"
                            selected={formik.values.dateOfLaunch}
                            onChange={date => formik.setFieldValue('dateOfLaunch', date)}
                            name="dateOfLaunch"
                            dateFormat="yyyy-MM-dd"
                        />
                    </div>

                    <div className="form-group  col-md-4">
                        <label htmlFor='price'>Price:</label><br />
                        <input className="perftext" type='number' id='price' name='price' value={formik.values.price} onChange={formik.handleChange} />
                        {formik.errors.price ? <div style={{ color: 'red' }}>{formik.errors.price}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='duration'>Duration:</label><br />
                        <input className="perftext" type='number' id='duration' name='duration' value={formik.values.duration} onChange={formik.handleChange} />
                        {formik.errors.duration ? <div style={{ color: 'red' }}>{formik.errors.duration}</div> : null}
                    </div>
                </div>
                <div className="form-row">
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
                    <div className="form-group col-md-4">
                        <label>Select Service</label><br />
                        <select className="perftext" name="serviceId" value={formik.values.serviceId} onChange={formik.handleChange}>
                            <option hidden selected>Choose ...</option>
                            {services.map(service => {
                                return (
                                    <option value={service.serviceId}> {service.serviceName} </option>
                                )
                            })}

                        </select>
                        {formik.errors.serviceId ? <div style={{ color: 'red' }}>{formik.errors.serviceId}</div> : null}
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group  col-md-4">
                        <label htmlFor='imgurl'>ImgUrl</label><br />
                        <input className="perftext" type='text' id='imgurl' name='imgurl' value={formik.values.imgurl} onChange={formik.handleChange} />
                        {formik.errors.imgurl ? <div style={{ color: 'red' }}>{formik.errors.imgurl}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='languages'>Languages</label><br />
                        <input className="perftext" type='text' id='languages' name='languages' value={formik.values.languages} onChange={formik.handleChange} />
                        {formik.errors.languages ? <div style={{ color: 'red' }}>{formik.errors.languages}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='learninggoals'>Learning Goals</label><br />
                        <input className="perftext" type='text' id='learninggoals' name='learninggoals' value={formik.values.learninggoals} onChange={formik.handleChange} />
                        {formik.errors.learninggoals ? <div style={{ color: 'red' }}>{formik.errors.learninggoals}</div> : null}
                    </div>
                </div>
                <div className="form-row">

                    <div className="form-group  col-md-4">
                        <label htmlFor='requirements'>Pre-requisite for Course</label><br />
                        <input className="perftext" type='text' id='requirements' name='requirements' value={formik.values.requirements} onChange={formik.handleChange} />
                        {formik.errors.requirements ? <div style={{ color: 'red' }}>{formik.errors.requirements}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='courseDescription'>Course Description</label><br />
                        <input className="perftext" type='text' id='courseDescription' name='courseDescription' value={formik.values.courseDescription} onChange={formik.handleChange} />
                        {formik.errors.courseDescription ? <div style={{ color: 'red' }}>{formik.errors.courseDescription}</div> : null}
                    </div>
                    <div className="form-group  col-md-4">
                        <label htmlFor='author'>Author</label><br />
                        <input className="perftext" type='text' id='author' name='author' value={formik.values.author} onChange={formik.handleChange} />
                        {formik.errors.author ? <div style={{ color: 'red' }}>{formik.errors.author}</div> : null}
                    </div>
                </div>
                {/* Write edit course accordingly in place of add course */}
                <button type='submit' onClick={EditCourseDetail} className="btn addcoursebut" >Edit Course</button>
            </form>
        </div >
        
    )
}

export default EditCourseByAdmin