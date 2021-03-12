import React, {Component} from 'react';
import List from './List';
import Form from './Form';
import '../Stylesheets/Review.css'
import axios from 'axios';
import AuthenticationService from "./AuthenticationService.js";
 
class Review extends Component {
    constructor(props)
    {
        super(props);
        
        this.state = {
            reviews: []          
        };

        // this.submitForm = this.submitForm.bind(this);
    }
    
    componentDidMount(){
        console.log("inside review componentDidmount top of axios "+this.props.courseId);

        axios.get('http://localhost:8080/getReviews/'+this.props.courseId).then(res=>{
            this.setState({reviews:res.data});    
        const reviewdata=res.data;
    
            // console.log("review data "+JSON.stringify(this.state.reviews[0].courseId));
            
        })
    }

  
    render()
    {   
        var userid=AuthenticationService.getUserIdLoggedin()
        return (

            
            <div className="bg-light-gray global-padding-bottom">
                <section className="reviews">

                    <header className="hero bg-black text-color-white global-padding-vertical overlay">
                        <div className="area align-center text-center row">
                            <h1 className="small-12 medium-6 columns">
                                <span className="font-weight-regular">Reviews</span><br />
                            </h1>
                        </div>
                    </header>

                    <div className="row align-center content-margin-top-negative">
                        <div className="small-12 medium-8 large-6 columns">
                            <div className="content-padding bg-white area">

                           {/* {this.renderList()} */}
                           <List reviews={this.state.reviews}/>
                           </div>
                            {/* {false&&this.renderForm()} */}
                         
                           { this.props.isComplete&&<Form userId={userid} courseId={this.props.courseId}/>
                           }
                            
                        </div>
                    </div>


                </section>
            </div>

        );
    }

   
}

export default Review;