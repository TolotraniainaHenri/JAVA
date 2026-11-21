<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Formulaire d'inscription</h2>

<form action="inscrireServlet" method="post">

    <label>Email :</label>
    <input type="email" name="email" required>

    <br><br>

    <label>Téléphone :</label>
    <input type="text" name="tel" required>

    <br><br>

    <button type="submit">S'inscrire</button>

</form>
<a href="listeServlet"> Voir</a>
</body> </html>
</body>
</html>