<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="pizzicato.model.Pizza"%>
<%@ page import="pizzicato.model.Tayte"%>
<html>
<head>
<link rel="shortcut icon" href="faviconi.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="tyyli.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:useBean id="taytteet" type="java.util.ArrayList<Tayte>"
	scope="request" />
<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>"
	scope="request" />
<%@ page import="java.util.Collection, java.util.ArrayList"%>
<title>Muokkaussivu</title>
</head>
<body>
	<div class="keho">
		<div class="header">

			<img src="Pizzicato.png" class="kuva1" />

			<!--Navigointipalkin linkkien painikkeet ovat t‰ss‰-->
			<div id="navigointipalkki">
				<ul class="paavalikko">
					<li><a href="Etusivu">Etusivu</a></li>
					<li><a class="active" href="Muokkaussivu">Muokkaussivu</a></li>
					<li><a href="Ostoskori">Ostoskori</a></li>
					<li><a href="Yhteystiedot">Yhteystiedot</a></li>
					<li><a href="Logout">Kirjaudu ulos</a>
				</ul>
			</div>

		</div>







		<h1>Muokkaussivu</h1>

		<table class="admintaulukko">


			<%
				for (int i = 0; i < pizzat.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=pizzat.get(i).getNimi()%></td>
				<td><%=pizzat.get(i).getHinta()%></td>

				<td>
					<form action="/Pizzicato/PiilotaPizza" method="POST">
						<input type="hidden" name="id"
							value="<%=pizzat.get(i).getPizza_id()%>" /> <input type=submit
							name="submit-button" class="submit-button" value="Piilota" />
					</form>
				</td>
				<td><form action="Poistapizza" method="POST">
						<input type=hidden name=pizza_id
							value="<%=pizzat.get(i).getPizza_id()%>" /> <input type=submit
							name="submit-button" class="submit-button" value="Poista" />
					</form>
				<td>
					<form action="/Pizzicato/MuokkaaPizza" method="GET">
						<input type=hidden name="pizza_id"
							value="<%=pizzat.get(i).getPizza_id()%>" /> <input type=hidden
							name="nimi" value="<%=pizzat.get(i).getNimi()%>" /> <input
							type=hidden name="hinta" value="<%=pizzat.get(i).getHinta()%>" />
						<input type=submit name="Muokkaa" class="submit-button"
							value="Muokkaa" />
					</form>

				</td>
			</tr>

			<%
				}
			%>
		</table>
		<hr>

		<br> <br>

		<h2>Piilotetut pizzat</h2>

		<table class="admintaulukko">
			<jsp:useBean id="piilopizzat" type="java.util.ArrayList<Pizza>"
				scope="request" />
			<%
				for (int i = 0; i < piilopizzat.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=piilopizzat.get(i).getNimi()%></td>
				<td><%=piilopizzat.get(i).getHinta()%></td>

				<td>
					<form action="/Pizzicato/NaytaPiilotetutPizzat" method="POST">
						<input type="hidden" name="id"
							value="<%=piilopizzat.get(i).getPizza_id()%>" /> <input
							type=submit name="submit-button" class="submit-button"
							value="N‰yt‰" />
					</form>
				</td>
			</tr>

			<%
				}
			%>
		</table>
		<hr>
		<h2>Lis‰‰ uusi pizza</h2>
		<form action="Lisaapizza" method="POST">
			<table class="admintaulukko">
				<jsp:useBean id="jsp" scope="request" class="java.lang.String" />
				<tr>
					<td>Anna pizzan nimi:</td>
					<td><input type="text" value="" name="nimi" size="60" /></td>
				</tr>
				<tr>
					<td>Anna pizzan hinta:</td>
					<td><input type="text" value="" name="hinta" size="60" /></td>
				</tr>
				<tr>

					<%
						for (int i = 0; i < taytteet.size(); i++) {
					%>
				
				<tr>
					<td id="piilossa" style="display: none;"><%=i + 1%></td>
					<td></td>
					<td><input type="checkbox" name=tayte value="Tid"><%=taytteet.get(i).getTayte()%></td>

					<%
						}
					%>

					</td>
				</tr>

				<tr>
					<td><input type="submit" name="submit-button"
						class="submit-button" value="Tallenna" /></td>
				</tr>
			</table>
		</form>

		<hr>
		<table class="admintaulukko">


			<%
				for (int i = 0; i < taytteet.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=taytteet.get(i).getTayte()%></td>
				<td><%=taytteet.get(i).getTayte_hinta()%></td>

				<td>
					<form action="/Pizzicato/PiilotaTayte" method="POST">
						<input type="hidden" name="tid"
							value="<%=taytteet.get(i).getTayte_id()%>" /> <input type=submit
							name="submit-button" class="submit-button" value="Piilota" />
					</form>
				</td>
				<td><form action="Poistatayte" method="POST">
						<input type=hidden name=tayte_id
							value="<%=taytteet.get(i).getTayte_id()%>" /> <input type=submit
							name="submit-button" class="submit-button" value="Poista" />
					</form>
				<td>
					<form action="/Pizzicato/MuokkaaTayte" method="GET">
						<input type=hidden name="tayte_id"
							value="<%=taytteet.get(i).getTayte_id()%>" /> <input type=hidden
							name="tayte" value="<%=taytteet.get(i).getTayte()%>" /> <input
							type=hidden name="tayte_hinta"
							value="<%=taytteet.get(i).getTayte_hinta()%>" /> <input
							type=submit name="Muokkaa" class="submit-button" value="Muokkaa" />
					</form>

				</td>
			</tr>

			<%
				}
			%>
		</table>
		<hr>

		<br> <br>

		<h2>Piilotetut taytteet</h2>

		<table class="admintaulukko">
			<jsp:useBean id="piilotaytteet" type="java.util.ArrayList<Tayte>"
				scope="request" />
			<%
				for (int i = 0; i < piilotaytteet.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=piilotaytteet.get(i).getTayte()%></td>
				<td><%=piilotaytteet.get(i).getTayte_hinta()%></td>

				<td>
					<form action="/Pizzicato/NaytaPiilotetutTaytteet" method="POST">
						<input type="hidden" name="tid"
							value="<%=piilotaytteet.get(i).getTayte_id()%>" /> <input
							type=submit name="submit-button" class="submit-button"
							value="N‰yt‰" />
					</form>
				</td>
			</tr>

			<%
				}
			%>
		</table>
		<hr>





		<h2>Lis‰‰ uusi t‰yte</h2>
		<form action="Lisaatayte" method="POST">
			<table class="admintaulukko">
				<jsp:useBean id="tjsp" scope="request" class="java.lang.String" />

				<tr>
					<td>Anna t‰ytteen nimike:</td>
					<td><input type="text" value="" name="tayte" size="60" /></td>
				</tr>
				<tr>
					<td>Anna t‰ytteen kilohinta:</td>
					<td><input type="text" value="" name="tayte_hinta" size="60" /></td>
				</tr>

				<td><input type="submit" name="submit-button"
					class="submit-button" value="Tallenna" /></td>
			</table>
		</form>
		<hr>

		<br> <br> <br> <br> <br> <br> <br>


	</div>
	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>


</body>
</html>
