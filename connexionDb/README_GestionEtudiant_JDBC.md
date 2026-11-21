# GestionEtudiant

JDBC signifie Java Database Connectivity.
C'est une API Java qui permet à une application Java de communiquer avec une base de données comme MySQL.

Application web Java permettant de gérer des utilisateurs avec **JSP,
Servlets, JDBC, MySQL et Apache Tomcat**. Le projet met en pratique les
quatre opérations CRUD : créer, lire, modifier et supprimer.

## 1. Fonctionnalités CRUD

  -----------------------------------------------------------------------
  Opération               Description             Servlet
  ----------------------- ----------------------- -----------------------
  **Create**              Ajouter un utilisateur  `InscrireServlet`

  **Read**                Afficher la liste des   `ListeServlet`
                          utilisateurs            

  **Update**              Récupérer puis modifier `ModifierServlet` et
                          un utilisateur          `UpdateServlet`

  **Delete**              Supprimer un            `SuppServlet`
                          utilisateur             
  -----------------------------------------------------------------------

## 2. Structure du projet

Voici l'organisation utilisée dans le projet Eclipse :

``` text
GestionEtudiant/
├── Java Resources/
│   └── src/main/java/
│       ├── connexion/
│       │   └── MaConnexion.java
│       ├── models/
│       │   └── Utilisateur.java
│       └── servlets/
│           ├── InscrireServlet.java
│           ├── ListeServlet.java
│           ├── ModifierServlet.java
│           ├── UpdateServlet.java
│           └── SuppServlet.java
└── WebContent/
    ├── index.jsp
    ├── inscrire.jsp
    ├── liste.jsp
    ├── modifier.jsp
    └── WEB-INF/
        └── lib/
            └── mysql-connector-j.jar
```

-   `connexion` : contient la classe qui établit la connexion à MySQL.
-   `models` : contient les classes représentant les données, par
    exemple `Utilisateur`.
-   `servlets` : contient les contrôleurs qui reçoivent les requêtes
    HTTP et exécutent les traitements.
-   `WebContent` : contient les pages JSP.
-   `WEB-INF/lib` : contient le pilote JDBC MySQL utilisé par
    l'application.

> **Remarque :** la structure exacte des dossiers peut varier selon la
> version d'Eclipse et le type de projet Web dynamique.

## 3. Base de données

La base utilisée dans les exemples s'appelle `inscription_db` et
contient une table `utilisateurs`.

``` sql
CREATE DATABASE inscription_db;

USE inscription_db;

CREATE TABLE utilisateurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100),
    tel VARCHAR(20)
);
```

Adapte les identifiants de connexion et le nom de la base à ta
configuration MySQL.

## 4. Connexion Java à MySQL avec JDBC

### 4.1. Importer les classes JDBC

``` java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
```

### 4.2. Charger le pilote MySQL

``` java
Class.forName("com.mysql.cj.jdbc.Driver");
```

Cette instruction charge le pilote JDBC de MySQL. Avec les versions
modernes de JDBC et un pilote correctement installé, le chargement
explicite peut être facultatif.

### 4.3. Ouvrir une connexion

``` java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/inscription_db",
    "root",
    ""
);
```

  Élément             Rôle
  ------------------- ----------------------------------------------
  `Connection`        Représente la connexion à la base de données
  `DriverManager`     Gère l'ouverture de la connexion
  `getConnection()`   Ouvre la connexion
  `localhost`         Adresse du serveur MySQL local
  `3306`              Port MySQL par défaut
  `inscription_db`    Nom de la base de données

### 4.4. Préparer une requête SQL

``` java
String sql = "SELECT * FROM utilisateurs WHERE id = ?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setInt(1, id);
```

-   `PreparedStatement` représente une requête SQL préparée.
-   `prepareStatement(sql)` prépare la requête.
-   `?` représente un paramètre à renseigner.
-   `setInt(1, id)` remplace le **premier** `?` par la valeur de `id`.
-   `setString(1, email)` permet de remplacer un paramètre par une
    chaîne de caractères.

**Important :** les positions des paramètres commencent à `1`, et non à
`0`.

## 5. Les méthodes d'exécution JDBC

### 5.1. `executeQuery()` --- pour `SELECT`

Cette méthode exécute une requête de lecture et retourne un objet
`ResultSet`.

``` java
String sql = "SELECT * FROM utilisateurs";
PreparedStatement ps = con.prepareStatement(sql);

ResultSet rs = ps.executeQuery();

while (rs.next()) {
    int id = rs.getInt("id");
    String email = rs.getString("email");
    String tel = rs.getString("tel");
}
```

À retenir :

-   `executeQuery()` retourne un `ResultSet`.
-   `rs.next()` passe à la ligne suivante et retourne `true` s'il existe
    une ligne, sinon `false`.
-   `rs.getInt("id")` lit la valeur entière de la colonne `id`.
-   `rs.getString("email")` lit le texte de la colonne `email`.

### 5.2. `executeUpdate()` --- pour `INSERT`, `UPDATE` et `DELETE`

Cette méthode exécute une requête qui modifie les données. Elle retourne
un entier indiquant le nombre de lignes affectées.

**INSERT --- ajouter un utilisateur**

``` java
String sql = "INSERT INTO utilisateurs(email, tel) VALUES (?, ?)";
PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, email);
ps.setString(2, tel);

int resultat = ps.executeUpdate();
```

**UPDATE --- modifier un utilisateur**

``` java
String sql = "UPDATE utilisateurs SET email = ?, tel = ? WHERE id = ?";
PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, email);
ps.setString(2, tel);
ps.setInt(3, id);

int resultat = ps.executeUpdate();
```

**DELETE --- supprimer un utilisateur**

``` java
String sql = "DELETE FROM utilisateurs WHERE id = ?";
PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1, id);

int resultat = ps.executeUpdate();
```

  -----------------------------------------------------------------------
  Méthode                 Utilisation             Valeur retournée
  ----------------------- ----------------------- -----------------------
  `executeQuery()`        `SELECT`                `ResultSet`

  `executeUpdate()`       `INSERT`, `UPDATE`,     `int` : nombre de
                          `DELETE`                lignes affectées
  -----------------------------------------------------------------------

## 6. Fermer les ressources JDBC

Il faut fermer les ressources après leur utilisation. La méthode
recommandée est le `try-with-resources`, qui les ferme automatiquement :

``` java
String sql = "SELECT id, email, tel FROM utilisateurs";

try (
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/inscription_db", "root", ""
    );
    PreparedStatement ps = con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery()
) {
    while (rs.next()) {
        System.out.println(rs.getString("email"));
    }
} catch (SQLException e) {
    e.printStackTrace();
}
```

Les ressources concernées sont notamment `ResultSet`,
`PreparedStatement` et `Connection`.

## 7. `request` et `response` dans une Servlet

-   `request` représente la requête envoyée par le navigateur au
    serveur. On l'utilise notamment pour récupérer les paramètres d'un
    formulaire ou d'une URL.
-   `response` représente la réponse envoyée par le serveur au
    navigateur. On l'utilise notamment pour rediriger l'utilisateur ou
    envoyer une réponse HTTP.

Exemple : récupérer un identifiant puis retourner à la liste :

``` java
// REQUEST : récupérer l'ID envoyé dans l'URL
int id = Integer.parseInt(request.getParameter("id"));

// RESPONSE : rediriger vers la servlet de liste
response.sendRedirect(request.getContextPath() + "/listeServlet");
```

`request.getContextPath()` ajoute le chemin de l'application, par
exemple `/GestionEtudiant`.

## 8. Gérer les exceptions

Dans une Servlet, on peut transmettre une exception à la Servlet API
avec `ServletException` :

``` java
try {
    // Traitement
} catch (Exception e) {
    throw new ServletException("Une erreur est survenue pendant le traitement.", e);
}
```

La syntaxe correcte est `throw new ServletException(...)`, et non
`new throw`.

## 9. Quelques codes d'erreur HTTP

  -----------------------------------------------------------------------
  Code                    Signification           Points à vérifier
  ----------------------- ----------------------- -----------------------
  **400**                 Bad Request --- requête Paramètres envoyés et
                          incorrecte              format des données

  **401**                 Unauthorized ---        Authentification
                          authentification        
                          requise                 

  **403**                 Forbidden --- accès     Autorisations
                          interdit                

  **404**                 Not Found --- ressource `@WebServlet`, URL,
                          introuvable             `form action`,
                                                  déploiement

  **405**                 Method Not Allowed ---  `doGet()` ou `doPost()`
                          méthode HTTP non        
                          autorisée               

  **500**                 Internal Server Error   Code Java, SQL,
                          --- erreur interne      connexion et journaux
                                                  Tomcat

  **503**                 Service Unavailable --- État du serveur
                          service indisponible    
  -----------------------------------------------------------------------

**À retenir :** une erreur 404 indique généralement que la ressource
demandée n'a pas été trouvée. Une erreur 500 indique qu'une erreur
interne s'est produite pendant le traitement côté serveur.

## 10. Les modificateurs `public`, `static` et `final`

### `public`

Un membre déclaré `public` est accessible depuis les autres classes,
sous réserve des règles d'accès applicables.

``` java
public String nomUtilisateur = "Jean";
```

### `static`

Un membre `static` appartient à la classe plutôt qu'à une instance
particulière. On peut y accéder avec le nom de la classe.

``` java
public static int nombreVisiteurs = 0;

// Utilisation
Compteur.nombreVisiteurs++;
```

### `final`

Une variable `final` ne peut être affectée qu'une seule fois.
Lorsqu'elle est déclarée `static final`, elle sert souvent à définir une
constante de classe.

``` java
public static final String NOM_SITE = "MonApplicationWeb";

// Utilisation
String titre = Config.NOM_SITE;
```

Une nouvelle affectation à `NOM_SITE` provoquerait une erreur de
compilation.

## 11. Les packages en Java

Un `package` permet d'organiser les classes dans des espaces de noms
logiques et d'éviter les conflits entre des classes portant le même nom.

Exemples :

``` java
package models;
```

``` java
package servlets;
```

Le nom complet d'une classe inclut son package, par exemple
`models.Utilisateur`.

## 12. Commentaire dans une page JSP

Pour écrire un commentaire JSP qui ne sera pas envoyé au navigateur :

``` jsp
<%-- Ton commentaire ici --%>
```

## 13. Résumé à mémoriser

``` text
JDBC
  |
  v
Driver MySQL
  |
  v
DriverManager.getConnection()
  |
  v
Connection
  |
  v
PreparedStatement
  |
  +---------------------------+
  |                           |
  v                           v
executeQuery()             executeUpdate()
  |                           |
  v                           v
ResultSet                 INSERT / UPDATE / DELETE
  |
  v
rs.next()
  |
  v
getInt() / getString()
```

**Phrase à retenir :**

-   `executeQuery()` → lire les données (`SELECT`).
-   `executeUpdate()` → modifier les données (`INSERT`, `UPDATE`,
    `DELETE`).
-   `request` → recevoir les informations.
-   `response` → envoyer une réponse.
