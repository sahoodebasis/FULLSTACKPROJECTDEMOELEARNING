import React, { useState } from 'react';
import { Button , Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import {useHistory,Redirect} from 'react-router-dom';
import AuthenticationService from "./AuthenticationService.js";
import axios from 'axios'

// var userid=AuthenticationService.getUserIdLoggedin();
const  ModalExample = (props) => {
  console.log("hi modal")
  console.log(props)
  const history=useHistory();

    const {
        buttonLabel,
        className
 } = props
    const [modal, setModal] = useState(false);
  
    const toggle = () => setModal(!modal);
    const toggle1 = () => {
      setModal(!modal)
      history.push('/userorders')
    };
    const trying = (event) => {console.log("Chal rha h ")
    event.preventDefault();
        const data={

          
            userid: AuthenticationService.getUserIdLoggedin(),
            courseid: props.courseId,
            serviceid:props.serviceId
        
        }
        axios.post("http://localhost:8080/orders/order",data)
        .then(res=>{res.status===200?
        alert(res.data)
        :
        alert("Adding Failed")
        
    });
    toggle1()
  
  };
  
    return (
      <span>
        <Button color="success" onClick={toggle}>{buttonLabel}</Button>
        <Modal isOpen={modal} toggle={toggle} className={className}>
          <ModalHeader toggle={toggle}>Confirm payment</ModalHeader>
          <ModalBody>
              Are you sure you want to continue with payment?
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={trying}>Yes</Button>{' '}
            {/* <Button color="primary" onClick={toggle1}>Yes</Button>{' '} */}
            <Button color="secondary" onClick={toggle}>No</Button>
          </ModalFooter>
        </Modal>
      </span >
    );
  }

  export default ModalExample;