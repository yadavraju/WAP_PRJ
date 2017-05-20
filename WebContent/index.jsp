<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Responsive Login/Signup Modal Window</title>
	<script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

	<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/reset.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


	<link rel="stylesheet" href="css/style.css">


</head>

<body>

	<body>
		<header role="banner">
			<div id="cd-logo">
				<a href="#0"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/148866/cd-logo_1.svg" alt="Logo"></a>
			</div>

			<nav class="main-nav">
				<ul>
					<!-- inser more links here -->
					<li><a class="cd-signin" href="#0">Sign in</a></li>
					<li><a class="cd-signup" href="#0">Sign up</a></li>
				</ul>
			</nav>
		</header>

		<div class="cd-user-modal">
			<!-- this is the entire modal form, including the background -->
			<div class="cd-user-modal-container">
				<!-- this is the container wrapper -->
				<ul class="cd-switcher">
					<li><a href="#0">Sign in</a></li>
					<li><a href="#0">New account</a></li>
				</ul>

				<div id="cd-login">
					<!-- log in form -->
					<form class="cd-form">
						<p class="fieldset">
							<label class="image-replace cd-email" for="signin-email">E-mail</label>
							<input class="full-width has-padding has-border" id="signin-email" type="email" placeholder="E-mail">
							<span class="cd-error-message">Error message here!</span>
						</p>

						<p class="fieldset">
							<label class="image-replace cd-password" for="signin-password">Password</label>
							<input class="full-width has-padding has-border" id="signin-password" type="text" placeholder="Password">
							<a href="#0" class="hide-password">Hide</a>
							<span class="cd-error-message">Error message here!</span>
						</p>

						<p class="fieldset">
							<input type="checkbox" id="remember-me" checked>
							<label for="remember-me">Remember me</label>
						</p>

						<p class="fieldset">
							<input class="full-width" type="submit" value="Login">
						</p>
					</form>

					<p class="cd-form-bottom-message"><a href="#0">Forgot your password?</a></p>
					<!-- <a href="#0" class="cd-close-form">Close</a> -->
				</div>
				<!-- cd-login -->

				<div id="cd-signup">
					<!-- sign up form -->
					<form action = "UserController" method = "post" class="cd-form">
						<p class="fieldset">
							<label class="image-replace cd-username" for="signup-username">Username</label>
							<input class="full-width has-padding has-border" id="signup-username" name ="fname" type="text" placeholder="Username">
							<span class="cd-error-message">Error message here!</span>
						</p>

						<p class="fieldset">
							<label class="image-replace cd-email" for="signup-email">E-mail</label>
							<input class="full-width has-padding has-border" id="signup-email"  name ="email" type="email" placeholder="E-mail">
							<span class="cd-error-message">Error message here!</span>
						</p>

						<p class="fieldset">
							<label class="image-replace cd-password" for="signup-password">Password</label>
							<input class="full-width has-padding has-border" id="signup-password" name ="password" type="text" placeholder="Password">
							<a href="#0" class="hide-password">Hide</a>
							<span class="cd-error-message">Error message here!</span>
						</p>

						<p class="fieldset">
							<input type="checkbox" id="accept-terms">
							<label for="accept-terms">I agree to the <a href="#0">Terms</a></label>
						</p>

						<p class="fieldset">
							<input class="full-width has-padding" type="submit" value="Create account">
						</p>
					</form>

					<!-- <a href="#0" class="cd-close-form">Close</a> -->
				</div>
				<!-- cd-signup -->

				<div id="cd-reset-password">
					<!-- reset password form -->
					<p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>

					<form class="cd-form">
						<p class="fieldset">
							<label class="image-replace cd-email" for="reset-email">E-mail</label>
							<input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
							<span class="cd-error-message">Error message here!</span>
						</p>

						<p class="fieldset">
							<input class="full-width has-padding" type="submit" value="Reset password">
						</p>
					</form>

					<p class="cd-form-bottom-message"><a href="#0">Back to log-in</a></p>
				</div>
				<!-- cd-reset-password -->
				<a href="#0" class="cd-close-form">Close</a>
			</div>
			<!-- cd-user-modal-container -->
		</div>
		<!-- cd-user-modal -->
	</body>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>

</body>
</html>