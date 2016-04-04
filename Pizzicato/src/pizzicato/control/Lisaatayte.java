package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Tayte;
import pizzicato.model.dao.TayteDAO;

/**
 * Servlet implementation class Lisaatayte
 */
@WebServlet("/Lisaatayte")
public class Lisaatayte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
/**	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taytenimi = request.getParameter("tayte");
		String taytehinta = request.getParameter("tayte_hinta");
		
		double hintaa = Double.parseDouble(taytehinta);
		
		TayteDAO taytedao = new TayteDAO();
		
		Tayte tayte = new Tayte();
		tayte.setTayte(taytenimi);
		tayte.setTayte_hinta(hintaa);
		
		try{
			taytedao.addTayte(tayte);
			System.out.println("test");
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		String page ="/Pizzicato/Muokkaussivu";
		response.sendRedirect(page);
	}

}
