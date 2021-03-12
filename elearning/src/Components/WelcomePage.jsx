import React from 'react'
import '../Stylesheets/Mystyle.css'
import {BrowserRouter as Router,Link} from 'react-router-dom'


function WelcomePage(props) {
    return(
        
        <div>
            <h1>Welcome</h1>
            <div className="container">
            <h3>welcome hi to the todoapp. click here <Link to="/todolist">todolist</Link></h3>    
        </div>
        
        </div>
    )
}

export default WelcomePage