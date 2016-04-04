
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
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
		<div class="header">

			<img src="Pizzicato.png" class="kuva1" />

			<!--Navigointipalkin linkkien painikkeet ovat tässä-->
			<div id="navigointipalkki">
				<ul class="paavalikko">
					<li><a class="active" href="Etusivu">Etusivu</a></li>
					<li><a href="Muokkaussivu">Muokkaussivu</a></li>
					<li><a href="Ostoskori">Ostoskori</a></li>
					<li><a href="Yhteystiedot">Yhteystiedot</a></li>
				</ul>
			</div>

		</div>




<div id="kuvajono">
			<img src="kuva3.jpg" class="kuva3" /> <img src="pizza.jpg"
				class="kuva4" /> <img src="tausta.jpg" class="kuva5" />
		</div>
		<br>
		<hr>

		<div id="aukioloajat">
<div class="teksti">
			
			
				<div class="puhnum">
			 <h4><b>Helsinki<br>
						P. 0500555555</b></h4>
			
			</div>
			
			
			<h4><b><font size="5">Avoinna</font><br>
			&nbsp;&nbsp;Ma-pe: 10.00 - 23.00<br>
			&nbsp;&nbsp;La: 11.00 - 23.00<br>
			&nbsp;&nbsp;Su: 11.00 - 23.00</b></h4>
			
		
			







			<h1>Tervetuloa herkuttelemaan!</h1>
			<h4>Helsingin keskustassa jo vuodesta 1999 toiminut Pizzeria
				Pizzicato kuuluu paikkakunnan suosituimpiin ruokapaikkoihin. Vuosien
				varrella pizzojen lisäksi rento tunnelma ja loistava asiakaspalvelu.
<br><br>
				Meillä voit nauttia ruokailusta savuttomasti viihtyisässä
				ympäristössä. TERVETULOA!</h4>
</div>

		</div>
		
		 <br> 
		
		<hr>
		
		 <br> <br>
		
<div class="otsikko">
<h1> Pizzalista</h1>
</div>
		



			

			<table class="taulukko">


				<tr>
					<th>Pizzan numero</th>
					<th>Pizza</th>
					<th>Hinta</th>
					<th></th>
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

		



		<br> <br> <br> <br> <br> <br> <br>

	</div>

	<div id="footer">
		<p>Pizzeria Pizzicato| Pizzantie 10 | 01320 Vantaa |
			pizzeriapizzicato@pizzicato.fi</p>
	</div>

</body>
</html>