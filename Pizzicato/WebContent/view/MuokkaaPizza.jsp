
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="pizzicato.model.Pizza"%>
	<%@ page import="pizzicato.control.MuokkaaPizza"%>
<html>
<head>
<link href="tyyli.css" rel="stylesheet" type="text/css">
<link href="tyyli.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 769px)">
	<link rel="shortcut icon" href="faviconi.ico" />
<link href='https://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Muokkaa Pizzaa</title>
</head>
<body>

<div class="keho">
		<div class="header">

			<img src="Pizzicato.png" class="kuva1" />

			<!--Navigointipalkin linkkien painikkeet ovat tässä-->
			<div id="navigointipalkki">
				<ul class="paavalikko">
					<li><a class="active" href="Etusivu">Etusivu</a></li>
					<li><a href="Ostoskori">Ostoskori</a></li>
					<li><a href="PizzicatoControl">Yhteystiedot</a></li>
				</ul>
			</div>

		</div>


<br>
<table class="taulukko">
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

			<br> <br> <br> <br> <br> <br> <br>

	</div>

	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>
			
			

</body>
</html>