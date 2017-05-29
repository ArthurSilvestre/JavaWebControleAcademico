<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	            
	            <form:form method="POST" action="login" modelAttribute="pessoa_fisica" class="form-signin">
	                <form:input path="id_PessoaFisica" type="text" class="form-control" placeholder="Matricula" required="required"/>
	                <form:input path="senha" type="password" class="form-control" placeholder="Senha" required="required"/>
	                <form:button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="Login">Login</form:button>
	            </form:form><!-- /form -->
	            
	        </div><!-- /card-container -->
	    </div><!-- /container -->

		<!-- Scripts -->
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>

	</body>

</html>