<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

  <nav>
    <div class="nav-wrapper blue darken-2">
      <a class="brand-logo">Controle Academico</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li>Bem vindo ${usuario_autenticado.nome} - ${tipo_usuario}</li>
        <li><a href="logout">Sair</a></li>
      </ul>
    </div>
  </nav>

  <nav>
    <div class="nav-wrapper blue darken-2">
      <ul class="left hide-on-med-and-down">
      
      	<c:url var="url" value="../ControleAcademico" />
      
        <c:if test="${ tipo_usuario == 'Administrador' }">
	        <li><a href="../curso/listar" 	 	class="btn waves-effect waves-light blue">Cursos</a></li>
	        <li><a href="../disciplina/listar" 	class="btn waves-effect waves-light blue">Disciplinas</a></li>
	        <li><a href="../turma/listar"		class="btn waves-effect waves-light blue">Turmas</a></li>
	        <li><a href="../aluno/listar"		class="btn waves-effect waves-light blue">Alunos</a></li>
	        <li><a href="../professor/listar"	class="btn waves-effect waves-light blue">Professores</a></li>
        </c:if>
        
        <c:if test="${ tipo_usuario == 'Aluno' }">
	        <li><a href="../aluno/notas"		class="btn waves-effect waves-light blue">Notas</a></li>
	        <li><a href="../aluno/historico"	class="btn waves-effect waves-light blue">Histórico</a></li>
        </c:if>
        
        <c:if test="${ tipo_usuario == 'Professor' }">
	        <li><a href="../professor/disciplinas"	class="btn waves-effect waves-light blue">Disciplinas</a></li>
        </c:if>
        
      </ul>
    </div>
  </nav>