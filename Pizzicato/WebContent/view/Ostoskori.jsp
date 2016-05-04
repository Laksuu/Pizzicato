<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif'
	rel='stylesheet' type='text/css'>
<link href="tyyli.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 769px)">
<link href="tyyli.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ostoskori sivu</title>
</head>
<body>


	<!--  Näytetään logout jos kirjautunut sisään! -->

			<div id="Login">
				<c:choose>

					<c:when test="${Username != null}">
						<div class="fixedlogin">
							<h1>
								<c:out value="${session.getAttribute(Username)}"></c:out>
							</h1>
							<div>
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
<span class="caps-lock-warning" title="Caps lock is on!"></span>
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
							<c:when test="${Username != null}">
								<a href="Muokkaussivu">Muokkaussivu </a>
							</c:when>
						</c:choose>
				</ul>
			</div>

		</div>

		<br>
<form action="TilausServlet" method="POST">
		<table class="taulukko">
			<tr>
				<th>Pizzan numero</th>
				<th>Pizza</th>
				<th>yksilöHinta</th>
				<th>Lukumäärä</th>
				<th>Kokonaishinta</th>
				<th>extramauste</th>				
			</tr>
			
			<c:set var="tilauksenhinta" value="0"></c:set>
			<c:forEach items="${ostokset}" var="ostos">

				<tr>
					<td><c:out value="${ostos.getPizza().getPizza_id()}"></c:out></td>
					<td><c:out value="${ostos.getPizza().getNimi()}"></c:out></td>
					<td><fmt:formatNumber type="currency" currencySymbol=""
							value="${ostos.getPizza().getHinta()}" /> EUR</td>
					<td><c:out value="${ostos.getLkm()}"></c:out></td>
					<td><fmt:formatNumber type="currency" currencySymbol=""
							value="${ostos.rivihinta}" /> EUR</td>
							<td><c:out value="${ostos.extramauste}"></c:out></td>
				
				<c:set var="tilauksenhinta" value="${tilauksenhinta + ostos.rivihinta}"></c:set>
				
				</tr>
			
			
			
			</c:forEach>
			<tr>
			<td> Yhteensä
			<c:out value="${tilauksenhinta}"> </c:out> euroa
			</td>
			</tr>
		</table>

	
<table id="tilauslomake">
<tr>
<th>Tilauslomake</th>
</tr>
<tr>
<td>Nimi:</td> 
<td><input type="text" name="nimi" value="Etunimi Sukunimi"></td>
</tr>
<tr>
<td>Osoite:</td> 
<td><input type="text" name="osoite" value="esimerkkikuja 2 vantaa"></td>
</tr>
<tr>
<td>Puh:</td> 
<td><input type="text" name="puh" value="045 9325948"></td>
</tr>
<tr>
<td>Sähköposti:</td>
<td><input type="text" name="sposti" value="esimerkki@gmail.com"></td>
</tr>
<tr>
<td>Nouto vai kotiinkuljetus?</td>
<td><input type="radio" name="toimitus" value="0" checked> Nouto
  <input type="radio" name="toimitus" value="1"> Kotiinkuljetus
</td>
</tr>
<tr>
<td>Maksutapa?</td>
<td> <input type="radio" name="maksutapa" value="0" checked> Käteinen
  <input type="radio" name="maksutapa" value="1"> Kortti

</td>
</tr>
<tr>
<td><input type="submit" value="Tilaa"></td>
</tr>
</table>
</form>
		<form action=Etusivu>
			<p>Siirry takaisin Etusivulle</p>
			<button type="submit">Siirry</button>
		</form>


	</div>

	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>
</body>
</html>