package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Tayte;

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
		
		String tayte = request.getParameter("tayte");
		String hinta = request.getParameter("tayte_hinta");
		
		double hintaa = Double.parseDouble(hinta);
		
		TayteDAO taytedao = new TayteDAO();
		
		Tayte tayte = new Tayte();
		tayte.setTayte(tayte);
		tayte.setTayte_hinta(hintaa);
		
		
	}

}
