import React,{Component} from 'react'
import {Route,Redirect} from 'react-router-dom';
import AuthenticationService from './AuthenticationService.js';

class AuthenticatedRoute extends Component {
    render() {
        if(AuthenticationService.isUserLoggedin()) {
            return(
                <div>
                    <Route {...this.props}/>
                </div>
            )    
        }
        else {
            return(
                <div>
                    <Redirect to="/login"/>
                </div>
            )
        } 
        
    }
}
export default AuthenticatedRoute