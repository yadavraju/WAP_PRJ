<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Goods Swap - Login</title>
<link rel="stylesheet" href="css/style.css">
<script src="jquery.min.js"></script>
</head>
<body>
	<div id="header">
		<form action="" id="submitform" class="cd-form">
			<label>E-mail <input id="email" type="email" required
				oninvalid="setCustomValidity('Enter your email');"
				oninput="setCustomValidity('');" />
			</label> <label>Password <input id="pwd" type="password" size=8
				required oninvalid="setCustomValidity('Enter your password');"
				oninput="setCustomValidity('');" />
			</label>
			<button type="submit" id="loginbtn">Log in</button>
			<br />
			<div>
				<p id="loginerr"></p>
			</div>
		</form>
	</div>
	
	
<!-- 		<div id="divId">
			Username : <input type="text" name="username" id="username" /></br>
			Password : <input type="password" name="password" id="password" /></br>
			<button name="login" id="login">Login</button>
		</div>
		<div id="messageDiv" style="display: block;">sfdsgfd</div> -->


	<div id='body'>
		<!-- sign up form -->
		<form action="UserController" method="post" id="signupform"
			class="cd-form">
			<p class="fieldset">
				<label class="image-replace" for="">First Name</label> <input
					class="half-width has-padding has-border" id="signup-firstname"
					name="fname" type="text" placeholder="First Name" required> <span
					class="cd-error-message">Error message here!</span> <label
					class="image-replace" for="">Last Name</label> <input
					class="half-width has-padding has-border" id="signup-lastname"
					name="lname" type="text" placeholder="Last Name" required> <span
					class="cd-error-message">Error message here!</span>
			</p>

			<p class="fieldset">
				<label class="image-replace cd-email" for="signup-email">E-mail</label>
				<input class="full-width has-padding has-border" id="signup-email"
					name="email" type="email" placeholder="E-mail" required> <span
					class="cd-error-message">Error message here!</span>
			</p>

			<p class="fieldset">
				<label class="image-replace cd-password" for="signup-password">Password</label>
				<input class="full-width has-padding has-border"
					id="signup-password" name="password" type="password"
					placeholder="Password" required> <span class="cd-error-message">Error
					message here!</span>
			</p>

			<p class="fieldset">
				<input class="full-width has-padding" type="submit" value="Sign up">
			</p>
		</form>

		<!-- <a href="#0" class="cd-close-form">Close</a> -->
	</div>
	<script>
	 //NEW javascript
//  	 $("#login").on('click', function(){
//          var email = $("#username").val();
//          var password = $("#pwd").val();
//  		$(function() {
// 			$("#submitform").on("submit", function(ev) {
// 				login();
// 				ev.preventDefault();
// 			});

// 			$("#signupform").on("submit", function(ev) {
// 				signup();
// 				ev.preventDefault();
// 			});
// 		});
         
//          //alert(username+password);
//          $.ajax({
//              url : "LoginRequest",
//              type : "get",
//              data : {
//                  username : username,
//                  password : password
//              },
//              success : function(results){
//             	// alert("sucess"+results);
//                  if(results != null && results != ""){
//                      showMessage(results);
//                      $('#messageDiv').css("display","block");
//                  }else{
//                      $('#messageDiv').css("display","none");
//                      $('#messageDiv').html("");
//                      alert("Some exception occurred! Please try again.");
//                  }
//              },
             
//              error : function () {
//             	 alert("fail");
				
// 			}
//          });
//      });
      
//      //function to display message to the user
//      function showMessage(results){
//          if(results == 'SUCCESS'){
//              $('#messageDiv').html("<font color='green'>You are successfully logged in. </font>")
        
<%--                window.location.href = "<%=request.getContextPath()%>/HomePageServlet"; --%>
         
//          }else if(results == 'FAILURE'){
//              $('#messageDiv').html("<font color='red'>Username or password incorrect </font>")
//          }
//      } 
     
		$(function() {
			$("#submitform").on("submit", function(ev) {
				login();
				ev.preventDefault();
			});

			$("#signupform").on("submit", function(ev) {
				signup();
				ev.preventDefault();
			});
		});

		function login() {
			var email = $("#email").val();
			var pwd = $("#pwd").val();

			$.post("LoginRequest", {
				username : email,
				password : pwd
			}).done(function(data) {
				//$("#loginerr").html("Login success!");
				var objData = JSON.parse(data);
				console.log(data);
				if(objData.code == "200"){
					window.location.href = "<%=request.getContextPath()%>/HomePageServlet";
				}else{
					console.log(objData.msg);
					$("#loginerr").html("Email or Password not correct!");
				}

			}).fail(function(xhr, st) {
				$("#loginerr").html("Something is wrong:" + st);
			}).always(function() {
				
			});
		}

		function signup() {
			var firstname = $("#signup-firstname").val();
			var lastname = $("#signup-lastname").val();
			var email = $("#signup-email").val();
			var pwd = $("#signup-password").val();

			$.post("UserController", {
				fname : firstname,
				lname : lastname,
				email : email,
				password : pwd
			}).done(function(data) {
				console.log(data);
				//var oData = JSON.parse(data);
				if(data.code == "200"){
// 					console.log("ok");
					alert("Registration is successful!");
					window.location.href = "<%=request.getContextPath()%>/HomePageServlet";
				}else{
					$("#loginerr").html("Failed to register, please check the fields!");
				}
			}).fail(function(xhr, st) {
				$("#loginerr").html("Something is wrong:" + st);
			}).always(function() {
			}); 
		}
	</script>
</body>
</html>