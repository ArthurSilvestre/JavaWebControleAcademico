<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>Login</title>

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<link rel="stylesheet" type="text/css" href="css/login.css" />

</head>

<body class="blue darken-2">

	<div id="login-page" class="row">
		<div class="col s12 z-depth-6 card-panel">
			<form:form class="login-form" method="POST" action="login"
				modelAttribute="usuario">
				<div class="row">
					<div class="input-field col s12 center">
						<img
							src="https://virtual.unipe.br/ead/acessar/img/logo_virtual.png"
							alt="" class="responsive-img valign profile-image-login">
						<p class="center login-form-text">Controle Academico - Java
							Web</p>
					</div>
				</div>
				<div class="row margin">
					<div class="input-field col s12">
						<form:input path="id_PessoaFisica" required="required" type="text" />
						<label for="email" class="center-align">Matricula</label>
					</div>
				</div>
				<div class="row margin">
					<div class="input-field col s12">
						<form:input path="senha" required="required" type="password" />
						<label for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<form:button class="btn blue-effect blue darken-2 col s12"
							type="submit" value="Login">Login</form:button>
					</div>
				</div>
			</form:form>
			
			<c:if test="${erro != null}">
				<div class="card-panel red lighten-4 red-text text-darken-4"><b>Erro!</b> ${erro}</div>
			</c:if>
			
		</div>
	</div>

	<!-- Scripts -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

</body>

</html>