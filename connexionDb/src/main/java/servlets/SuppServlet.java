
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

@WebServlet("/suppServlet")
public class SuppServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM utilisateur WHERE id = ?";


        try (Connection con = MaConnexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            
            ps.setInt(1, 9);
            int resultat = ps.executeUpdate();

			if(resultat > 0) {
				System.out.println("Utilisateur supprimé avec succès !");
				response.sendRedirect(request.getContextPath() + "/listeServlet");
			}else {
				
				response.getWriter().println("Utilisateur introuvable");
			}	

            ps.close();
            con.close();

        } catch (Exception e) {
           
            /*response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Erreur lors de la suppression.");*/
            throw new ServletException("Erreurs ServletTEst Exception"+ e); //==> C'est mieux
            //response.getWriter().println("Erreur lors de  modification :: " + e);
            
        }
    }
}