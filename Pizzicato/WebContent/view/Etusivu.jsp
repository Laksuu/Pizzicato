<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="pizzicato.model.Pizza"%>
<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>"
	scope="request" />
<%@ page import="java.util.Collection,
				java.util.ArrayList"%>
<link href="puhelin.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 0px)
and (max-width: 360px)">

<link href="sormitietokone.css" rel="stylesheet" type="text/css"
	media="only screen and (min-width: 361px)
and (max-width: 768px)">

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

	<div class="kuva1">
		 <img src="Pizzicato.png" />
		

	</div>
	<!--Navigointipalkin linkkien painikkeet ovat tässä-->
	<div id="navigointipalkki">
		<ul class="paavalikko">
			<li><a class="active" href="etusivu">Etusivu</a></li>
			<li><a href="Muokkaussivu">Muokkaussivu</a></li>
			<li><a href="Ostoskori">Ostoskori</a></li>
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

					Pizzeria Pizzicato<br> Pizzantie 10<br> 01320 Vantaa<br>
					pizzeriapizzicato@pizzicato.fi


				</div>
				
				
				
				
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1982.75271746526!2d24.931852016103985!3d60.201375147838405!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1h!3m3!1m2!1s0x469209921fdba137%3A0x841c90a2862185af!2sRatapiantie+13%2C+00520+Helsinki!5e0!3m2!1sfi!2sfi!4v1455610433438"
					allowfullscreen></iframe>

				<div class="table-responsive">


					<h2>Aukioloajat</h2>
					<table class="table table-bordered">

						<tbody>
							<tr class="active">
								<td>Maanantai</td>
								<td>10:00-23:00</td>

							</tr>
							<tr class="active">
								<td>Tiistai</td>
								<td>10:00-23:00</td>

							</tr>
							<tr class="success">
								<td>Keskiviikko</td>
								<td>10:00-23:00</td>

							</tr>
							<tr class="active">
								<td>Torstai</td>
								<td>10:00-23:00</td>

							</tr>
							<tr class="active">
								<td>Perjantai</td>
								<td>10:00-23:00</td>

							</tr>
							<tr class="active">
								<td>Lauantai</td>
								<td>12:00-24:00</td>

							</tr>
							<tr class="active">
								<td>Sunnuntai</td>
								<td>14:00-23:00</td>

							</tr>
						</tbody>
					</table>
				</div>

				<section id=pizzalista>

				<table width="336" id=pizzalista border="1" align="center">

					<%
						for (int i = 0; i < pizzat.size(); i++) {
					%>
					<tr>
						<td><%=i + 1%></td>
						<td><%=pizzat.get(i).getNimi()%></td>
						<td><%=pizzat.get(i).getHinta()%>€</td>

						<td><form action="pizzat" method="POST">
								<input type=submit name="submit-button" class="submit-button"
									value="Ostoskoriin" />
							</form></td>
					</tr>

					<%
						}
					%>
				</table>

				</section>

			</div>
		</div>


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