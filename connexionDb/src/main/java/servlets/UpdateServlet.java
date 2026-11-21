package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connexion.MaConnexion;


@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		String sql = "UPDATE utilisateur SET email= ?, tel= ? WHERE id= ?" ;
		
		try( Connection con = MaConnexion.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1, email);
			ps.setString(2, tel);
			ps.setInt(3, id);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/listeServlet");
			}else {
				
				response.getWriter().println("Utilisateur introuvable");
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
			//throw new ServletException("Erreur de modification", e);
			response.getWriter().println("Erreur lors de  modification" + e.getMessage());
			
		}
		
	}

}
