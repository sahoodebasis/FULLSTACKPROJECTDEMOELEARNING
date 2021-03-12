import React from "react";
import { Card, Button, CardTitle, Jumbotron, CardBody } from "reactstrap";
import AuthenticationService from "./AuthenticationService.js";
import {useHistory,Link} from 'react-router-dom';

function ServiceCardComponent(props) {
console.log("hi service ")
console.log(props.id)
  var servicesid = props.id
  const history=useHistory();
  var userid=AuthenticationService.getUserIdLoggedin();
  var role = AuthenticationService.getRoleLoggedin();

  return (
    <div>
      <Jumbotron
        className="p-0"
        style={{  
            // //backgroundImage: "url(" + "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuTOr34qDlLpVYbdPOv5gQYj16TdE2ctj9MA&usqp=CAU" + ")",
            // backgroundPosition: 'center',
            // backgroundSize: 'cover',
            // backgroundRepeat: 'no-repeat',
            backgroundColor :"#df8f97",
            color:"black"
          }}
      >
        <h1 className="display-3">{props.name}</h1>
        <p className="lead">
          This is a {props.name} service . click here to explore and use our
          services of e-learning application!!!
        </p>
        <hr className="my-2" />
        <p className="lead">
        {(role=="user") && <Button className="btn btn-outline-primary mr-1" style={{ backgroundColor: "#ff253a", color: "white" }} onClick={props.onClick}>Show Courses</Button>}
        {(role!="user") &&  <Button className="btn btn-outline-primary mr-1" style={{ backgroundColor: "#ff253a", color: "white" }} onClick={props.onClick}>Show Orders</Button>}
          {(role=="admin") &&<Button className="btn btn-outline-primary" style={{ backgroundColor: "#ff253a", color: "white" }} onClick={()=>history.push({pathname:'/editservice',serviceid:servicesid})}>Edit Services</Button>}
        </p>
      </Jumbotron>
    </div>
  );
}

export default ServiceCardComponent;
