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
	
		<h4>Semestre atual: ${semestre}</h4>

		<table id="data-table-simple" class="highlight">
			<thead>
				<tr>
					<th>Disciplinas atualmente cursando</th>
					<th>Estário 1</th>
					<th>Estário 2</th>
					<th>Estário 3</th>
					<th>Final</th>
					<th>Média</th>
					<th>Situação</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach var="matricula_turma" items="${notas_turmas}">
					<tr>
						<td>${matricula_turma.turma.disciplina.nome}</td>
						<td>${matricula_turma.notaPrimeiroEstagio}</td>
						<td>${matricula_turma.notaSegundoEstagio}</td>
						<td>${matricula_turma.notaTerceiroEstagio}</td>
						<td>${matricula_turma.notaFinal}</td>
						<td>${matricula_turma.getMedia()}</td>
						<td>
							<c:if test="${ matricula_turma.getMedia() > 7.00 }">
								APROVADO
							</c:if>
							<c:if test="${ matricula_turma.getMedia() < 7.00 }">
								REPROVADO
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	
		<jsp:include page="../footer.jsp" />
		<jsp:include page="../scripts.jsp" />
	</body>

</html>