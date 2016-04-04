package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.dao.TayteDAO;

/**
 * Servlet implementation class NaytaPiilotetutTaytteet
 */
@WebServlet("/NaytaPiilotetutTaytteet")
public class NaytaPiilotetutTaytteet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idIn = request.getParameter("tayte_id");
		int tid = Integer.parseInt(idIn);
		TayteDAO taytedao = new TayteDAO();
		taytedao.poistaPiilotustayte(tid);
		
		String page ="/Pizzicato/Muokkaussivu";
		response.sendRedirect(page);
	}

}
