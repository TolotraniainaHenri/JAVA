# 1. Connexion à une base de données avec JSP et JDBC

```
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Test de connexion à la base de données</title>
</head>
<body>
    <h2>Liste des utilisateurs :</h2>
    <ul>
    <%
        // Paramètres de connexion (exemple avec MySQL)
        String url = "jdbc:mysql://localhost:3306/ma_base_de_donnees";
        String user = "root";
        String password = ""; // Ton mot de passe

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Établir la connexion
            conn = DriverManager.getConnection(url, user, password);

            // 3. Exécuter la requête SQL
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT nom, email FROM utilisateurs");

            // 4. Afficher les résultats dans le HTML
            while (rs.next()) {
    %>
                <li><%= rs.getString("nom") %> - <%= rs.getString("email") %></li>
    <%
            }
        } catch (Exception e) {
            out.println("<p style='color:red;'>Erreur : " + e.getMessage() + "</p>");
        } finally {
            // 5. Toujours fermer les connexions pour éviter de saturer le serveur
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    %>
    </ul>
</body>
</html>
```

# 2. Structure d'un projet Java Web

## 2.1. Séparer l'architecture de l'application (MVC)

Dans un projet Web utilisant des Servlets, on utilise des packages pour organiser les fichiers selon leur rôle précis (souvent selon le modèle MVC).

- `com.monprojet.servlets` (ou `.controllers`) : contient les Servlets qui reçoivent les requêtes HTTP (GET, POST).
    
- `com.monprojet.models` (ou `.beans`) : contient les objets Java (ex. : `Utilisateur.java`, `Produit.java`).
    
- `com.monprojet.dao` : contient les classes qui communiquent avec la base de données (SQL).
    
- `com.monprojet.filters` : contient les filtres de sécurité (ex. : vérifier si l'utilisateur est connecté).
    

## 2.2. Éviter les conflits de noms

Si tu crées une classe nommée `User` et qu'une bibliothèque externe possède également une classe `User`, le package permet de les différencier grâce à leur nom complet :

- `com.monprojet.models.User`
    
- `org.autrelibrairie.User`
    

## 2.3. Gérer la visibilité et la sécurité (encapsulation)

En Java, si tu ne mets aucun mot-clé (`public`, `private`, `protected`) devant une méthode ou une variable dans une Servlet ou une classe utilitaire, elle n'est accessible que par les autres classes situées dans le même package.

Cela permet de protéger certaines parties de ton code.

## 2.4. Faciliter la configuration du serveur (Tomcat, GlassFish, etc.)

Le serveur d'applications a besoin du nom exact du package pour trouver et exécuter ta Servlet.

- **Avec les annotations (méthode moderne) :** tu déclares le package tout en haut de ton fichier (`package com.monprojet.servlets;`), et le serveur associe automatiquement l'URL (`@WebServlet("/connexion")`) à cette classe précise.
    
- **Avec le fichier** `**web.xml**` **(ancienne méthode) :** tu dois indiquer le chemin complet incluant le package dans la balise correspondante.
    

# 3. Cookies, sessions, URI et URL

Ces quatre notions se divisent en deux catégories bien distinctes dans le développement Web (Java Servlets / JSP) :

1. **URI et URL :** servent à localiser une ressource ou une page.
    
2. **Cookie et session :** servent à sauvegarder des informations sur l'utilisateur entre plusieurs pages.
    

Voici la différence précise entre chacune de ces notions.

## 3.1. URI vs URL (les adresses)

### URL (Uniform Resource Locator)

- **Définition :** c'est l'adresse Web complète qui permet d'accéder à une page sur Internet. Elle inclut le protocole `http://` et le nom de domaine.
    
- **Exemple :** `http://localhost:8080/MonProjet/connexion`
    
- **En Java Servlet :** `request.getRequestURL()` renvoie cette adresse complète.
    

### URI (Uniform Resource Identifier)

- **Définition :** c'est un identifiant de ressource. Dans cet exemple, il correspond au chemin de la ressource après le nom de domaine et le port. Toute URL est une URI.
    
- **Exemple :** `/MonProjet/connexion`
    
- **En Java Servlet :** `request.getRequestURI()` renvoie le chemin de la requête. Cette méthode est très utilisée dans les filtres pour savoir quelle page l'utilisateur essaie d'ouvrir.
    

## 3.2. Cookie vs session (la mémoire)

### Cookie

- **Définition :** un petit fichier texte enregistré directement dans le navigateur de l'utilisateur.
    
- **Durée de vie :** il peut durer plusieurs jours, mois ou années, même si l'utilisateur ferme son navigateur ou éteint son ordinateur.
    
- **Sécurité :** elle est limitée, car l'utilisateur peut consulter et modifier ses cookies dans son navigateur. Il ne faut jamais y stocker directement un mot de passe.
    
- **Exemple en Servlet :** mémoriser la langue du site (`langue=fr`) ou l'option « Se souvenir de moi ».
    

```
Cookie c = new Cookie("theme", "sombre");
response.addCookie(c);
```

### Session (`HttpSession`)

- **Définition :** un espace mémoire stocké sur le serveur (Tomcat) pour un visiteur précis. Le serveur attribue un identifiant (`JSESSIONID`) au navigateur afin de reconnaître la session.
    
- **Durée de vie :** elle est temporaire. Elle peut expirer automatiquement après une période d'inactivité (souvent 30 minutes, selon la configuration) ou lorsque la session est invalidée.
    
- **Sécurité :** les données de session sont stockées sur le serveur. Le visiteur ne peut donc pas les modifier directement depuis son navigateur.
    
- **Exemple en Servlet :** garder l'utilisateur connecté ou sauvegarder son panier d'achat.
    

```
HttpSession session = request.getSession();
session.setAttribute("utilisateurConnecte", "Jean");
```

# 4. DAO (Data Access Object)

Un **DAO (Data Access Object)** est une classe Java dont le rôle est de communiquer avec la base de données.

Il permet d'exécuter des requêtes SQL (`SELECT`, `INSERT`, `UPDATE`, `DELETE`) et de transformer les résultats obtenus en objets Java.

## Résumé du flux

**Base de données** ↔ **DAO** (SQL) ↔ **Servlet** (contrôleur) ↔ **JSP** (affichage HTML)