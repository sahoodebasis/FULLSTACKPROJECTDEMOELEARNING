import React, {Component} from 'react';
import AuthenticationService from './AuthenticationService'

var len=0;
class List extends Component {
    
    render() {
        len=this.props.reviews.length;
        console.log("length of review "+len);

    if(len>0){
       return (
            <ul className="reviews__list">
                {this.props.reviews.map((review, index) => <Review index={index} review={review}/>)}
            </ul>
        );
    }
        else{
            return (
                <h5> No reviews to show.</h5>
            )
        }

    }
}

class Review extends Component {

    render()
    { 
        return (
            <li key={this.props.index} className="reviews__list-item reset-list block-padding-vertical">
                <div className="review area">
                    <h3 className="review__title"> *****</h3>

                    <div className="review__content">
                        {this.props.review.description}
                    </div>
                </div>
            </li>
        );
    }

   
}
export default List;