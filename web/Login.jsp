<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />

        <link href="./assets/css/base.css" rel="stylesheet" type="text/css" />
        <link href="./assets/css/main.css" rel="stylesheet" type="text/css" />
        <link href="./assets/css/login.css" rel="stylesheet" type="text/css" />
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    <title>Login</title>
    </head>
    <body>
         <jsp:include page="Header.jsp"></jsp:include>   
         <div class="container ${side}" id="container">
      <div class="form-container sign-up-container">
        <form class="login-form" action="signup" method="post">
          <h1>Create Account</h1>
          <div class="social-container">
            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
          </div>
          <span>or use your new account for registration</span>
          <input name="fname" value="${vlFname}" type="text" placeholder="First Name" />
          <input name="lname" value="${vlLname}" type="text" placeholder="Last Name" />
          <input name="uname" value="${vlUname}" type="text" placeholder="Username" />
          <input name="pass"  value="${vlpass}" type="password" placeholder="Password" />
          <input name="repass" value="${vlrepass}" type="password" placeholder="Repeat Password" />
          <p style="margin-left: -140px; color : red">${messErr1}</p>
          <button class="login-btn">Sign Up</button>
        </form>
      </div>
      <div class="form-container sign-in-container">
        <form action="login" method="post">
          <h1>Sign in</h1>
          <div class="social-container">
            <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
            <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
          </div>
          <span>or use your account</span>
          <input name="uname" type="text" placeholder="Username" />
          <input name="pass" type="password" placeholder="Password" />
          <div>
          <input type="checkbox" name ="remember" value="remember" style="float:left"/> Remember me 
          </div>
          <p style="margin-left: -140px; color : red">${messErr}</p>
          <a href="#">Forgot your password?</a>
          
          <button class="login-btn" type ="submit">Sign In</button>
        </form>
      </div>
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-left">
            <h1>Hello, Friend!</h1>
            <p>Enter your personal details and start journey with us</p>
            <button class="login-btn ghost" id="signIn">Sign In</button>
          </div>
          <div class="overlay-panel overlay-right">
            <h1>Welcome Back!</h1>
            <p>To keep connected with us please login with your personal info</p>
            <button class="login-btn ghost" id="signUp">Sign Up</button>
          </div>
        </div>
      </div>
    </div>
         <jsp:include page="Footer.jsp"></jsp:include>
        <script src="./assets//js/login.js"></script>
        <script src="./assets/js/main.js"></script>
    </body>
</html>
