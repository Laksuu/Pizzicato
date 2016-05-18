<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif'
	rel='stylesheet' type='text/css'>
<%@ page import="pizzicato.model.Pizza"%>
<%@ page import="pizzicato.model.Tayte"%>
<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>"
	scope="request" />
<%@ page import="java.util.Collection,
				java.util.ArrayList"%>

<link href="tyyli.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 769px)">


<link href="tyyli.css" rel="stylesheet" type="text/css">

<link rel="shortcut icon" href="faviconi.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pizzeria Pizzicato</title>
</head>
<body>
	<div class="keho">
		<div class="header">

			<img src="Pizzicato.png" class="kuva1" />


			<div class="fixedpuhno">
				<b>Pizzeria Pizzicato <br>Helsinki<br> P. 0500555555
				</b> <br> <a href="Ostoskori">Ostoskori</a>
			</div>


			<!--  Näytetään logout jos kirjautunut sisään! -->

			<div id="Login">
				<c:choose>

					<c:when test="${Username != null}">
						<div class="fixedlogin">
							<div>
								<a><c:out value=" ${Username}" /></a> <a href="Logout">
									Kirjaudu ulos </a>
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
								<script
									src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
								<input placeholder=password name=password id=password
									type=password /> <span class="caps-lock-warning"
									title="Caps lock on päällä!"></span>
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


		<div id="kuvajono">
			<img src="kuva3.jpg" class="kuva3" /> <img src="pizza.jpg"
				class="kuva4" /> <img src="tausta.jpg" class="kuva5" />
		</div>

		<br>

		<hr>

		<br> <br>

		<div class="otsikko">
			<h1>Pizzalista</h1>
		</div>






		<table class="taulukko">


			<tr>
				<th>Pizzan numero</th>
				<th>Pizza</th>
				<th>Hinta</th>
				<th>kpl</th>
				<th>mausteet</th>
				<th>mausteet</th>
				<th></th>
				<th>tilaus</th>
			</tr>

			<%
				Pizza pizza;
				Tayte tayte;
				for (int i = 0; i < pizzat.size(); i++) {
					pizza = pizzat.get(i);
			%>
			<tr>
				<td><form action="Ostoskori" method="POST"><%=i + 1%></td>
				<td><%=pizza.getNimi()%> <br>
					<div class="pienempifontti">

						<%
							for (int t = 0; t < pizza.getTayteMaara(); t++) {
									tayte = pizza.getTayte(t);
						%>
						<%=tayte.getTayte()%>
						<%
							}
						%>
					</div></td>
				<td><%=pizza.getHinta()%>€</td>

				<td>Määrä: <select name="lkm">
						<option value="0">0 kpl</option>
						<option value="1">1 kpl</option>
						<option value="2">2 kpl</option>
						<option value="3">3 kpl</option>
						<option value="4">4 kpl</option>
						<option value="5">5 kpl</option>
						<option value="6">6 kpl</option>
						<option value="7">7 kpl</option>
						<option value="8">8 kpl</option>
						<option value="9">9 kpl</option>
				</select><input type="hidden" name="action" value="add">


				</td>
				<td class="pmauste"><input type="checkbox" name="oregano"
					value="1"> oregano<br> <input type="checkbox"
					name="valkosipuli" value="3"> valkosipuli</td>
				<td><input type=hidden name=pizza_id
					value=<%=pizza.getPizza_id()%> /></td>
				<td>
					<button class="nappula" type="submit" value="add">Tilaa</button>
					</form>
				</td>
			</tr>

			<%
				}
			%>
		</table>





		<br> <br> <br>
		<hr>

		<div id="aukioloajat">
			<div class="teksti">


				<div class="puhnum"></div>


				<h4>
					<b><font size="5">Avoinna</font><br> &nbsp;&nbsp;Ma-pe:
						10.00 - 23.00<br> &nbsp;&nbsp;La: 11.00 - 23.00<br>
						&nbsp;&nbsp;Su: 11.00 - 23.00</b>
				</h4>


				<h1>Tervetuloa herkuttelemaan!</h1>
				<h4>
					Helsingin keskustassa jo vuodesta 1999 toiminut Pizzeria Pizzicato
					kuuluu paikkakunnan suosituimpiin ruokapaikkoihin. Vuosien varrella
					pizzojen lisäksi rento tunnelma ja loistava asiakaspalvelu. <br>
					<br> Meillä voit nauttia ruokailusta savuttomasti viihtyisässä
					ympäristössä. TERVETULOA!
				</h4>



			</div>


		</div>
		<br>
		<hr>
		<br>
	</div>



	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>

</body>
</html>
