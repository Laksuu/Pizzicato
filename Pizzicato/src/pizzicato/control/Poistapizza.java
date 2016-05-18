package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pizzicato.model.Pizza;
import pizzicato.model.dao.PizzaDAO;

@WebServlet("/Poistapizza")
public class Poistapizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int pizza_id;
		String pizza_idstr;

		try {
			pizza_idstr = request.getParameter("pizza_id");
			pizza_id = Integer.parseInt(request.getParameter("pizza_id"));
			PizzaDAO dao = new PizzaDAO();
			dao.poista(pizza_id);
			String page = "Muokkaussivu";
			response.sendRedirect(page);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		} catch (RuntimeException e) {
			String page = "Muokkaussivu?message=poistovirhe";
			response.sendRedirect(page);
		}

	}

}