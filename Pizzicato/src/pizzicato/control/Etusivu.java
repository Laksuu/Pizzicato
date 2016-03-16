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
import pizzicato.model.dao.PizzaDAO;

/**
 * Servlet implementation class Etusivu
 */
@WebServlet("/Etusivu")
public class Etusivu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /** testi testi**/
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// Luodaan pizzatDAO ja k�sket��n hakemaan kaikki jutut
		PizzaDAO pizzatDAO = new PizzaDAO();
		ArrayList<Pizza> Pizzat = pizzatDAO.findAll(); 

		// Talletetaan request-olion alle henkil�lista, jotta tiedot ovat
		// k�yt�ss� jsp:ll�
		request.setAttribute("pizzat", Pizzat); 
		

		// l�het� selaimelta tullut pyynt� servletilt� edelleen jsp:lle
		String jsp = "/view/Etusivu.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

