import React,{Component} from 'react'
import '../Stylesheets/Mystyle.css'
import { useHistory } from 'react-router-dom'

class ListTodosComponent extends Component {
    
    constructor(props) {
        super(props);
        console.log("hello")
        console.log(this.props.location.list.data)
        this.state = {
            Orders:this.props.location.list.data
        }
    }

    render() {
        
        console.log(this.state.Orders)
        return(
            <div>
                <div style={{textAlign:"left",marginLeft:"20px"}}><button className="btn btn-outline-primary mr-1" style={{ backgroundColor: "#ff253a", color: "white" }} type="button" onClick={() => this.props.history.goBack()}>
        Back
      </button></div>
                <h1>Orders For My Courses</h1>
                <div className="container">
                <div className="table-wrapper-scroll-y my-custom-scrollbar">
                <table className="table table-bordered table-striped table-hover mb-0">
                    <thead>
                        <tr>
                            {/* <th>Id</th> */}
                            <th className="theader" scope="col">Courses</th>
                            <th className="theader" scope="col">Learner Id</th>
                            <th className="theader" scope="col">Order Id</th>
                            <th className="theader" scope="col">Payment Number</th>
                            <th className="theader" scope="col">Service Id</th>
                            <th className="theader" scope="col">is Complete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.Orders.map((orders)=>{
                            return(
                                <tr>
                                    {/* <td>{todo.id}</td> */}
                                    <td><b>{orders.courseId}</b></td>
                                    <td>{orders.userId}</td>
                                    <td>{orders.orderId}</td>
                                    <td>{orders.paymentNo}</td>
                                    <td>{orders.serviceId}</td>
                                    <td>{orders.isComplete.toString()}</td>
                                </tr>
                            )
                        })
                        }       
                    </tbody>
                </table>
                </div>
                </div>
            </div>
        )
    }
}

export default ListTodosComponent