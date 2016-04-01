package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.dao.TayteDAO;

/**
 * Servlet implementation class Poistatayte
 */
@WebServlet("/Poistatayte")
public class Poistatayte extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tayte_id;
		String tayte_idstr;
		
		try {
			tayte_idstr = request.getParameter("tayte_id");
			System.out.println("Tayte_id jotakin... " + tayte_idstr);
			tayte_id = Integer.parseInt(request.getParameter("tayte_id"));
		} catch (NumberFormatException e){
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		
		TayteDAO dao = new TayteDAO();
		dao.poista(tayte_id);
		
		String page = "Muokkaussivu";
		response.sendRedirect(page);
	}

}
