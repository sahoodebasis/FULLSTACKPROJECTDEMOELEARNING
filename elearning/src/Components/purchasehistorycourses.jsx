import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {Row,Card,Col} from 'react-bootstrap';
import CardDeck from 'react-bootstrap/CardDeck';
import {ListofCourseCards} from './listofcoursecards';
import AuthenticationService from "./AuthenticationService.js";

export default function PurchaseHistoryCourses(props){
    const styles = {
        cardImage: {
          objectFit: 'cover'
        //   borderRadius: 55
        }}

    const [courseList,setCourseList]=useState([]);
    
    const serviceId=props.serviceId;
    var userId=AuthenticationService.getUserIdLoggedin()

    //var userId=1;
 
    useEffect(()=>{
        axios.get('http://localhost:8080/orders/learner/'+userId).then(res=>{
            console.log(res.data);
            setCourseList(res.data);
            
        })
        .catch(err=>{
            console.log(err)
        })
    },[])



    return(
        <div>
            <h2  className=" m-3">Purchase history </h2>
        <ListofCourseCards courseList={courseList}/>
        </div>
    );
}