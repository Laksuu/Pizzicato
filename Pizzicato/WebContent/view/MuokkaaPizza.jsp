
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="pizzicato.model.Pizza"%>
	<%@ page import="pizzicato.control.MuokkaaPizza"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Muokkaa Pizzaa</title>
</head>
<body>


	<div class="container">
	 <img src="Pizzicato.jpeg"
			class="img-responsive center-block" alt="Responsive image" />
		</a>

	</div>
	<!--Navigointipalkin linkkien painikkeet ovat tässä-->
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="etusivu">Etusivu</a></li>
			<li><a href="PizzicatoControl">Yhteystiedot</a></li>
		</ul>
	</div>

	<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
	</nav>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron">

		<div class="row">
			<div class="col-md-4">



<table width="336" id=pizzalista border="1" align="center">
		<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>" scope="request" />
			<%@ page import="java.util.Collection, java.util.ArrayList"%>
			
			<%
				for (int i = 0; i < pizzat.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=pizzat.get(i).getNimi()%></td>
				<td><%=pizzat.get(i).getHinta()%></td>

				<td>
					<form action="MuokkaaPizza" method="POST">
						<input type=hidden name=pizza_id value="<%=pizzat.get(i).getPizza_id()%>"/>
						<input type="text" name="nimi" value="<%=pizzat.get(i).getNimi()%>"/>
						<input type="text" name="hinta" value="<%=pizzat.get(i).getHinta()%>" />
						<input type=submit name= Tallenna class="submit-button" value="Tallenna" />
					
					</form>
				</td>
	<%
				}
			%>
			</table>

			
			
<!--/.container-fluid -->
	</nav>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron">

		<footer class="footer">
		<div class="row">
			<div class="col-xs-4 col-md-4">
				<h3>
					Pizzeria Pizzicato<br> <br> Pizzantie 10
				</h3>
			</div>
			<div class="col-xs-4 col-md-4">
				<h3>01320 Vantaa</h3>
			</div>
			<div class="col-xs-4 col-md-4">
				<h3>
					pizzeriapizzicato@pizzicato.fi<span class="pull-right">
				</h3>
				</span>
			</div>
		</div>
		</footer>
</body>
</html>