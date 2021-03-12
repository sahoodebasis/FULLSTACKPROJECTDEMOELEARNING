import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import "../Stylesheets/Mystyle.css";
import ServiceCardComponent from "./ServiceCardComponent";
import Elearning from "../api/elearning.js";
import { useHistory } from "react-router-dom";
import {
  CardDeck,
  Card,
  Button,
  Jumbotron,Container
} from "reactstrap";
class UserServices extends Component {
  constructor(props) {
    super(props);
    this.state = {
      serviceList: [],
    };
  }
  handleClick = (serviceId) => {
      let serviceid=serviceId;
    this.props.history.push({pathname:'/servicecourse',list:serviceid})
    // var userid=AuthenticationService.getUserIdLoggedin()
    // Elearning.getVendorOrdersByServiceId(serviceId, 7).then(
    //   (response) => {console.log(response);
    //   this.props.history.push({pathname:'/servicecourse',list:response})
    //    } );
  };

  componentDidMount() {
    //var userid=AuthenticationService.getUserIdLoggedin()
    Elearning.getserviceList()
      .then((response) => {
        console.log(response);
        this.setState({ serviceList: response.data });
      })
      .catch();
  }

  render() {
    let flag = AuthenticationService.isUserLoggedin();
    return (
      <div className="container" style={{justifyContent:"center"}}>
        <h1 style={{color: "#ff253a"}}>OUR SERVICES</h1>
        
          <div style={{ align: "centre" }}>
            {this.state.serviceList.map((service) => {
              return (
                <ServiceCardComponent
                  name={service.serviceName}
                  onClick={() => this.handleClick(service.serviceId)} >
                </ServiceCardComponent>
              );
            })}
          </div>
      

       
      </div>
    );
  }
}
export default UserServices;
