package servlets;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import models.Utilisateur;
import connexion.MaConnexion;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

 
@WebServlet("/listeServlet")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ListeServlet() {
        super();// Servlet implementation class ListeServlet

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		String sql = "SELECT*FROM utilisateur";
		
		try(Connection con = MaConnexion.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()
			){
			
			// .next() return 1 si la ligne existe o si non 
			
			while(rs.next()){
				Utilisateur u = new Utilisateur(rs.getInt("id"), rs.getString("email"), rs.getString("tel"));
				utilisateurs.add(u);
			}
			
			request.setAttribute("CLEutilisateurs", utilisateurs); //Cette méthode stocke l'objet Java utilisateurs dans la portée de la requête sous la clé "utilisateurs"
			request.getRequestDispatcher("/list.jsp").forward(request, response); //Cette instruction utilise un RequestDispatcher pour transférer la requête et la réponse actives vers la page JSP nommée /liste.jsp.
				
			
		}catch(Exception e) {
			throw new ServletException("Erreur lors de la lecture des utilisateurs", e);
			
		}
			
	}

}
