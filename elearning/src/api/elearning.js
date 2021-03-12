import axios from 'axios'

class Elearning {

    loginUser(user) {
        console.log(user)
        return axios.post(`http://localhost:8080/validate/users`,user)
    }

    getUserPurchasedServices(userid) {
        return axios.get(`http://localhost:8080/services/learner/${userid}`)
    }

    getVendorServices(vendorId) {
        return axios.get(`http://localhost:8080/services/vendor/${vendorId}`)
    }

    getVendorOrdersByServiceId(serviceId,vendorId) {
        return axios.get(`http://localhost:8080/services/orders/${serviceId}/${vendorId}`)
    }

    getusersList() {
        return axios.get(`http://localhost:8080/users`)
    }
    getserviceList() {
        return axios.get(`http://localhost:8080/services`)
    }
    getVendorCoursesByServiceIdandUserId(vendorId,serviceId) {
        return axios.get(`http://localhost:8080/services/vendor/courses/${vendorId}/${serviceId}`)
    }
    getCoursesByVendorId(serviceId) {
       return axios.get(`http://localhost:8080/courses/${serviceId}`)
    }


}

export default new Elearning()