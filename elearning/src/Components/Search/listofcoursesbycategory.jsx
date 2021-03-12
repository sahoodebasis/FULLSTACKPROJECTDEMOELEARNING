import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardDeck from 'react-bootstrap/CardDeck';
import {useHistory, useLocation, useParams} from 'react-router-dom';
import AuthenticationService from '../../Components/AuthenticationService'

// const course=(

// )
 const ListofCoursesSearchByCategory = (props) =>{
    //get role from session
    var userId=AuthenticationService.getUserIdLoggedin()
    let role=AuthenticationService.getRoleLoggedin()
    //let role = "learner"
    let history = useHistory();
    let params = useLocation();
    const category = params.category;
    console.log("yoy yo",category);
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
        let url=''
        console.log("andar che")
        if(role.toLowerCase()==="vendor"){
            url='http://localhost:8080//getallcoursedetailstovendor/'+params.vendorId
        }  
        else{
            url='http://localhost:8080//getallcoursedetailstouser'
        }
            
        axios.get(url).then(res=>{
            console.log("data is",res.data);
            setCourseList(res.data.filter(lol=>{
                return lol.courseCategory === category
            }))
            console.log("the final courselist is",courseList)
        })
        .catch(err=>{
            console.log(err)
        })
    },[params.category])


return(
    <div>
  {/* <Button  style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" >Add New Course
        </Button> */}

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
        {
            role.toLowerCase() === "user"?
            <div className="text-center m-2">
            <Button className="m-2" id={course.courseId}  onClick={(e)=>handleSubmit(e,userId,course.courseId)}
             style={{backgroundColor:"red",color:"white",border:"1px solid white"}} type = "" >Details 
            </Button>
            {/* <Button id={course.courseId}   style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" >Deactivate
            </Button> */}
            </div>:
            <div className="text-center m-2">
           {(role=="vendor")?<Button className="m-2" id={course.courseId}   style={{backgroundColor:"red",color:"white",border:"1px solid white"}} type = "" onClick={()=>history.push({pathname:'/editcourse',state:{cId:course.courseId} })} >Edit Details
        </Button>:<Button className="m-2" id={course.courseId}   style={{backgroundColor:"red",color:"white",border:"1px solid white"}} type = "" onClick={()=>history.push({pathname:'/editcourseadmin',state:{cId:course.courseId} })} >Edit Details
        </Button>}
            {/* <Button id={course.courseId}   style={{backgroundColor:"#ff253a",color:"white",border:"1px solid white"}} type = "" >Deactivate
            </Button> */}
            </div>


        }
        
        
                     
        </Card.Footer>
        </Card>
    </Col>                    
    ) }
    </CardDeck>
    
    </div>
    
</div>
)
}
export default ListofCoursesSearchByCategory

// onClick={(e)=>handleSubmit(e,props.userid,company.companyId)}