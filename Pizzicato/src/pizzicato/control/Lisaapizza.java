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
import pizzicato.model.Tayte;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TayteDAO;

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

		// Luodaan pizzatDAO ja käsketään hakemaan kaikki jutut
		PizzaDAO pizzaDAO = new PizzaDAO();
		ArrayList<Pizza> Pizza = pizzaDAO.findAll(); 

		// Talletetaan request-olion alle pizzalista, jotta tiedot ovat
		// käytössä jsp:llä
		request.setAttribute("pizza", Pizza); 
		
		
	}
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// String pizza_id = request.getParameter("pizza_id");
		String nimi = request.getParameter("nimi");
		String hinta = request.getParameter("hinta");
		String[] taytteet = request.getParameterValues("taytteet");
		
		double hintaa = Double.parseDouble(hinta);
		// int pizza_idInt = Integer.parseInt(pizza_id);
		
		PizzaDAO pizzadao = new PizzaDAO();
		
		Pizza pizza = new Pizza();
		pizza.setHinta(hintaa);
		pizza.setNimi(nimi);
		System.out.println(pizza);
		
		//String taytenimi = request.getParameter("tayte");
		for (int i = 0; i < taytteet.length; i++) {
			 			Tayte tayte = new Tayte(
			 					);
			 			String idstr = taytteet[i];
						int tid = new Integer(idstr);
			 			tayte.setTayte_id(tid);
			 			pizza.addTayte(tayte);
			 		}
	
		
		//Tayte tayte = new Tayte();
		//tayte.setTayte(taytenimi);
		
		try{
			pizzadao.addPizza(pizza);
		} catch(SQLException e){
			System.out.print(e.getMessage());
		}
		String page ="/Pizzicato/Muokkaussivu";
		response.sendRedirect(page);
	}

}
