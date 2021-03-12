import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardGroup from 'react-bootstrap/CardGroup';
import {useParams} from 'react-router-dom'

function SingleCourseDetailsSearch(props){
    let params = useParams();
    const styles = {
        card: {
          backgroundColor: '#ff9999',
          borderRadius: 55,
          padding: '3rem'
        //   color: '#FFFFFF'
        },
        cardImage: {
          objectFit: 'cover',
          borderRadius: 55,
          height: '100%'
        }
      }

    const [courseDetail,setCourseDetail]=useState({});
    
    const courseId=params.id;
    useEffect(()=>{
        axios.get('http://localhost:8080/getcoursedetailstouser/'+courseId).then(res=>{
            console.log(res.data);
            setCourseDetail(res.data);
            console.log(courseDetail);
        })
        .catch(err=>{
            console.log(err);
        })
    },[params.id])


return(
    
   <div >
      
   <CardGroup >
        <Card key={courseDetail.courseId} className="text-left m-3 border-0 shadow" style={styles.card}>
          <Row>
            
            <Col lg={8}>
              <Card.Body>
              <Card.Title as="h1">{courseDetail.name}</Card.Title>
              <Card.Text>
              <div>
              <h2 >{courseDetail.shortDescription} </h2>
              <p style={{fontWeight:'bold'}}>Price : ${courseDetail.price} <span className="float-right"> Duration : {courseDetail.duration} Mins</span>
                </p>
                <p>
                <Button id={courseDetail.courseId}   style={{backgroundColor:"#ff253a",color:"white"}} type = "submit"  size="lg">Buy now
                 </Button>   
                <span style={{fontWeight:'bold'}} className="float-right">Author : {courseDetail.author} </span>
              </p>
              </div>
              </Card.Text>
              </Card.Body>
            </Col>
            <Col lg={4}>
              <Card.Img src={courseDetail.picture} style={styles.cardImage} />
            </Col>
          </Row>
        </Card>
      </CardGroup>
      <div className="container">
        <div className="border 1 m-2 p-2">
            <h2> What you'll learn </h2>
            <li> {courseDetail.description} </li>
        </div>
        <div className="border 1 m-2 p-2">
            <h2> Languages availabe </h2>
            <li> {courseDetail.languages} </li>
        </div>
        <div className="border 1 m-2 p-2">
            <h2> Goals to be set </h2>
            <li> {courseDetail.learningGoals} </li> 
        </div>
        <div className="border 1 m-2 p-2">
            <h2> Requirements </h2>
            <li> {courseDetail.requirements} </li> 
        </div>    

    
    </div>
    </div>
);
}
export default SingleCourseDetailsSearch