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

		<form:form method="post" action="../../professor/salvarnotas" modelAttribute="list_of_matricula_turma">
			<table id="data-table-simple" class="highlight">
				<tr>
					<th>Matricula</th>
					<th>Nome</th>
					<th>Estágio 1</th>
					<th>Estágio 2</th>
					<th>Estágio 3</th>
					<th>Final</th>
					<th>Média</th>
					<th>Situação</th>
				</tr>
				<c:forEach items="${list_of_matricula_turma.matriculaTurmas}" var="matriculaTurma" varStatus="status">
					<form:input type="hidden" path="matriculaTurmas[${status.index}].id_MatriculaTurma"/>
					<form:input type="hidden" path="matriculaTurmas[${status.index}].aluno"/>
					<form:input type="hidden" path="matriculaTurmas[${status.index}].turma"/>
					<tr>
						<td><form:input type="hidden" path="matriculaTurmas[${status.index}].aluno.id_PessoaFisica"/>${matriculaTurma.aluno.id_PessoaFisica}</td>
						<td><form:input type="hidden" path="matriculaTurmas[${status.index}].aluno.nome"/>${matriculaTurma.aluno.nome}</td>
						<td><form:input path="matriculaTurmas[${status.index}].notaPrimeiroEstagio"/></td>
						<td><form:input path="matriculaTurmas[${status.index}].notaSegundoEstagio"/></td>
						<td><form:input path="matriculaTurmas[${status.index}].notaTerceiroEstagio"/></td>
						<td><form:input path="matriculaTurmas[${status.index}].notaFinal"/></td>
						<td>${matriculaTurma.getMedia()}</td>
						<td>
							<c:if test="${ matriculaTurma.getMedia() > 7.00 }">
								APROVADO
							</c:if>
							<c:if test="${ matriculaTurma.getMedia() < 7.00 }">
								REPROVADO
							</c:if>
						</td>						
					</tr>
				</c:forEach>
			</table>	
			<input class="btn waves-effect waves-light blue" type="submit" value="Salvar"/>	
		</form:form>

		<jsp:include page="../footer.jsp" />
		<jsp:include page="../scripts.jsp" />
	</body>

</html>