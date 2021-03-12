import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import Login from './Components/Login'
import Signup from './Components/Signup'
import WelcomePage from './Components/WelcomePage'
import ListTodosComponent from './Components/ListTodosComponent'
import MenuComponent from './Components/MenuComponent'
import FooterComponent from './Components/FooterComponent'
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom'
import AuthenticatedRoute from './Components/AuthenticatedRoute'
import ServiceCardComponent from './Components/ServiceCardComponent'
import UserServices from './Components/UserServices'
import VendorServices from './Components/VendorServices'
import AdminHomeComponent from './Components/AdminHomeComponent'
import UpdateUserByAdmin from './Components/UpdateUserByAdmin'
import SearchComponent from './Components/SearchComponent'
import Payment from './Components/Payment'
import SingleCourseDetailsSearch from './Components/SingleCourseDetailsSearch'
import HomeCourseComponent from './Components/HomeCourseComponent'
import SingleCourseDetails from './Components/SingleCourseDetails'
import UserProfile from './Components/UserProfile'
import PurchaseHistoryCourses from './Components/purchasehistorycourses'
import CoursesUnderService from './Components/coursesunderservice'
import ListofCourseCards from './Components/listofcoursesforadminvendor'
import VendorOnlineServices from './Components/VendorOnlineServices'
import AddCourse from './Components/AddCourse'
import AddCourseByAdmin from'./Components/AddCourseByAdmin'
import EditCourse from './Components/EditCourse'
import EditCourseByAdmin from './Components/EditCourseByAdmin'
import AddServices from './Components/AddServices'
import EditService from './Components/EditService'
import ListofUserCoursesSearchByVendorId from './Components/Search/listofusercoursesbyvendorid';
import ListofCoursesSearchByCategory from './Components/Search/listofcoursesbycategory';
import ListofAllCoursesSearchByVendorId from './Components/Search/listofallcoursesbyvendorid';
import ListofCoursesByName from './Components/Search/listofcoursesbyname';
import Search from './Components/Search/Search';
import AuthenticationService from "./Components/AuthenticationService.js";

function App() {
  var islogIn = AuthenticationService.isUserLoggedin()
  return (
    <div className="App">
      <Router>
        <div>
          <MenuComponent></MenuComponent> 
          <div className="container" style={{marginTop:"100px"}}></div>
          {/* {islogIn=AuthenticationService.isUserLoggedin()}
          {islogIn&&<Search></Search>} */}
          <Switch>
            <Route path = "/" exact component={Login}/>
            <Route path = "/login" exact component={Login}/>
            <Route path = "/signup" exact component={Signup}/>
            <AuthenticatedRoute path = "/service" exact component={ServiceCardComponent}/>
            <AuthenticatedRoute path = "/userServices" exact component={UserServices}/>
            <AuthenticatedRoute path = "/vendorServices" exact component={VendorServices}/>
            <AuthenticatedRoute path = "/allUsers" exact component={AdminHomeComponent}/>
            <AuthenticatedRoute path = "/editUser" exact component={UpdateUserByAdmin}/>
            <AuthenticatedRoute path = "/addUser" exact component={Signup}/>
            {/* <Route path = "/search" exact component={SearchComponent}/> */}
            <AuthenticatedRoute path = "/payment" exact component={Payment}/>
            <AuthenticatedRoute path = "/home" exact component={HomeCourseComponent}/>
            <Route path = "/courses" exact component={HomeCourseComponent}/>
            <AuthenticatedRoute path = "/profile" exact component={UserProfile}/>
            <AuthenticatedRoute path = "/userorders" exact component={PurchaseHistoryCourses}/>
            <AuthenticatedRoute path = "/servicecourse" exact component={CoursesUnderService}/>
            <AuthenticatedRoute path = "/vendoronlineservice" exact component={VendorOnlineServices}/>
            <AuthenticatedRoute path = "/servicecoursevendoradmin" exact component={ListofCourseCards}/>
            <AuthenticatedRoute path = "/addcourse" exact component={AddCourse}/>
            <AuthenticatedRoute path = "/addcourseadmin" exact component={AddCourseByAdmin}/>
            <AuthenticatedRoute path = "/editcourse" exact component={EditCourse}/>
            <AuthenticatedRoute path = "/editcourseadmin" exact component={EditCourseByAdmin}/>
            <AuthenticatedRoute path = "/addservice" exact component={AddServices}/>
            <AuthenticatedRoute path = "/editservice" exact component={EditService}/>
            <AuthenticatedRoute path="/users/:id/">
                <SingleCourseDetailsSearch/>
            </AuthenticatedRoute>
            <AuthenticatedRoute path="/singlecoursedetails" exact component={SingleCourseDetails}/>
            <AuthenticatedRoute path = "/welcomepage" exact component={WelcomePage}/>
            <AuthenticatedRoute path = "/todolist" exact component={ListTodosComponent}/>
            
           

            {/* <Route path = "/search1" exact component={Search}/> */}
          <Route  path="/name" exact>
                <ListofCoursesByName />
          </Route>
          <Route  path="/vendorcoursesforuser" exact>
                <ListofUserCoursesSearchByVendorId />
          </Route>
          <Route  path="/vendorcoursesforadmin" exact>
                <ListofAllCoursesSearchByVendorId />
          </Route>
          <Route  path="/category" exact>
                <ListofCoursesSearchByCategory />
          </Route>  
          </Switch>
          <FooterComponent></FooterComponent>
        </div>
      </Router>
    </div>
  );
}

export default App;
