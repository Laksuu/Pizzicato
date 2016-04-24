<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
<link href="tyyli.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 769px)">
<link href="tyyli.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ostoskori sivu</title>
</head>
<body>


<!--  JOS KIRJAUTUNUT SIS��N N�YT� KIRAJUDU ULOS, JOS EI NIIN N�YT� KIRJAUTUMIS LOMAKE -->
			<div id="Login">
					<c:choose>
					
					<c:when test="${Username != null}">
							<h1> <c:out value="${sessionScope.Kayttaja.getUsername()}"></c:out> </h1>
							<div> <a href="Logout"> Kirjaudu ulos </a> </div>
						</c:when>
						
						<c:otherwise>
						<form method=post action="Login" id="kirjaudu_form" >
							<div id="username">
								<div> <input placeholder=username name=username required /> </div>
							</div>
							<div id="password"> 
								<div> <input placeholder=password name=password type=password required /> </div>
							</div>
							<div id="submit"> 
								<div> <button type=submit> Kirjaudu </button> </div>
							</div> 
						</form>
						<div class="error">
							<p style="color:crimson"> <c:out value="${error}"></c:out></p>
						</div>
						</c:otherwise>
						
					</c:choose>
			</div>

<div class="keho">
		<div class="header">

			<img src="Pizzicato.png" class="kuva1" />

				<!--Navigointipalkin linkkien painikkeet ovat t�ss�-->	
			<div id="navigointipalkki">
				<ul class="paavalikko">
					<li><a class="active" href="Etusivu">Etusivu</a></li>
					<li><a href="Ostoskori">Ostoskori</a></li>
					<li><a href="Yhteystiedot">Yhteystiedot</a></li>
					<li>	<c:choose>
							<c:when test="${Username != null}">
						<a href="Muokkaussivu">Muokkaussivu  </a>
							</c:when>
							</c:choose>
					
				
				</ul>
			</div>

		</div>

<br>

<table class="taulukko">
<tr>
					<th>Pizzan numero</th>
					<th>Pizza</th>
					<th>Hinta</th></tr>
<c:forEach items="${pizzat}" var = "pizza">
	
				<tr>
				<td><c:out value="${pizza.pizza_id}"></c:out></td>
				<td><c:out value="${pizza.nimi}"></c:out></td>
				<td><fmt:formatNumber type="currency"  currencySymbol=""  value="${pizza.hinta}" /> EUR</td>
				
						</tr>
</c:forEach>				
</table>


<a href="Etusivu">etusivu</a>


<div class="yhteystiedotteksti">
<h1>Pizzeria Pizzicaton yhteystiedot</h1>
<p>
</div>

			
	</div>

	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>		
</body>
</html>