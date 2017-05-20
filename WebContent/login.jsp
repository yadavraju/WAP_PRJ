<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Goods Swap - Login</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id='header'>
		<form>
			<label>Email
				<input id='email' placeholder='Enter your email' />
			</label>
			<label>Password
				<input id='pwd' placeholder='Enter your password' />
			</label>
			<input value='Log in' type='submit' />
		</form>
	</div>
	<div id='body'>
		<!-- sign up form -->
		<form class="cd-form">
			<p class="fieldset">
				<label class="image-replace" for="">First Name</label>
				<input class="half-width has-padding has-border" id="signup-firstname" type="text" placeholder="Firstname">
				<span class="cd-error-message">Error message here!</span>

				<label class="image-replace" for="">Last Name</label>
				<input class="half-width has-padding has-border" id="signup-lastname" type="text" placeholder="Lastname">
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
</body>
</html>