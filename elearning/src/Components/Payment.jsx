import React from 'react';
import {Link, Switch, Route} from 'react-router-dom'
import { Button, Form, Col, FormGroup, Label, Input} from 'reactstrap';
import ModalExample from './ModalExample';
import AuthenticationService from "./AuthenticationService.js";
import {useHistory} from 'react-router-dom';

const Payment = (props) => {
    const history=useHistory();
    console.log("hellohi")
    console.log(props.location.state.course)
    var userid=AuthenticationService.getUserIdLoggedin();

    return(
        <div className="container-fluid">
            <h1> Make Payment</h1><br/><br/>
            <Form>
                <FormGroup row>
                <Col lg={2}>
                    <Label for="course">Course Name</Label>
                    </Col>
                    <Col lg={6}>
                    <Input type="text" name="course" id="course" value={props.location.state.course.name} disabled></Input>
                    </Col>
                </FormGroup>
                
                <FormGroup row>
                    <Col lg={2}>
                    <Label for="userid">User Id</Label>
                    </Col>
                    
                    <Col lg={6}>
                        <Input type="text" name="userid" id="userid" value={userid} disabled="true"></Input>
                    </Col>
                    
                </FormGroup>
                    
                <FormGroup row>
                <Col lg={2}>
                    <Label for="price">Price</Label>
                    </Col>
                    <Col lg={6}>
                    <Input type="text" name="price" id="price" value={props.location.state.course.price} disabled="true"></Input>
                    </Col>
                    
                </FormGroup>
                <ModalExample buttonLabel="Pay" courseId={props.location.state.course.courseId} serviceId ={props.location.state.course.service.serviceId} className="Button"/>{' '}
                <Button onClick={()=>history.push('/courses')}>Cancel payment</Button>
                
            </Form>
        </div>
    );
}

export default Payment