import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import "../Stylesheets/Mystyle.css";
import ServiceCardComponent from "./ServiceCardComponent";
import Elearning from "../api/elearning.js";
import { useHistory,Link } from "react-router-dom";
import {
  CardDeck,
  Card,
  Button,
  Jumbotron,Container
} from "reactstrap";
class VendorOnlineServices extends Component {
  constructor(props) {
    super(props);
    this.state = {
      serviceList: [],
    };
    
  }

  

  handleClick = (serviceId) => {
    var userid=AuthenticationService.getUserIdLoggedin()
    var role=AuthenticationService.getRoleLoggedin()
    // var userid=8;
    // var role="vendor";
    if(role=="vendor") {
    Elearning.getVendorCoursesByServiceIdandUserId(userid,serviceId).then(
      (response) => {console.log(response);
      this.props.history.push({pathname:'/servicecoursevendoradmin',list:response})
       } );
    }
    if(role=="admin") {
        Elearning.getCoursesByVendorId(serviceId).then(
            (response) => {console.log(response);
            this.props.history.push({pathname:'/servicecoursevendoradmin',list:response})
             } );
          }
    }
    
  

  componentDidMount() {
    var userid=AuthenticationService.getUserIdLoggedin();
    var role=AuthenticationService.getRoleLoggedin();
    // var userid=9;
    // var role="vendor";
    if(role=="vendor") {
    Elearning.getVendorServices(userid)
      .then((response) => {
        console.log(response);
        this.setState({ serviceList: response.data });
      })
      .catch();
    }
    if(role=="admin") {
        Elearning.getserviceList()
      .then((response) => {
        console.log(response);
        this.setState({ serviceList: response.data });
      })
      .catch();
    }
  }
  render() {
    let flag = AuthenticationService.isUserLoggedin();
    var role=AuthenticationService.getRoleLoggedin();
    return (
      <div className="container" style={{justifyContent:"center"}}>
        <h1 style={{color: "#ff253a"}}>OUR SERVICES</h1>
        {(role=="admin") &&<h3>Hey<i style={{ color: "#ff253a"}}> Admin.</i> want to add new service? click here!! <Link to="/addservice">Add Service</Link></h3>}
        
          <div style={{ align: "centre" }}>
            {this.state.serviceList.map((service) => {
              return (
                <ServiceCardComponent
                  name={service.serviceName}  id={service.serviceId}
                  onClick={() => this.handleClick(service.serviceId)}>
                </ServiceCardComponent>
              );
            })}
          </div>
      </div>
    );
  }
}
export default VendorOnlineServices;
