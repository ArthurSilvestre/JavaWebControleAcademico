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
		<link type="text/css" rel="stylesheet" href="../css/materialize.min.css" media="screen,projection" />
	</head>

	<body>
		<jsp:include page="../menu.jsp" />

		<div class="row">
			<form class="col s12">
			  Filtro:
		      <div class="input-field inline">
			      <input type="text" id="input_filter" onkeyup="filter(1,'input_filter','data-table-simple')"/>
			      <label for="input_filter">Nome</label>
	 	      </div>
			</form>
		</div>
	
		<ul class="left hide-on-med-and-down">
			<li><a href="../professor/incluir" class="btn waves-effect waves-light blue">Novo</a></li>	
		</ul>
		
		<table id="data-table-simple" class="highlight">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Professor</th>
					<th>A��es</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach var="professor" items="${professores}">
					<tr>
						<td>${professor.id_PessoaFisica}</td>
						<td>${professor.nome}</td>
						<td>
							<a href="../professor/editar/${professor.id_PessoaFisica}" class="btn waves-effect waves-light blue">Editar</a>
							<a href="../professor/deletar/${professor.id_PessoaFisica}" class="btn waves-effect waves-light red">Deletar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>	
	
		<jsp:include page="../footer.jsp" />
		<jsp:include page="../scripts.jsp" />
	</body>

</html>