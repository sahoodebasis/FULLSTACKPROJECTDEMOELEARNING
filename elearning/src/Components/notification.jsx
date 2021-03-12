import { useEffect, useState } from "react";
import { Button, Modal } from "react-bootstrap";
import axios from 'axios'
import AuthenticationService from "./AuthenticationService.js";

function Notification(props) {
    console.log(props)
   // let isActive= props.isactive
   
    const [show, setShow] = useState(false);
    const handleClose = () => {
        setShow(false);
        props.change()
    }
    const handleShow = () => setShow(true)

    const [notifications, setNotification] = useState([]);

    useEffect(() => {
        // pass props userid here
        getNotification()
    }, [])


    function handleClear() {
        //pass props userid here
        var userid=AuthenticationService.getUserIdLoggedin();
        axios.delete(`http://localhost:8080/deletenot/${userid}`)
            .then(response => {
                console.log(response)
                getNotification()
                //setNotification([])
                alert("notification cleared")
                window.location.reload();
            })
            .catch(error => {
                console.log(error)
            })
        props.change()
        setShow(false);
    }

    function getNotification() {
        var userId=AuthenticationService.getUserIdLoggedin();
        axios.get(`http://localhost:8080/getnot/${userId}`)
            .then(response => {
                console.log(response)
                setNotification(response.data)
            })
            .catch(error => {
                console.log(error)
            })

    }

    return (
        <>
            {/* <Button variant="primary" onClick={handleShow}>
                Launch demo modal
        </Button> */}

            <Modal show={props.isactive} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Notifications for Added/Updated Courses</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <ul>
                        {notifications.map(notification => {
                            return (
                                <li> {notification.description} </li>
                            )
                        })}
                    </ul>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClear}>
                        Clear All
            </Button>
                    {/* <Button variant="primary" onClick={handleClose}>
                        Save Changes
            </Button> */}
                </Modal.Footer>
            </Modal>
        </>
    );
}
export default Notification;
// render(<Example />);