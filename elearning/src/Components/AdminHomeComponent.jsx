import React, { Component } from "react";
import "../Stylesheets/Mystyle.css";
import Elearning from "../api/elearning.js";
import {BrowserRouter as Router,Link} from 'react-router-dom'

class AdminHomeComponent extends Component {
  constructor(props) {
    super(props);
    console.log("hello");
    //console.log(this.props.location.list.data)
    this.state = {
      UserList: [],
    };
  }

  componentDidMount() {
    Elearning.getusersList()
      .then((response) => {
        console.log(response);
        this.setState({ UserList: response.data });
      })
      .catch();
  }

  handleClick = (email) => {
    let e = email;
    Elearning.getusersList()
    .then((response) => {
      console.log(response);
      this.setState({ UserList: response.data });
      this.props.history.push({pathname:'/editUser',eMail:e});
    })
    .catch();
  };

  render() {
    console.log(this.state.UserList);
    return (
      <div className="container">
        <h1  style={{ color: "#ff253a"}}>USERS LIST</h1>
        <h3>Hey<i style={{ color: "#ff253a"}}> Admin.</i> want to add new User? click here!! <Link to="/addUser">Add User</Link></h3>
        <div className="container">
          <div className="table-wrapper-scroll-y my-custom-scrollbar">
            <table className="table table-bordered table-striped table-hover mb-0">
              <thead>
                <tr>
                  {/* <th>Id</th> */}
                  <th className="theader" scope="col">
                    Serial No.
                  </th>
                  <th className="theader" scope="col">
                    User Id
                  </th>
                  <th className="theader" scope="col">
                    UserName
                  </th>
                  <th className="theader" scope="col">
                    Email
                  </th>
                  <th className="theader" scope="col">
                    Role
                  </th>
                  <th className="theader" scope="col">
                    Edit
                  </th>
                </tr>
              </thead>
              <tbody>
                {this.state.UserList.map((user, index) => {
                  return (
                    <tr>
                      {/* <td>{todo.id}</td> */}
                      <td>
                        <b>{index + 1}</b>
                      </td>
                      <td>{user.userId}</td>
                      <td>{user.name}</td>
                      <td>{user.email}</td>
                      <td>{user.role}</td>
                      <td>
                        <button
                          style={{ backgroundColor: "#ff253a", color: "white" }}
                          onClick={(e)=>this.handleClick(user.email)}
                        >
                          Edit
                        </button>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}

export default AdminHomeComponent;
