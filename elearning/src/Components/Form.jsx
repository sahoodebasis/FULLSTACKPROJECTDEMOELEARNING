import React, {Component} from 'react';
import axios from 'axios';
import { Redirect } from "react-router-dom";
class Form extends Component {
    constructor(props)
    {   
        super(props);
        console.log("props of Form class "+JSON.stringify(props));

        this.state = {
            // isActive:false,
            // isSubmitted:false,
            name: '',
            description: '',
            redirect: null
            
            // userId: this.props.userId,
            // courseId: this.props.courseId

        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    render()
    {
        if (this.state.redirect) {
            return <Redirect to={this.state.redirect} />
          }
        return (
            <div >

                <form onSubmit={this.handleSubmit}>
                    <div className="form-group m-3">
	            	
                    <h5 className="text-center">Add your review</h5>
                    {/* <input type="text" value={this.state.name} name="name" placeholder="Name(User Id)"
                           onChange={this.handleInputChange}/> */}
                       <div className="input-group">
                    <div className="input-group-prepend">
                    <span className="input-group-text" id="basic-addon">
                </span>
                </div>
                    <textarea  rows="4" className="form-control" name="description"  value={this.state.description} placeholder="Review Description"
                              onChange={this.handleInputChange}/>
    
                    </div>
                    </div>
                    <button className="button "  size="lg">
                    Submit Review
                    </button>
                </form>
            </div>
        )
    }

    
   
    handleInputChange(event)
    {
      
        const value = event.target.value;
        const name = event.target.name;

        this.setState({...this.state, [name]: value})
    }


    handleSubmit = (event) => {
        event.preventDefault();
        const data={

          
            userId: this.props.userId,
            courseId: this.props.courseId,
            description:this.state.description
        
        }
        console.log("userId in handlesumbit "+this.props.userId);
        console.log("courseId in handlesumbit "+this.props.courseId);
        console.log("Data to post "+JSON.stringify(data));
        axios.post("http://localhost:8080/addReview",data)
        .then(res=>{res.status===200?
        alert("Successfully added. "):
        alert("Adding Failed")
        this.setState({name:"",description:"",redirect:"/userorders"})        
    });
        

}
}


export default Form;






