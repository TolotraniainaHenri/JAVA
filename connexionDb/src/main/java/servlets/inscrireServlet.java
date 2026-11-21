package servlets;
import connexion.MaConnexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class inscrireServlet
 */
@WebServlet("/inscrireServlet")
public class inscrireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscrireServlet() {
        super();}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");	
		String tel = request.getParameter("tel");
		
		String sql = "INSERT INTO utilisateur (email, tel) VALUES (?, ?)";
		
		try(Connection con = MaConnexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email); //1 => le 1er ? (Placehoder)
            ps.setString(2, tel);	//2 => le 2em ?
            
            int  resultat = ps.executeUpdate();
            
            if (resultat > 0) {
            	response.getWriter().println("Inscription reussie");
            }
		 } catch (Exception e) {
			
			e.printStackTrace();
			response.getWriter().println("Erreur lors de l'inscription: " + e.getMessage());
		}
            
      }
		
	}


