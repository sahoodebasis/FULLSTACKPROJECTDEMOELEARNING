import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardDeck from 'react-bootstrap/CardDeck';
// import {SingleCourseDetail} from './singlecoursedetail';
import {useHistory} from 'react-router-dom';
import '../Stylesheets/Pagination.css';
 

export function ListofCourseCards(props){
    const history=useHistory();
    const handleSubmit=(e, userId,courseId,props) =>{
        // courseId=2;
        console.log("courseId "+courseId);
      
        history.push({
            pathname:'/singlecoursedetails',
            state:{cId:courseId}
        });
        
        }
        const handleClick=(event) =>{
                setcurrentPage(Number(event.target.id))
        }
        
    

    var courseList=props.courseList;
    const [currentPage,setcurrentPage]=useState(1);
    const [courseListPerPage,setcourseListPerPage]=useState(8);

    
const styles = {
    cardImage: {
      objectFit: 'cover'
    //   borderRadius: 55
    }}

    const indexOfLastCourseCard = currentPage * courseListPerPage;
    const indexOfFirstCourseCard = indexOfLastCourseCard - courseListPerPage;
    const currentcourseList = courseList.slice(indexOfFirstCourseCard, indexOfLastCourseCard);

    const renderCourseList = currentcourseList.map((course, index) => {
        return (
            //   <div>
            <Col lg={3} key={index}>
                <Card key={course.courseId} className="text-left mt-3">

                    <Card.Img variant="top" src={course.picture} style={styles.cardImage} />
                    <Card.Body>
                        <Card.Title>{course.name}</Card.Title>
                        {/* <Card.Subtitle className=" text-muted">{course.shortDescription}</Card.Subtitle> */}
                        <Card.Text>
                            {course.shortDescription}
                        </Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <p style={{ fontWeight: 'bold' }}>Price : ${course.price} <span className="float-right">{course.duration} Mins</span>
                        </p>
                        <Button id={course.courseId} onClick={(e) => handleSubmit(e, props.userId, course.courseId)} style={{ backgroundColor: "#ff253a", color: "white" }} type="submit" >Details
          </Button>

                    </Card.Footer>
                </Card>
            </Col>
            //   </div>
        )
    }
    )
    const pageNumbers = [];
    for (let i = 1; i <= Math.ceil(courseList.length / courseListPerPage); i++) {
        pageNumbers.push(i);
    }

    const renderPageNumbers = pageNumbers.map(number => {
        return (
            <li
                key={number}
                id={number}
                onClick={handleClick}
            >
                {number}
            </li>
        );
    });

    return (


        <div>
            <div className=" m-3">
                <CardDeck >
                    {renderCourseList}
                </CardDeck>
            </div>
            
            <ul id="page-numbers">
                    {renderPageNumbers}
                </ul>
           
        </div>
    )
}

// onClick={(e)=>handleSubmit(e,props.userid,company.companyId)}