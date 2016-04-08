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




@WebServlet("/MuokkaaPizza")
public class MuokkaaPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		int pizza_id;
		String pizza_idstr;
		String nimi;
		double hinta;
		String hintastr;
		// arraylist taytteet
		
		pizza_idstr = request.getParameter("pizza_id");
		pizza_id = Integer.parseInt(request.getParameter("pizza_id"));
		nimi= request.getParameter("nimi");
		hintastr = request.getParameter("hinta");
		hinta = Double.parseDouble(request.getParameter("hinta"));
		// arraylist taytteet
		
		Pizza pizza = new Pizza(pizza_id, nimi, hinta);
		
		PizzaDAO pizzaDAO = new PizzaDAO();
		ArrayList<Pizza> Pizzat = pizzaDAO.findAll(); 
		
		request.setAttribute("pizzat", Pizzat);
		
		 String jsp = "/view/MuokkaaPizza.jsp";
		  RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		  dispather.forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pizza_id;
		String pizza_idstr = null;
		double hinta;
		String hintastr;
		try 
		{
			hintastr = request.getParameter("hinta");
			hinta = Double.parseDouble(request.getParameter("hinta"));
			
			pizza_idstr = request.getParameter("pizza_id");
			pizza_id = Integer.parseInt(request.getParameter("pizza_id"));
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		String nimi = request.getParameter("nimi");
		// arraylist täytteet??
		
	
		Pizza pizza = new Pizza(pizza_id, nimi, hinta);
		PizzaDAO dao = new PizzaDAO();
		dao.muokkaa(pizza);
		
		String page = "Muokkaussivu";
		response.sendRedirect(page);
	}
}

		/*
			int pizza_id;
			String pizza_idstr;
			String nimi;
			double hinta;
			String hintastr;
			
			pizza_idstr = request.getParameter("pizza_id");
			pizza_id = Integer.parseInt(request.getParameter("pizza_id"));
			nimi= request.getParameter("nimi");
			hintastr = request.getParameter("hinta");
			hinta = Double.parseDouble(request.getParameter("hinta"));
			
			
			System.out.println(pizza_id + nimi + hinta);
			Pizza pizza = new Pizza();
			pizza.setPizza_id(pizza_id);
			pizza.setHinta(hinta);
			pizza.setNimi(nimi);
			
			
			
			PizzaDAO pizzadao = new PizzaDAO();
			
			try 
			{
				pizzadao.muokkaa(pizza);
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
			
			System.out.println(pizza_id + nimi + hinta);
			
			System.out.println(pizza);
		
			
			
			System.out.println(pizza_id + nimi + hinta + "3");
			 String jsp = "/view/MuokkaaPizza.jsp";
			  RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
			  dispather.forward(request, response);
		}

}
*/
	