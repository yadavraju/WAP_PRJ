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
				<label>E-mail
					<input id="email" type="email" required oninvalid="setCustomValidity('Enter your email');" oninput="setCustomValidity('');" />
				</label>
				<label>Password
					<input id="pwd" type="password" size=8 required oninvalid="setCustomValidity('Enter your password');" oninput="setCustomValidity('');" />
				</label>
				<button type="submit" id="loginbtn">Log in</button>
				<br />
				<div><p id="loginerr"></p></div>
			</form>
	</div>
	<div id='body'>
		<!-- sign up form -->
		<form id="signupform" class="cd-form">
			<p class="fieldset">
				<label class="image-replace" for="">First Name</label>
				<input class="half-width has-padding has-border" id="signup-firstname" type="text" placeholder="First Name">
				<span class="cd-error-message">Error message here!</span>

				<label class="image-replace" for="">Last Name</label>
				<input class="half-width has-padding has-border" id="signup-lastname" type="text" placeholder="Last Name">
				<span class="cd-error-message">Error message here!</span>
			</p>
			
			<p class="fieldset">
				<label class="image-replace cd-email" for="signup-email">E-mail</label>
				<input class="full-width has-padding has-border" id="signup-email" type="email" placeholder="E-mail">
				<span class="cd-error-message">Error message here!</span>
			</p>

			<p class="fieldset">
				<label class="image-replace cd-password" for="signup-password">Password</label>
				<input class="full-width has-padding has-border" id="signup-password" type="text" placeholder="Password">
				<span class="cd-error-message">Error message here!</span>
			</p>

			<p class="fieldset">
				<input class="full-width has-padding" type="submit" value="Sign up">
			</p>
		</form>

		<!-- <a href="#0" class="cd-close-form">Close</a> -->
	</div>
	<script>
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
			var username = $("#email").val();
			var pwd = $("#pwd").val();
			
			$.get("test.json", {
				u: username,
				p: pwd
			})
			.done(function(data) {
                $("#loginerr").html("Login failed: ");
			})
			.fail(function(xhr, st) {
                $("#errorId").append($("<p>", { "class": "error" })).css({ "color": "red", "font-size": "24px" }).html("login failed: " + st);
            })
            .always(function() {
                $(".loading").remove();
                $("#inputs").after(out);
                $(".showComment").click(getComment);
            });
		}
		
		function signup() {
			var firstname = $("#signup-firstname").val();
			var lastname = $("#signup-lastname").val();
			var email = $("#signup-email").val();
			var pwd = $("#signup-password").val();
			
			$.get("signup.json", {
				fn: firstname,
				ln: lastname,
				email: email,
				password: pwd
			})
			.done(function(data) {
                $("#loginerr").html("Login failed: ");
			})
			.fail(function(xhr, st) {
                $("#errorId").append($("<p>", { "class": "error" })).css({ "color": "red", "font-size": "24px" }).html("login failed: " + st);
            })
            .always(function() {
                $(".loading").remove();
                $("#inputs").after(out);
                $(".showComment").click(getComment);
            });
		}
		
	</script>
</body>
</html>