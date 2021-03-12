import React,{ useState, useEffect } from 'react';
import axios from 'axios';
import {Dropdown,DropdownItem,DropdownMenu,DropdownToggle} from 'reactstrap';
import { useHistory } from 'react-router-dom';
import { SingleCourseDetailsSearch } from './SingleCourseDetailsSearch';



const SearchComponent = () => {
    const history = useHistory();
    const [arr,mrr] = useState({
        data: []
    })
    useEffect(()=>{
            axios.get('http://localhost:8080/getallcoursedetailstouser').then(res=>{
                console.log("data is",res.data);
               const h = res.data.map(courses=>{
                   console.log(courses.name)
                   return {name:courses.name,
                            id:courses.courseId}
               })
                console.log("h is ",h)
                mrr({
                    data:[...h]
                })
            })
            .catch(err=>{
                console.log(err)
            })
        },[])

  const [isOpen, setDropdownOpen] = useState(false);

  const toggle = () => setDropdownOpen(prevState => !prevState);
const [see,mani] = useState({
    inoutValue:""
    
});
//For maintaining an array for searching

//For filtering out the possible matches
const files = 
    arr.data.sort().filter( lol => {
        return lol.name.toLowerCase().includes(see.inoutValue)
    })
const lol = () => {
    let count=0
    return(
        files.length>0?
        files.map(file => {
            if(count<9){
                console.log("hello",file);
            count++;
           return (
            <DropdownItem onClick={()=>handleClick(file.id)}>{file.name}</DropdownItem>
           )
            }
            
        }):<DropdownItem>No Matching records</DropdownItem>
        
    )
    
}
const handleClick = (courseid) => {
    history.push('/users/'+courseid+"/3");
}
const changeHandler = (event) => {
mani({
    inoutValue:event.target.value,
})
}
    return(
        <div className="container">
           
            
            <Dropdown isOpen={isOpen} toggle={toggle} className="m-b-1">
                <DropdownToggle tag="div"
                        data-toggle="dropdown"
                        aria-expanded={isOpen}>  
                        <input  class="form-control mr-lg-2" type="search" placeholder="Search for anything" aria-label="Search" style={{width:"480px",borderRadius: "40px"}} id="id" name="search" onChange={changeHandler} value={see.inoutValue} />       
                </DropdownToggle>
                <DropdownMenu >
                    {lol()}
                </DropdownMenu>
            </Dropdown>
        </div>
    );
    

}

export default SearchComponent;