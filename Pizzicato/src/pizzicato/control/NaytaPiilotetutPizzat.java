package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.dao.PizzaDAO;

/**
 * Servlet implementation class NaytaPiilotetutPizzat
 */
@WebServlet("/NaytaPiilotetutPizzat")
public class NaytaPiilotetutPizzat extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idIn = request.getParameter("id");
		int id = Integer.parseInt(idIn);
		PizzaDAO pizzadao = new PizzaDAO();
		pizzadao.poistaPiilotus(id);
		
		String page ="/Pizzicato/Muokkaussivu";
		response.sendRedirect(page);
	}
}