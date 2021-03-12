import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardGroup from 'react-bootstrap/CardGroup';
import Review from './Review';
import {useHistory,Redirect} from 'react-router-dom';
import AuthenticationService from './AuthenticationService.js';

export function SingleCourseDetails(props){
    
    const history=useHistory();
    var userId= AuthenticationService.getUserIdLoggedin()
    console.log("props"+JSON.stringify(props));
    // const [redirect,setRedirect]=useState(null);
    // var hasPurchased=false;
    // var isComplete=false;
    //var userId=1;
    const handleSubmit=(e, userId,courseId,isComplete,props) =>{
      
  
        // courseId=2;
        // if (redirect) {
        //   return <Redirect to={setRedirect} />
        // }
        // setisComplete(true);
        axios.patch(`http://localhost:8080/orders/courseStatus/${courseId}/${userId}`, {}, { params: { isComplete: true } })
            .then(response => {
                console.log("response "+JSON.stringify(response))
                history.goBack()
                // setRedirect("/singlecoursedetails")
            })
            .catch(error => {
                console.log(error)
                // alert("Error Updating service");
            });
        }
    const styles = {
        card: {
          backgroundColor: '#ff9999',
          borderRadius: 55,
          padding: '3rem'
        },
        cardImage: {
          objectFit: 'cover',
          borderRadius: 55,
          height: '100%'
        }
      }

    
    const [courseDetail,setCourseDetail]=useState({});
    const [Order, setOrder] = useState({})
      const [isComplete,setisComplete]=useState(false)
      const [hasPurchased,sethasPurchased]=useState(false)
    const courseId= props.location.state.cId;
    console.log("courseid before useeffect "+ courseId);
    
  
    useEffect(()=>{
        console.log("courseid "+ courseId);
        const fetchData = async () => {
            const data1 = await axios.get('http://localhost:8080/getcoursedetailstouser/'+courseId)
            const data2 = await axios.get('http://localhost:8080/orders/iscomplete/'+courseId+'/'+userId)
            setCourseDetail(data1.data);
            console.log("data1 "+JSON.stringify(data1));
            console.log("coursedetails "+JSON.stringify(courseDetail))
            console.log("data2 of order "+JSON.stringify(data2))
            setOrder(data2.data);
            console.log("order data "+JSON.stringify(Order))
            console.log("ORDER>COMPLETE" +data2.data.complete)
            setisComplete((data2.data.complete==false||data2.data.length<1)?false:true)
            console.log("hiiiiii "+isComplete)
            console.log("Order.complete ",data2.data.complete)
            sethasPurchased((data2.data.length<1)?false:true)
          
            // Order.complete===false||Order.length===0||Order.length===null
        };
        fetchData();
        // })
        // .catch(err=>{
        //     console.log(err);
        // })
    },[])

    
   
    
    
return(
    // console.log("order data inside return  "+JSON.stringify(Order))

   <div style={{backgroundColor: "#ffcccc",textAlign:"left"}}>
      
       {/* {hasPurchased=(Order.length===0||Order.length===null||Order==={})?false:true} */}
       {/* {isComplete=Order.isComplete===true?true:false} */}
       
      {console.log("order data inside return  "+JSON.stringify(Order))}
      {console.log("iscomplete "+isComplete)}
    
      {console.log("iscomplete of order table "+Order.complete)}
      {console.log("hasPurchased "+hasPurchased)}
      {console.log("length of order table "+Order.length)}
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
                {!hasPurchased && <Button id={courseDetail.courseId}   style={{backgroundColor:"#ff253a",color:"white"}} type = "submit"  size="lg" onClick={()=>history.push({pathname:'/payment',state:{course:courseDetail} })}>Buy now
                </Button>  }
                
                {hasPurchased && !isComplete && <Button id={courseDetail.courseId} onClick={(e)=>handleSubmit(e,userId,courseId,isComplete)}  style={{backgroundColor:"#ff253a",color:"white"}} type = "submit"  size="lg">Complete course
                </Button>  }

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
        <div className="border 1 m-2 p-2" style={{backgroundColor: "#ffcc99"}}>
            <h2> What you'll learn </h2>
            <li> {courseDetail.description} </li>
        </div>
        <div className="border 1 m-2 p-2" style={{backgroundColor: "#ccccff"}}>
            <h2> Languages availabe </h2>
            <li> {courseDetail.languages} </li>
        </div>
        <div className="border 1 m-2 p-2" style={{backgroundColor: "#ffcc99"}}>
            <h2> Goals to be set </h2>
            <li> {courseDetail.learningGoals} </li> 
        </div>
        <div className="border 1 m-2 p-2" style={{backgroundColor: "#ccccff"}}>
            <h2> Requirements </h2>
            <li> {courseDetail.requirements} </li> 
        </div>    

    
    </div>
    <Review courseId={courseId} isComplete={isComplete} hasPurchased={hasPurchased}/>
    </div>
);

 
}
export default SingleCourseDetails