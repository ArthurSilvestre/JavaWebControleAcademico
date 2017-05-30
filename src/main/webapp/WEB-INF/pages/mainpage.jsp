<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>Main Page - Controle Academico</title>

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" type="text/css" href="css/mainpage.css" />

</head>
<body>
	<!-- Header -->
	<nav class="nav-extended">
	<div class="nav-wrapper">
		<a href="#" class="brand-logo">Controle Academico</a> <a href="#"
			class="button-collapse"></a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li>Bem vindo {usuario.nome} ({usuario.tipo})</li>
			<li><a href="collapsible.html">Sair</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="collapsible.html">Sair</a></li>
		</ul>
	</div>
	<div class="nav-content">
		<ul class="tabs tabs-transparent">
			<li class="tab"><a href="#cursos" class="active">Cursos</a></li>
			<li class="tab"><a href="#disciplinas">Disciplinas</a></li>
			<li class="tab"><a href="#turmas">Turmas</a></li>
			<li class="tab"><a href="#alunos">Alunos</a></li>
			<li class="tab"><a href="#professores">Professores</a></li>
		</ul>
	</div>
	</nav>

	<!-- Body -->

	<div id="cursos" class="col s12">
		<h4>Listagem de cursos</h4>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="col s12">
						Buscar por nome:
						<div class="input-field inline">
							<input type="text" /> <label for="email">Ex: Janio</label>
						</div>
						<a class="waves-effect waves-light btn">Pesquisar</a>
					</div>
				</div>
			</form>
		</div>

		<a class="waves-effect waves-light btn">Novo</a>

		<div id="demo">
			<!-- Responsive table starts here -->
			<!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
			<div class="table-responsive-vertical shadow-z-1">
				<!-- Table starts here -->
				<table id="table" class="table table-hover table-mc-light-blue">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Tipo</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>ID</td>
							<td>NOME</td>
							<td>TIPO</td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="disciplinas" class="col s12">
		<h4>Listagem de disciplinas</h4>

		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="col s12">
						Buscar por nome:
						<div class="input-field inline">
							<input type="text" /> <label for="email">Ex: Janio</label>
						</div>
						<a class="waves-effect waves-light btn">Pesquisar</a>
					</div>
				</div>
			</form>
		</div>

		<a class="waves-effect waves-light btn">Novo</a>

		<div id="demo">
			<!-- Responsive table starts here -->
			<!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
			<div class="table-responsive-vertical shadow-z-1">
				<!-- Table starts here -->
				<table id="table" class="table table-hover table-mc-light-blue">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Nome</th>
							<th>Curso</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>ID</td>
							<td>NOME</td>
							<td>NOME DO CURSO</td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="turmas" class="col s12">
		<h4>Listagem de turmas</h4>

		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="col s12">
						Buscar por nome:
						<div class="input-field inline">
							<input type="text" /> <label for="email">Ex: Janio</label>
						</div>
						Semestre:
						<div class="input-field inline">
							<input type="text" /> <label for="email">Ex: Janio</label>
						</div>
						Curso:
						<div class="input-field inline">
							<select>
								<option value="0" disabled selected></option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
						</div>
						<a class="waves-effect waves-light btn">Pesquisar</a>
					</div>
				</div>
			</form>
		</div>

		<a class="waves-effect waves-light btn">Novo</a>

		<div id="demo">
			<!-- Responsive table starts here -->
			<!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
			<div class="table-responsive-vertical shadow-z-1">
				<!-- Table starts here -->
				<table id="table" class="table table-hover table-mc-light-blue">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Semestre</th>
							<th>Disciplina</th>
							<th>Curso</th>
							<th>Professor</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>ID</td>
							<td>SEMESTRE</td>
							<td>DISCIPLINA</td>
							<td>CURSO</td>
							<td>PROFESSOR</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="alunos" class="col s12">
		<h4>Listagem de disciplinas</h4>

		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="col s12">
						Buscar por matricula:
						<div class="input-field inline">
							<input id="email" type="email"> <label for="email">Ex:
									Janio</label>
						</div>
						Nome:
						<div class="input-field inline">
							<input id="email" type="email"> <label for="email">Ex:
									Janio</label>
						</div>
						<a class="waves-effect waves-light btn">Pesquisar</a>
					</div>
				</div>
			</form>
		</div>

		<a class="waves-effect waves-light btn">Novo</a>

		<div id="demo">
			<!-- Responsive table starts here -->
			<!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
			<div class="table-responsive-vertical shadow-z-1">
				<!-- Table starts here -->
				<table id="table" class="table table-hover table-mc-light-blue">
					<thead>
						<tr>
							<th>Matricula</th>
							<th>Nome</th>
							<th>Curso</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>MATRICULA</td>
							<td>NOME</td>
							<td>NOME CURSO</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div id="professores" class="col s12">
		<h4>Listagem de turmas</h4>

		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="col s12">
						Buscar por nome:
						<div class="input-field inline">
							<input type="text"/> <label for="email">Ex: Janio</label>
						</div>
						Disciplina:
						<div class="input-field inline">
							<select>
								<option value="0" disabled selected></option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
							</select>
						</div>
						<a class="waves-effect waves-light btn">Pesquisar</a>
					</div>
				</div>
			</form>
		</div>

		<a class="waves-effect waves-light btn">Novo</a>

		<div id="demo">
			<!-- Responsive table starts here -->
			<!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
			<div class="table-responsive-vertical shadow-z-1">
				<!-- Table starts here -->
				<table id="table" class="table table-hover table-mc-light-blue">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Professor</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td>ID</td>
							<td>NOME</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="page-footer">
	<div class="footer-copyright">
		<div class="container">© 2017.1 Desenvolvido pelos alunos de CC</div>
	</div>
	</footer>

	<!-- Scripts -->
	<!-- jQuery Library -->
	<script type="text/javascript"
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!--materialize js-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

	<script type="text/javascript">

	  $(document).ready(function() {
	    $('select').material_select();
	  });
	  
	  $('select').material_select('destroy');
	  	            
	</script>

</body>
</html>