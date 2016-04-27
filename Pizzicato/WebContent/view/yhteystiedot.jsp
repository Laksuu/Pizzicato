<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
<link href="tyyli.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 769px)">
<link href="tyyli.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yhteystiedot sivu</title>
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

<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1982.75271746526!2d24.931852016103985!3d60.201375147838405!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1h!3m3!1m2!1s0x469209921fdba137%3A0x841c90a2862185af!2sRatapiantie+13%2C+00520+Helsinki!5e0!3m2!1sfi!2sfi!4v1455610433438"
			allowfullscreen></iframe>
<div class="teksti">
<h1>Pizzeria Pizzicaton yhteystiedot</h1>
<br>
<h4>Puh: 045 1234567</h4>
<h4>Osoite: Pizzantie 10 01320 Helsinki</h4>
<h4>Sähköpostiosoite: pizzicato@gmail.com</h4>

</div>

<img src="tyontekijat.jpg" class="kuva6" />	
<br>
<br>
<br>
<br><br><br><br><br><br><br><br><br><br><br>	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	

<br><br>
<hr>
</div>

	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>		
</body>
</html>