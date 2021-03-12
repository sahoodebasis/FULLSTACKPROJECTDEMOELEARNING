import React, { Component } from "react";
import "../Stylesheets/Mystyle.css";
import "../Stylesheets/Login.css";
import AuthenticationService from "./AuthenticationService.js";
import { BrowserRouter as Router, Link } from "react-router-dom";
import elearning from "../api/elearning";

class Login extends Component {
  constructor() {
    super();
    this.state = {
      username: "",
      upassword: "",
      hasloginfailed: false,
      showsuccess: false,
      emptyvalue: false,
    };
  }

  handleClick = () => {
    let user = {
      email: this.state.username,
      password: this.state.upassword,
    };

    if (this.state.username === "" || this.state.upassword === "") {
      this.setState({
        emptyvalue: true,
      });
    }
    elearning
      .loginUser(user)
      .then((response) => this.login(response))
      .catch((error) => {
        console.log(error);
        this.setState({ hasloginfailed: true, showsuccess: false });
      });
  };

  login(response) {
    console.log("hi login");
    console.log(response);
    AuthenticationService.registerSuccessfulLogin(
      response.data.userId,
      response.data.email,
      response.data.role
    );
    this.setState({ hasloginfailed: false, showsuccess: true });
    if (response.data.role == "user" && response.data.isActive == true) {
      this.props.history.push({ pathname: "/home", state: { haslogin: true } });
    }
    if (response.data.role == "admin" && response.data.isActive == true) {
      this.props.history.push({
        pathname: "/allUsers",
        state: { haslogin: true },
      });
    }
    if (response.data.role == "vendor" && response.data.isActive == true) {
      this.props.history.push({ pathname: "/home", state: { haslogin: true } });
    }
    //this.props.history.push({pathname:'/WelcomePage',state:{haslogin:true}})
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  render() {
    return (
      <div className="container">
        <link
          href="https://fonts.googleapis.com/css?family=Indie+Flower|Overpass+Mono"
          rel="stylesheet"
        />
        <div>
          <h5>Login to your e-Learning Account!</h5>
        </div>
        {this.state.emptyvalue && (
          <div style={{ color: "red" }}>
            <ul>
              <li>Email is required</li>
              <li>Password is required</li>
            </ul>
          </div>
        )}
        {this.state.hasloginfailed && (
          <div>
            <h3 style={{ color: "red" }}>Invalid credentials</h3>
          </div>
        )}
        <div id="wrapper">
          <div class="main-content">
            <h3 style={{ color: "orange" }}>
              <b>Login</b>
            </h3>
            <div class="l-part">
              <input
                type="text"
                name="username"
                placeholder="Username"
                value={this.state.username}
                onChange={this.handleChange}
                class="input-1"
              />
              <div class="overlap-text">
                <input
                  type="password"
                  name="upassword"
                  placeholder="Password"
                  value={this.state.upassword}
                  onChange={this.handleChange}
                  class="input-2"
                />
              </div>
              <input
                type="button"
                value="Log in"
                className="btn btn-block"
                style={{ backgroundColor: "#ff253a", color: "white" }}
                onClick={this.handleClick}
              />
            </div>
          </div>
          <div class="sub-content">
            <div class="s-part">
              Don't have an account?
              <Link className="nav-link" to="/Signup">
                Sign up
              </Link>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
