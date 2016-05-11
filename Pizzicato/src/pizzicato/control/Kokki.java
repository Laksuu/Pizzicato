package pizzicato.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.Tilausrivi;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TayteDAO;
import pizzicato.model.dao.TilausDAO;

/**
 * Servlet implementation class Kokki
 */
@WebServlet("/Kokki")
public class Kokki extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		TilausDAO tilausDAO = new TilausDAO();
		ArrayList<Tilausrivi> Tilausrivit = tilausDAO.haetilausrivit();

		// Talletetaan request-olion alle tilauslista, jotta tiedot ovat
				// käytössä jsp:llä
				request.setAttribute("tilausrivit", Tilausrivit);
		
		// lähetä selaimelta tullut pyyntö servletiltä edelleen jsp:lle
		String jsp = "/view/Kokki.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
