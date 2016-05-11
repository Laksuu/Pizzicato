<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="pizzicato.model.Tilausrivi"%>
    
    <link href="tyyli.css" rel="stylesheet" type="text/css">
 
    <jsp:useBean id="tilausrivit" type="java.util.ArrayList<Tilausrivi>"
	scope="request" />
	<%@ page import="java.util.Collection,
				java.util.ArrayList"%>
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
			<th>Pizzan nimi</th>
			<th>määrä</th>
			<th>extramausteet</th>
			<th>Aika</th>
			</tr>


			<tr>
			
				<%for(int i = 0; i < tilausrivit.size(); i++) {%>
				<td><%=tilausrivit.get(i).getPizza().getNimi()%></td>
				<td><%=tilausrivit.get(i).getMaara()%></td>
				<td><%=tilausrivit.get(i).getExtramauste()%></td>
				<td><%=tilausrivit.get(i).getTilaus().getPvm()%></td>
			


			</tr>
			
			
			
						<% } %>



		</table>


</div>
</body>
</html>