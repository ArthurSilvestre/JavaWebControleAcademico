<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>Lista de Cursos</title>
		<link type="text/css" rel="stylesheet" href="../../css/materialize.min.css" media="screen,projection" />
	</head>

	<body>
		<jsp:include page="../menu.jsp" />
	
		<div class="row">

		  <form:form modelAttribute="disciplina" method="POST" action="../salvar" class="col s12">

		    <div class="row">

		      <div class="input-field col s12">
		        <form:input readonly="true" path="id_Disciplina" id="idDisciplina" type="text" value="${disciplina.id_Disciplina}"/>
		        <label for="idDisciplina">ID</label>
		      </div>

		      <div class="input-field col s12">
		        <form:input path="nome" id="nomeDisciplina" type="text"/>
		        <label for="nomeDisciplina">Nome</label>
		      </div>

		      <div class="input-field col s12">
		        <form:input path="area" id="areaDisciplina" type="text"/>
		        <label for="areaDisciplina">Area</label>
		      </div>

			  <div class="input-field col s12">
			    <form:select path="curso" items="${cursos}" itemLabel="nome"/>
			    <label>Curso</label>
			  </div>

		    </div>
		    
			<div class="row">
				<div class="input-field col s12">
					<form:button class="btn blue-effect blue darken-2 col s12" type="submit" value="Salvar">Salvar</form:button>
				</div>
			</div>
				
		  </form:form>

		</div>		
	
		<jsp:include page="../footer.jsp" />
		<jsp:include page="../scripts.jsp" />
	</body>

</html>