<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
<link href="tyyli.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 769px)">
<link href="tyyli.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



   <title>Kirjaudu</title>

</head>
<!--  N‰ytet‰‰n logout jos kirjautunut sis‰‰n! -->

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
<span class="caps-lock-warning" title="Caps lock on p‰‰ll‰!"></span>
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

			<!--Navigointipalkin linkkien painikkeet ovat t‰ss‰-->
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
								<a href="Kokki">Kokin n‰kym‰ </a>
							</c:when>
						</c:choose>
				</ul>
			</div>

		</div>
<h1>Kirjaudu sis‰‰n</h1>
<% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<p>" + message + "</p>");
   }
%>

<form method="post" action="">
   <div>
      Kayttajatunnus: <br>	<input type="text" name="username" size="36" />

   </div>
   <div>
      Salasana:		<br>	<input type="password" name="password" size="36" />

   </div>
   <div>
      <input type="submit" value="Kirjaudu" />
   </div>
<br>
<br>
<br>
</form>
</div>
</body>
</html>