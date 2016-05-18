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
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TayteDAO;

@WebServlet("/MuokkaaPizza")
public class MuokkaaPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int pizza_id;
		String pizza_idstr;
		String nimi;
		double hinta;
		String hintastr;

		pizza_idstr = request.getParameter("pizza_id");
		pizza_id = Integer.parseInt(request.getParameter("pizza_id"));
		nimi = request.getParameter("nimi");
		hintastr = request.getParameter("hinta");
		hinta = Double.parseDouble(request.getParameter("hinta"));

		PizzaDAO pizzaDAO = new PizzaDAO();
		Pizza pizza = pizzaDAO.etsiPizza(pizza_id);
		TayteDAO tayteDAO = new TayteDAO();
		ArrayList<Tayte> taytteet = tayteDAO.findAll();

		request.setAttribute("pizza", pizza);
		request.setAttribute("taytteet", taytteet);

		String jsp = "/view/MuokkaaPizza.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// luodaan doPostissa k‰ytett‰v‰t muuttujat ja alustetaan osa niist‰
		int pizza_id;
		String pizza_idstr = null;
		double hinta;
		String hintastr;
		String[] taytteet;
		int tayte_id;
		String taytestr = null;

		// luodaan pizzaolio
		Pizza pizza = new Pizza();

		try {
			// haetaan pizzaoliolle arvoja
			// jsp:lt‰ tieto tulee string muotoisena
			hintastr = request.getParameter("hinta");
			// muunnetaan jsp:n ymm‰rt‰m‰ string kannan ja javan ymm‰rt‰m‰‰n
			// double-tietoon
			hinta = Double.parseDouble(request.getParameter("hinta"));
			// asetetaan pizzalle hinta
			pizza.setHinta(hinta);
			// haetaan pizzaoliolle kaikki saatavilla olevat t‰ytteet
			taytteet = request.getParameterValues("taytteet");

			// for toisto
			for (int i = 0; i < taytteet.length; i++) {

				// taulukosta 1 t‰yte id -> int
				taytestr = taytteet[i];
				tayte_id = Integer.parseInt(taytestr);

				// luo t‰yteolio
				Tayte tayteolio = new Tayte();
				// lis‰‰ t‰yteoliolle t‰yte_id
				tayteolio.setTayte_id(tayte_id);
				// lis‰‰ t‰yteolio pizzalle
				pizza.addTayte(tayteolio);

			}
			// haetaan pizzan id, joka tulee stringin‰ jsp:lt‰
			pizza_idstr = request.getParameter("pizza_id");
			// muunnetaan string javan ja kannan ymm‰rt‰m‰‰n int muotoon
			pizza_id = Integer.parseInt(request.getParameter("pizza_id"));
			// asetetaan id pizzaoliolle
			pizza.setPizza_id(pizza_id);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		// haetaan pizzalle nimi
		String nimi = request.getParameter("nimi");
		// ja asetetaan se pizzaoliolle
		pizza.setNimi(nimi);

		// komennetaan DAO tˆihin ja l‰hetet‰‰n yll‰ esitetyt tiedot eteenp‰in
		PizzaDAO dao = new PizzaDAO();
		dao.muokkaa(pizza);

		// siirryt‰‰n tarkastelemaan muokkaussivua kun pizza on muokattu
		String page = "Muokkaussivu";
		response.sendRedirect(page);
	}
}
