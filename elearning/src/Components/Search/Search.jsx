import React,{ useState, useEffect } from 'react';
import axios from 'axios';
import {Dropdown,DropdownItem,DropdownMenu,DropdownToggle} from 'reactstrap';
import { useHistory } from 'react-router-dom';
import AuthenticationService from '../../Components/AuthenticationService'


const Search = () => {
    //session se user role and id
    var userid=AuthenticationService.getUserIdLoggedin()
    var role=AuthenticationService.getRoleLoggedin()
    //const role ="learner"
    //const userid = 9
    const history = useHistory();
    const [filteres,setfilter] = useState("coursename")
    const [arr,mrr] = useState({
        data: []
    })
    useEffect(()=>{
        let url =''
        if(role.toLowerCase() === "vendor"){
            url="http://localhost:8080/getallcoursedetailstovendor/"+userid;
           
        }
        else {
            url="http://localhost:8080/getallcoursedetailstouser"
        }

            axios.get(url).then(res=>{
                console.log("data is",res.data);
               const h = res.data.map(courses=>{
                   console.log(courses.name)
                   return {name:courses.name,
                            id:courses.courseId,
                            vendor:parseInt(courses.vendorId),
                            category:courses.courseCategory}
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

        switch(filteres){
            case 'coursecategory':
                console.log("ol is",lol)
                return lol.category.toLowerCase().includes(see.inoutValue)
            case 'coursename':
                return lol.name.toLowerCase().includes(see.inoutValue)
            case 'vendor':
                console.log("vendors",lol.vendor,lol.vendor == see.inoutValue)
                return lol.vendor == see.inoutValue
                
        }        
            
            
            
            
    })
const lol = () => {
    let count=0
    console.log("lol k andar che",filteres)
    return(
        files.length>0?
        files.map(file => {
            if(count<9){
                console.log("hello",file);
            count++;
            switch(filteres){
                case 'coursecategory':
                    console.log("ol is",lol)
                    return <DropdownItem onClick={()=>categoryClick(file)}>{file.category}</DropdownItem>
                case 'coursename':
                    return <DropdownItem onClick={()=>handleClick(file)}>{file.name}</DropdownItem>
                case 'vendor':
                    return <DropdownItem onClick={()=>vendorClick(file.vendor)}>{file.vendor}</DropdownItem>
                    
            }    
           
            }
            
        }):<DropdownItem>No Matching records</DropdownItem>
        
    )
    
}
const categoryClick = (file) => {
    history.push({pathname:'/category',category:file.category,vendorId:file.vendor})
}
const vendorClick = (coursess) => {
    
    if(role.toLowerCase() === "admin")
    {
        history.push({pathname:'/vendorcoursesforadmin',state:coursess})
    }
    else{
        history.push({pathname:'/vendorcoursesforuser',vendorid:coursess});
    }
    }
const handleClick = (file) => {
    history.push({pathname:'/name',courseid:file.id,vendorId:file.vendor})
    
}
const filterChange = (event) => {
    setfilter(event.target.value)
}
const changeHandler = (event) => {
mani({
    inoutValue:event.target.value,
})
}
const showoptions = () => {
if(role === "vendor"){
return(
    <select className="perftext" id="filter" name="filter" value={filteres} onChange={filterChange} >
                            <option value="coursename" selected>Course Name</option>
                            <option value="coursecategory">Course Category</option>
                            
                        </select>
     
)
}

else{
return<select  className="form-select bg-light" id="filter" name="filter" value={filteres} onChange={filterChange} style={{color:"black"}} >
<option value="coursename" selected>Course Name</option>
<option value="coursecategory">Course Category</option>
<option value="vendor">Vendor</option>
</select>
}
}
    return(
        <div className="container" style={{display:"inline"}}>
            
            <Dropdown isOpen={isOpen} toggle={toggle} className="m-b-1">
                <DropdownToggle tag="div"
                        data-toggle="dropdown"
                        aria-expanded={isOpen}>  
                        <input input class="form-control mr-lg-2" type="search" placeholder="Search for anything" aria-label="Search" style={{width:"480px",borderRadius: "40px"}} onChange={changeHandler} value={see.inoutValue} />       
                </DropdownToggle>
                <DropdownMenu >
                    {lol()}
                </DropdownMenu>
            </Dropdown>
            {showoptions()}
        </div>
    );
    

}

export default Search;