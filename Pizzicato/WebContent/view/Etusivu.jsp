
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ page import="pizzicato.model.Pizza"%>
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
	<div id="header">

		<img src="Pizzicato.png" class="kuva1" />

		<!--Navigointipalkin linkkien painikkeet ovat tässä-->
		<div id="navigointipalkki">
			<ul class="paavalikko">
				<li><a class="active" href="etusivu">Etusivu</a></li>
				<li><a href="Muokkaussivu">Muokkaussivu</a></li>
				<li><a href="Ostoskori">Ostoskori</a></li>
				<li><a href="PizzicatoControl">Yhteystiedot</a></li>
			</ul>
		</div>

	</div>

<div id="aukioloajat">



<h2>Avoinna</h2>
<p>Ma-pe: 10.00 - 23.00</p>
<p>La: 11.00 - 23.00</p>
<p>Su: 11.00 - 23.00</p>







		<h2>Tervetuloa herkuttelemaan!</h2>
		<br>
		<h4>Helsingin keskustassa jo vuodesta 1999 toiminut Pizzeria
			Pizzicato kuuluu paikkakunnan suosituimpiin ruokapaikkoihin. Vuosien
			varrella pizzojen lisäksi rento tunnelma ja loistava asiakaspalvelu.

			Meillä voit nauttia ruokailusta savuttomasti viihtyisässä
			ympäristössä. TERVETULOA!</h4>

</div>

<br>
<br>
<br>		
<br>
<br>
<br>
<br>
<br>
		<div class="table-responsive">



			<section id=pizzalista>

			<table class="taulukko">
				
				
					<tr>
						<th>Pizzan numero</th>
						<th>Pizza</th>
						<th>Hinta</th>
						<th> </th>
					</tr>
			
				<tkeho> <%
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
				</tkeho>
				<%
					}
				%>
			</table>

			</section>

		</div>
	
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

	<div id="footer">
		<p>
			Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa | pizzeriapizzicato@pizzicato.fi
		</p>
	</div>

</body>
</html>