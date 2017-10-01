<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">         
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>TechTonics</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style2.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
  		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
  
    </head>
    <body ng-app="formApp" ng-controller="formController" >
        <div class="container">
            
            <header>
                <h1>Welcome to <span>TechTonics</span></h1>
				<h3>${signupStatus}</h3>
				<h3>${loginStatus}</h3>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="Login" autocomplete="on" method="post" name=loginForm> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="emaillogin" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emaillogin" name="emaillogin" required="required" type="email" placeholder="mysupermail@atmecs.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input id="password" name="passwordlogin" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  name="signupForm" action="SignUp" autocomplete="on" method = "post" > 
                                <h1> Sign up </h1>                                 
                                <p> 
                                    <label for="emailsignup1"  data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@atmecs.com" ng-model="email" 
                                     ng-pattern="/@atmecs.com$/i" required/>
                                     <span ng-show="signupForm.emailsignup.$touched && signupForm.emailsignup.$error.required">Email required!</span>
									 <span ng-show="signupForm.$dirty && signupForm.emailsignup.$invalid">Please enter atmecs account emailId</span> 
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your Name</label>
                                    <input id="usernamesignup" name="namesignup" required="required" type="text" placeholder="Name" />
                                </p>
                                <p> 
                                    <label for="passwordsignup" data-icon="p">Your password </label>
                                    <input id="passwordsignup" name="passwordsignup" type="password" placeholder="eg. X8df!90EO" ng-model="password" 
                                           ng-pattern="/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/i" required />
                                 </p>
                                 <p>
                                    <span ng-show="signupForm.password.$touched && signupForm.password.$error.required">Password required!</span>
                                 <p>
									<span ng-show="signupForm.password.$dirty && signupForm.password.$error.pattern">Password should 8 to 20 characters only!!</span>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"  
                                    	   ng-model="cpassword" ng-pattern="{{signupForm.password.$viewValue}}" required/>
                                   	<span ng-show="signupForm.cpassword.$touched && signupForm.cpassword.$error.required">Confirm Password can not be empty!!</span>
									<span ng-show="signupForm.cpassword.$dirty && signupForm.cpassword.$error.pattern">Confirm Password should match!!</span>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up" ng-disabled="signupForm.$invalid" /> 
									<!-- <button class="signin button" ng-click="register()" ng-disabled="signupForm.$invalid">Save</button>  -->
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
</html>

<script type="text/javascript" src="angular.min.js"></script>
<script>
var app = angular.module("formApp",[]);
app.controller("formController",function(){});
</script>
