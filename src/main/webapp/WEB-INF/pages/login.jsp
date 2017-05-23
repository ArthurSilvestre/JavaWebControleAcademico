<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		
		<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />		
		<link rel="stylesheet" type="text/css" href="css/application.css" />
		
	</head>

	<body>
        
	    <div class="container">
	        <div class="card card-container">
	            
	            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            
	            <h3>Controle Academico</h3>
	            
	            <form class="form-signin">
	                <input type="email" id="inputEmail" class="form-control" placeholder="Matricula" required autofocus>
	                <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
	            </form><!-- /form -->
	            
	        </div><!-- /card-container -->
	    </div><!-- /container -->

		<!-- Scripts -->
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>

	</body>

</html>