<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="pizzicato.model.Tilausrivi"%>
    <link href="tyyli.css" rel="stylesheet" type="text/css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="keho">
<table class="taulukko">


			<tr>
				<th>Tilausrivi_id</th>
				<th>Pizza_id</th>
				<th>tilaus_id</th>
				<th>määrä</th>
				<th>extramausteet</th>
				<th>rivihinta</th>
			</tr>

			
			<tr>
				<td>tilaus.get</td>
				<td><%=pizza.getNimi()%> <br>
					<div class="pienempifontti">

			</tr>

		
		</table>







</div>
</body>
</html>