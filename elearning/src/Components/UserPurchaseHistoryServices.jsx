import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import "../Stylesheets/Mystyle.css";
import ServiceCardComponent from "./ServiceCardComponent";
import Elearning from "../api/elearning.js";
import {
    CardDeck,
  } from "reactstrap";
class UserPurchaseHistoryServices extends Component {
  constructor(props) {
    super(props);
    this.state = {
      serviceList: [],
    };
  }
  // handleClick = (serviceId) => {
  //     var userid=AuthenticationService.getUserIdLoggedin()
  //     Elearning.getUserCourseList({userId:userid,serviceId:serviceId})
  //     .then(response=>
  //         console.log(response),
  //         alert("successfully see the courseList of user.")
  //         )

  // }

  componentDidMount() {
    var userid=AuthenticationService.getUserIdLoggedin()
    Elearning.getUserPurchasedServices(userid)
      .then((response) => {
        console.log(response);
        this.setState({ serviceList: response.data });
      })
      .catch();
  }

  render() {
    let flag = AuthenticationService.isUserLoggedin();
    return (
      <div className="container">
        <h1>Purchased Services</h1>
        <CardDeck>
          <div className="col-md-3">
            {this.state.serviceList.map((service) => {
              return (
                <ServiceCardComponent
                  name={service.serviceName}
                  onClick={() => this.handleClick(service.serviceId)}
                >
                </ServiceCardComponent>
              );
            })}
          </div>
        </CardDeck>
      </div>
    );
  }
}
export default UserPurchaseHistoryServices;
