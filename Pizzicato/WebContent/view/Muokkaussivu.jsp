<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="pizzicato.model.Pizza"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>

<link href="puhelin.css"
rel="stylesheet" type="text/css"
media="only screen and (min-width: 0px)
and (max-width: 360px)" >

<link href="sormitietokone.css"
rel="stylesheet" type="text/css"
media="only screen and (min-width: 361px)
and (max-width: 768px)" >

<link href="tyyli.css"
rel="stylesheet" type="text/css"
media="only screen and (min-width: 769px)" >


<link href="tyyli.css" rel="stylesheet" type="text/css">

<link rel="shortcut icon" href="faviconi.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pizzeria Pizzicato</title>
</head>
<body>
	

 	<div class="container">
	<img src="Pizzicato.jpeg"
			class="img-responsive center-block" alt="Responsive image" />
		</a>

	</div>
	<!--Navigointipalkin linkkien painikkeet ovat t‰ss‰-->
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

				<div id="yhteystiedot">
        



<h1>Muokkaussivu</h1>

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
					<form action="/Pizzicato/PiilotaPizza" method="POST">
						<input type="hidden" name="id" value="<%=pizzat.get(i).getPizza_id()%>"/>
						<input type=submit name="submit-button" class="submit-button" value="Piilota" />
					</form>
				</td>
				<td><form action="Poistapizza" method="POST">
<input type=hidden name=pizza_id value="<%=pizzat.get(i).getPizza_id()%>"/>
<input type=submit name="submit-button" class="submit-button" value="Poista" />
</form>
<td>
<form action="/Pizzicato/MuokkaaPizza" method="GET">
<input type=hidden name="pizza_id" value="<%=pizzat.get(i).getPizza_id()%>"/>
<input type=hidden name="nimi" value="<%=pizzat.get(i).getNimi()%>"/>
<input type=hidden name="hinta" value="<%=pizzat.get(i).getHinta()%>"/>
<input type=submit name="Muokkaa" class="submit-button" value="Muokkaa" />
</form>

</td>
			</tr>

			<%
				}
			%>
		</table>


<br>
<br>

<h2> Piilotetut pizzat</h2>

		<table width="336" id=pizzalista border="1" align="center">
			<jsp:useBean id="piilopizzat" type="java.util.ArrayList<Pizza>" scope="request" />
			<%
				for (int i = 0; i < piilopizzat.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=piilopizzat.get(i).getNimi()%></td>
				<td><%=piilopizzat.get(i).getHinta()%></td>

				<td>
					<form action="/Pizzicato/NaytaPiilotetutPizzat" method="POST">
						<input type="hidden" name="id" value="<%=piilopizzat.get(i).getPizza_id()%>"/>
						<input type=submit name="submit-button" class="submit-button" value="N‰yt‰" />
					</form>
				</td>
			</tr>

			<%
				}
			%>
		</table>
		
	<h2>Lis‰‰ uusi pizza</h2>
	<form action="Lisaapizza" method="POST">
		<table class="lis‰‰pizza">
		<jsp:useBean id="jsp" scope="request" class="java.lang.String" />
	
			<tr>
				<td>Anna pizzan nimi:</td>
				<td><input type="text" value="" name="nimi" size="60" /></td>
			</tr>
			<tr>
				<td>Anna pizzan hinta:</td>
				<td><input type="text" value="" name="hinta" size="60" /></td>
			</tr>
	<!-- 		<tr>
				<td>Anna pizzan t‰ytteet:</td>
				<td><input type="text" value="" name="tayte_id" size="60" /></td>
			</tr> -->
			<td><input type="submit" name="submit-button"
				class="submit-button" value="Tallenna" /></td>
		</table>
		</form>
		
		
		
	      </div>


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