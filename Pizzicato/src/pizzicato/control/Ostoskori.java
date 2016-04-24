package pizzicato.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Pizza;
import pizzicato.model.dao.PizzaDAO;

/**
 * Servlet implementation class Ostoskori
 */
@WebServlet("/Ostoskori")
public class Ostoskori extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		
		String jsp = "/view/Ostoskori.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession(false);
		List <Pizza> pizzat = null;
		try {
			pizzat = (List<Pizza>) session.getAttribute("pizzat");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
		
		if (pizzat == null){
			pizzat = new ArrayList<Pizza>();
		}
		
		
		
		
		
		
		/*  HttpSession session = request.getSession(); Ostoskoriluokka kori =
		  (Ostoskoriluokka) session.getAttribute("kori");
		  
		  
		  if (request.getParameter("pizza_id").equals("add")) { if (kori ==
		  null) { kori = new Ostoskoriluokka(); }
		*/
		String strid = request.getParameter("pizza_id");
		String strlkm = request.getParameter("lkm");

		// muunna string-tiedot luvuiksi
		int pizza_id = new Integer(strid);
		int lkm = new Integer(strlkm);

		/*System.out.print("Pizzan id:" + pizza_id);
		System.out.print("Pizzan id:" + strid);
		System.out.print("Pizzan lukum‰‰r‰:" + strlkm);*/

		String valittuOregano = request.getParameter("oregano");

		boolean oregano = false;

		if (valittuOregano != null) {
			oregano = true;
		}

		PizzaDAO pizzadao = new PizzaDAO();

		Pizza uusiPizza = pizzadao.etsiPizza(pizza_id);
		System.out.print("PIZZA:" + uusiPizza);
		
		
		pizzat.add(uusiPizza);
		/* luo ostoskorin, jos ostoskori on koko on nolla*/
		if (pizzat.size() == 0) {
			session = request.getSession(true);
			
		}
		
		
		
		session.setAttribute("pizzat",pizzat);
		
		System.out.print("pizzat::::"+pizzat);
		
		response.sendRedirect("/Pizzicato/Ostoskori");
		/*
		double rivihinta = lkm * uusiPizza.getHinta();

		Pizza uusipizza = uusiPizza;
		
		Ostos ostos = new Ostos(uusipizza,lkm, rivihinta, oregano);
		kori.lisaaOstoskoriin(ostos);	
		
		//Hinnat sessioon
		double hinta = kori.getTilauksenHinta();
		request.getSession().setAttribute("hinta", hinta);
		request.getSession().setAttribute("ohinta", hinta*0.9);
	
		
		  request.getSession().setAttribute("kori", kori);
				response.sendRedirect("/Pizzicato/Etusivu"); 
				System.out.print("Ostoskori"+ kori);
	}
		  String jsp = "/view/Ostoskori.jsp";
			RequestDispatcher dispather = getServletContext().getRequestDispatcher(
					jsp);
			dispather.forward(request, response);
	*/
	}
}