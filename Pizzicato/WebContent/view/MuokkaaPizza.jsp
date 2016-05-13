<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="pizzicato.model.Pizza"%>
	<%@ page import="pizzicato.control.MuokkaaPizza"%>
	<%@ page import="pizzicato.model.Tayte"%>
	<%@ page import="java.util.Collection, java.util.ArrayList"%>
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

			
			<!--  Näytetään logout jos kirjautunut sisään! -->

			<div id="Login">
				<c:choose>

					<c:when test="${Username != null}">
						<div class="fixedlogin">
							<div>
								<a><c:out value=" ${Username}" /></a>
								<a href="Logout"> Kirjaudu ulos </a>
							</div>
						</div>
					</c:when>

					<c:otherwise>
						<div class="fixedlogin2">
							<br>
							<form method=post action="Login" id="kirjaudu_form">
								<div id="username">
									<div>
										<input placeholder=username name=username required />
									</div>
								</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<input placeholder=password name=password id=password type=password />
<span class="caps-lock-warning" title="Caps lock on päällä!"></span>
								<div id="submit">
									<div>
										<button type=submit>Kirjaudu</button>
									</div>
								</div>
							</form>
							<div class="error">
								<p style="color: crimson">
									<c:out value="${error}"></c:out>
								</p>
							</div>
						</div>
					</c:otherwise>

				</c:choose>

			</div>



<div class="keho">
		<div class="header">

			<img src="Pizzicato.png" class="kuva1" />

<!--Navigointipalkin linkkien painikkeet ovat tässä-->
			<div id="navigointipalkki">
				<ul class="paavalikko">
					<li><a class="active" href="Etusivu">Etusivu</a></li>
					<li><a href="Ostoskori">Ostoskori</a></li>
					<li><a href="Yhteystiedot">Yhteystiedot</a></li>
					<li><c:choose>
					
							<c:when test="${Logtype ==\"master\"}">
								<a href="Muokkaussivu">Muokkaussivu </a>
							</c:when>
						</c:choose>
					<li><c:choose>
							<c:when test="${Logtype == \"kokki\"}">
								<a href="Kokki">Kokin näkymä </a>
							</c:when>
						</c:choose>
				</ul>
			</div>

		</div>


<br><form action="MuokkaaPizza" method="POST">
<table class="taulukko">
		<jsp:useBean id="pizza" class="pizzicato.model.Pizza" scope="request" />
		<jsp:useBean id="taytteet" type="java.util.ArrayList<Tayte>" scope="request" />
			
			<tr>
			
				<td><%=pizza.getNimi()%></td>
				<td><%=pizza.getHinta()%></td>

				<td>
					
						<input type=hidden name=pizza_id value="<%=pizza.getPizza_id()%>"/>
						<input type="text" name="nimi" value="<%=pizza.getNimi()%>"/>
						<input type="text" name="hinta" value="<%=pizza.getHinta()%>" /> </td>
					<td>	<input type=submit name= Tallenna class="submit-button" value="Tallenna" /> </td>
					
					</tr>
					<tr>
					<td rowspan =2;>
					<%
						for (int i = 0; i < taytteet.size(); i++) {
					%>
				
				
					
					<input type="checkbox" name=taytteet value="<%=taytteet.get(i).getTayte_id()%>"><%=taytteet.get(i).getTayte()%>
				
					
					<%
						}
					%>
					</td>
					</tr>
					
		
	
		</table></form>	

			<br> <br> <br> <br> <br> <br> <br>

	</div>

	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>
			
			

</body>
</html>