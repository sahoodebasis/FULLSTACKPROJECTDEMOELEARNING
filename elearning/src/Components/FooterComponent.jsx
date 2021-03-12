import React,{Component} from 'react'
import '../Stylesheets/footer.css'

class FooterComponent extends Component {
    render() {
        return(
            <footer className="footer text-center border">
                <span className="text-muted">All rights reserved 2021 @e-Learning App</span>                
            </footer>
        )
    }
}
export default FooterComponent