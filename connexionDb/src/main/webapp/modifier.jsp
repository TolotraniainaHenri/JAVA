<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Utilisateur"  %>  
<%  Utilisateur u = (Utilisateur) request.getAttribute("CleUtilisateur"); %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/updateServlet"
      method="post">
    <label>id:</label><br>
  	<input type="hidden" name="id" value= "<%= u.getId() %>">
  	<label >Email: </label><br>
  	<input type="text" name="email" value="<%= u.getEmail() %>" required><br>
  	<label >Tel: </label><br>
  	<input type="text" name="tel" value="<%= u.getTel() %>" required>
  	<button type="submit" >Engistrer et modifier</button>  
</form>
</body>
</html>