import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardDeck from 'react-bootstrap/CardDeck';
import {useHistory} from 'react-router-dom';
import AuthenticationService from "./AuthenticationService.js";

// const course=(

// )
const ListofCourseCards = (props) =>{
    const history=useHistory();
     console.log("hiii")
console.log(props)
console.log(props.location.list.data)
 const courseList = props.location.list.data;
const styles = {
    cardImage: {
      objectFit: 'cover'
    //   borderRadius: 55
    }}

    // const [courseList,setCourseList]=useState([]);

    // useEffect(()=>{
    //     axios.get('http://localhost:8080/getallcoursedetailstouser').then(res=>{
    //         console.log(res.data);
    //         setCourseList(res.data);
    //     })
    //     .catch(err=>{
    //         console.log(err)
    //     })
    // },[])
   var handleClick =()=> {

   }
    //var role="admin";
    var userid=AuthenticationService.getUserIdLoggedin();
    var role=AuthenticationService.getRoleLoggedin();
return(
    <div>
      <div style={{textAlign:"left",marginLeft:"20px"}}><button className="btn btn-outline-primary mr-1" style={{ backgroundColor: "#ff253a", color: "white" }} type="button" onClick={() => history.goBack()}>
        Back
      </button></div>
        
  {(role=="vendor")?<Button  style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" onClick={()=>history.push("/addcourse")} >Add New Course
        </Button>:<Button  style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" onClick={()=>history.push("/addcourseadmin")} >Add New Course
        </Button>}

   <div className=" m-2">
    <CardDeck>
  { courseList.map((course)=>
    <Col lg={3}> 
        <Card key={course.courseId} className="text-left mt-3">
        {/* <Card.Header style={{fontWeight:'bold'}}>{company.companyName}</Card.Header> */}
        <Card.Img variant="top" src={course.picture} style={styles.cardImage} />
        <Card.Body>
        <Card.Title>{course.name}</Card.Title>
        {/* <Card.Subtitle className=" text-muted">{course.shortDescription}</Card.Subtitle> */}
        <Card.Text>
        {course.shortDescription}
        </Card.Text>
        </Card.Body>
        <Card.Footer>
        <p style={{fontWeight:'bold'}}>Price : ${course.price} <span className="float-right">{course.duration} Mins</span>
        </p>
        <div className="text-center m-2">

        {(role=="vendor")?<Button className="m-2" id={course.courseId}   style={{backgroundColor:"red",color:"white",border:"1px solid white"}} type = "" onClick={()=>history.push({pathname:'/editcourse',state:{cId:course.courseId} })} >Edit Details
        </Button>:<Button className="m-2" id={course.courseId}   style={{backgroundColor:"red",color:"white",border:"1px solid white"}} type = "" onClick={()=>history.push({pathname:'/editcourseadmin',state:{cId:course.courseId} })} >Edit Details
        </Button>}

        {/* <Button id={course.courseId}   style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" onClick={handleClick}>Deactivate   */}
        {/* </Button> */}
        </div>
        
                     
        </Card.Footer>
        </Card>
    </Col>                    
    ) }
    </CardDeck>
    
    </div>
    
</div>
)
}
export default ListofCourseCards

// onClick={(e)=>handleSubmit(e,props.userid,company.companyId)}