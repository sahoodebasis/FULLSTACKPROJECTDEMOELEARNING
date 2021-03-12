class AuthenticationService {

    registerSuccessfulLogin(userid,email,role,name) {
        console.log("register successful login")
        sessionStorage.setItem("AuthenticatedUser",userid)
        sessionStorage.setItem("Authenticatedemail",email)
        sessionStorage.setItem("Authenticatedrole",role)
        sessionStorage.setItem("Authenticatedname",name)
    }

    logout() {
        sessionStorage.removeItem('AuthenticatedUser')
        sessionStorage.removeItem("Authenticatedemail")
        sessionStorage.removeItem("Authenticatedrole")
        sessionStorage.removeItem("Authenticatedname")
    }

    isUserLoggedin() {
        let user=sessionStorage.getItem('AuthenticatedUser')
        if (user===null) return false;
        return true;
    }

    getUserIdLoggedin() {
        let userid=sessionStorage.getItem('AuthenticatedUser')
        return userid;
    }
    getNameLoggedin() {
        let name=sessionStorage.getItem('Authenticatedname')
        return name;
    }
    getRoleLoggedin() {
        let role=sessionStorage.getItem('Authenticatedrole')
        return role;
    }

    getEmailLoggedin() {
        let email=sessionStorage.getItem('Authenticatedemail')
        return email;
    }

}
export default new AuthenticationService()