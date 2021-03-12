import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardDeck from 'react-bootstrap/CardDeck';
import {useParams,useLocation, useHistory} from 'react-router-dom';
import AuthenticationService from '../../Components/AuthenticationService'

// const course=(

// )
 const ListofAllCoursesSearchByVendorId = (props) =>{
     var userId=AuthenticationService.getUserIdLoggedin()
     let role=AuthenticationService.getRoleLoggedin()
    let location = useLocation();
    let history = useHistory();
    const vendorId = location.state;
    console.log("yoy yo",vendorId,location.state);
    const handleSubmit=(e, userId,courseId,props) =>{
        // courseId=2;
        console.log("courseId "+courseId);
      
        history.push({
            pathname:'/singlecoursedetails',
            state:{cId:courseId}
        });
        
        }
const styles = {
    cardImage: {
      objectFit: 'cover'
    //   borderRadius: 55
    }}

    const [courseList,setCourseList]=useState([]);

    useEffect(()=>{
        console.log("andar che")
        axios.get('http://localhost:8080//getallcoursedetailstovendor/'+vendorId).then(res=>{
            console.log("data is",res.data);
            setCourseList(res.data)
            console.log("the final courselist is",courseList)
        })
        .catch(err=>{
            console.log(err)
        })
    },[location.state])


return(
    <div>
  

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
        </div>
        
                     
        </Card.Footer>
        </Card>
    </Col>                    
    ) }
    </CardDeck>
    <Button  style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" >Add New Course
        </Button>
    </div>
    
</div>
)
}
export default ListofAllCoursesSearchByVendorId

// onClick={(e)=>handleSubmit(e,props.userid,company.companyId)}