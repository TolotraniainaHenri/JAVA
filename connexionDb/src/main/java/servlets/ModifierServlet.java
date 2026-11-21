package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import models.Utilisateur;
import connexion.MaConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/modifierServlet")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "SELECT * FROM utilisateur WHERE 	id= ?";
		
		try(Connection cn = MaConnexion.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);){
	    ps.setInt(1, id);
	    
	    		try(ResultSet rs = ps.executeQuery()){
	    			if(rs.next()){
	    				
	    				Utilisateur u = new Utilisateur( rs.getInt("id"),rs.getString("email"),rs.getString("tel"));
	    				
	    				request.setAttribute("CleUtilisateur", u);
	    				request.getRequestDispatcher("/modifier.jsp").forward(request, response);
	   
	    			}else {
	    				response.sendError(404,"utilisateur introuvable");
	    			}
	    			
	    		}
			
		}catch(Exception e) {
			throw new ServletException("Erreur de recherche ", e);
		}	
	}

}
