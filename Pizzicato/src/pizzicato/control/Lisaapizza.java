package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Pizza;
import pizzicato.model.dao.PizzaDAO;

/**
 * Servlet implementation class Lisaapizza
 */
@WebServlet("/Lisaapizza")
public class Lisaapizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "/view/Muokkaussivu.jsp"; 
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);

		// Luodaan pizzatDAO ja k�sket��n hakemaan kaikki jutut
		PizzaDAO pizzaDAO = new PizzaDAO();
		ArrayList<Pizza> Pizza = pizzaDAO.findAll(); 

		// Talletetaan request-olion alle pizzalista, jotta tiedot ovat
		// k�yt�ss� jsp:ll�
		request.setAttribute("pizza", Pizza); 
		
		
	}
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// String pizza_id = request.getParameter("pizza_id");
		String nimi = request.getParameter("nimi");
		String hinta = request.getParameter("hinta");
		
		double hintaa = Double.parseDouble(hinta);
		// int pizza_idInt = Integer.parseInt(pizza_id);
		
		PizzaDAO pizzadao = new PizzaDAO();
		
		Pizza pizza = new Pizza();
		pizza.setHinta(hintaa);
		pizza.setNimi(nimi);
		// pizza.setPizza_id(pizza_idInt);

		
		try{
			pizzadao.addPizza(pizza);
			System.out.println("test");
		} catch(SQLException e){
			System.out.print(e.getMessage());
		}
		String page ="/Pizzicato/Muokkaussivu";
		response.sendRedirect(page);
	}

}
