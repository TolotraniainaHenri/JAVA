<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.List" %>
<%-- @page import = "models.Utilisateur --%>
<%@ page import = "models.Utilisateur" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Utilisateurs</title>
</head>
<body>
<table border="1" cellpadding="10">
	<thead>
		<tr>
		    <th>ID</th>
		    <th>Email</th>
		    <th>Telephone</th>
		    <th> Action </th>
		</tr>
	</thead>
	<tbody>
	    <% List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("CLEutilisateurs");
	     if (utilisateurs != null){ 
	    	 for (Utilisateur u : utilisateurs){
	    %>	
	     <tr>
	         <td><%= u.getId() %></td>
	         <td><%= u.getEmail() %> </td>
	         <td><%= u.getTel() %> </td>
	         <td><a href="modifierServlet?id=<%= u.getId()%> ">Modifier</a>
	             <a href="suppServlet?id=<%= u.getId() %>" onclick="return confirm('Voulez vous vraiment supprimer?')" > 
	             Supprimer
	             </a>
	         </td>
	     </tr>
	     
	      <%   } 
	    	 }else {
	    	 out.println("<p>Utilisateurs null</p>");
	     }%>
    </tbody>   
</table>

<a href="index.jsp">S'inscrire</a>
</body>
</html>