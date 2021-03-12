import Button from 'react-bootstrap/Button';
import React,{useState,useEffect} from 'react';
import axios from 'axios';
import {ListofCourseCards} from './listofcoursecards';

export default function HomeCourseComponent(props){
    
        const [courseList,setCourseList]=useState([]);
    
        useEffect(()=>{
            axios.get('http://localhost:8080/getallcoursedetailstouser').then(res=>{
                console.log(res.data);
                setCourseList(res.data);
            })
            .catch(err=>{
                console.log(err)
            })
        },[])
    
    
    return(
        <div>
        <h2  className=" m-3">Available courses </h2>
        <ListofCourseCards courseList={courseList}/>
        </div>
    );
}
