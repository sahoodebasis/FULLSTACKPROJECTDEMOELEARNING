import React,{Component} from 'react'
import '../Stylesheets/Mystyle.css'
import {BrowserRouter as Router,Link} from 'react-router-dom'
import AuthenticationService from './AuthenticationService.js';
import { withRouter } from 'react-router';
import SearchComponent from './SearchComponent';
import Notification from './notification'
import Search from '../Components/Search/Search';

class MenuComponent extends Component {
    constructor() {
        super();
        this.state={
            isActive:false
        }
    }
    changeNotification=()=>{
        this.setState({isActive:false})
    }

    render() {
        let userLoggedin = AuthenticationService.isUserLoggedin()
        let role = AuthenticationService.getRoleLoggedin()
        
        return(
            
            <header>
                    <nav className="navbar fixed-top navbar-expand-lg navbar-dark bg-dark border" style={{height:"70px"}} >
                        <div>
                            <a href="https://www.google.com" className="navbar-brand">e-Learning</a>
                        </div>
                        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarCollapse">
                            <ul className="navbar-nav mr-auto collapse navbar-collapse">
                                <li><Link className="nav-link active" to="/courses">Courses</Link></li>
                              { userLoggedin && <li><Link className="nav-link active" to="/profile">MyProfile</Link></li>}
                                {userLoggedin && (role!="admin") &&<li><Link className="nav-link active" to="/userorders">PurchaseHistory</Link></li>}
                                {userLoggedin && (role=="vendor") &&<li><Link className="nav-link active" to="/vendorServices">Orders</Link></li>}
                                {userLoggedin &&  (role=="user") && <li><Link className="nav-link active" to="/userServices">OnlineServices</Link></li>}
                                
                                {userLoggedin &&  (role!="user") && <li><Link className="nav-link active" to="/vendoronlineservice">OnlineServices</Link></li>}
                                {userLoggedin &&  (role=="admin") && <li><Link className="nav-link active" to="/allUsers">UserList</Link></li>}
                                <form class="form-inline my-2 my-lg-0">
                                    {/* <input class="form-control mr-lg-2" type="search" placeholder="Search for anything" aria-label="Search" style={{width:"480px",borderRadius: "40px"}}/> */}
                                 {userLoggedin && <Search></Search>} 
                                    {/* <button class="btn btn-light my-2 my-sm-0" style={{backgroundColor:"#ff253a",color:"white"}} type="submit">Search</button> */}
                                   
                                </form>
                             </ul>
                            <ul className="navbar-nav ml-auto navbar-collapse justify-content-end">
                            {/* {!userLoggedin && <li><button className="btn btn-light" type="button"><Link className="nav-link" to="/login">Login</Link></button></li>}
                            {!userLoggedin && <li><button className="btn btn-primary" type="button"><Link className="nav-link" to="/logout">Logout</Link></button></li>} */}
                            {!userLoggedin && <li><Link className="nav-link active" to="/login">Login</Link></li>}
                            {!userLoggedin && <li><Link className="nav-link active" to="/signup">Signup</Link></li>}
                            {/* {userLoggedin && <button className="btn btn-outline-success" type="button" onClick={AuthenticationService.logout}>Logout</button>} */}
                            {userLoggedin &&  (role!="admin") &&  <li><button className="btn btn-outline-primary mr-1" style={{ backgroundColor: "#ff253a", color: "white" }} onClick={()=>this.setState({isActive:true})}>Notifications</button></li>}
                            <Notification isactive={this.state.isActive} change = {this.changeNotification} ></Notification>
                            {userLoggedin && <li><Link className="nav-link active" to="/login" onClick={AuthenticationService.logout}>Logout</Link></li>}
                            </ul>
                        </div>
                    </nav>
                </header>
                        
        )
    }
}
export default withRouter(MenuComponent)