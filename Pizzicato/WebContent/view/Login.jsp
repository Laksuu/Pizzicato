<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <title>Kirjaudu</title>
   <link rel="stylesheet" type="text/css" href="tyylit.css"/>
</head>
<body>
<h1>Kirjaudu</h1>
<% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<p>" + message + "</p>");
   }
%>

<form method="post" action="">
   <div>
      Kayttajanimi:	<input type="text" name="username" size="36" />

   </div>
   <div>
      Salasana:		<input type="password" name="password" size="36" />

   </div>
   <div>
      <input type="submit" value="Login" />
   </div>

</form>
</html>