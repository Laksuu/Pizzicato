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






import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TayteDAO;
import pizzicato.control.MuokkaaPizza;


@WebServlet("/Muokkaussivu")
public class Muokkaussivu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Luodaan pizzatDAO ja käsketään hakemaan kaikki jutut
		PizzaDAO pizzaDAO = new PizzaDAO();
		ArrayList<Pizza> Pizzat = pizzaDAO.findAll(); 
		
		TayteDAO tayteDAO = new TayteDAO();
		ArrayList<Tayte> Taytteet = tayteDAO.findAll();

		// Talletetaan request-olion alle henkilölista, jotta tiedot ovat
		// käytössä jsp:llä
		request.setAttribute("pizzat", Pizzat); 
		request.setAttribute("taytteet", Taytteet);
		
		List<Pizza> piilossa = pizzaDAO.findAllHidden();
		request.setAttribute("piilopizzat", piilossa);
		List<Tayte> tpiilossa = tayteDAO.findAllHidden();
		request.setAttribute("piilotaytteet", tpiilossa);
		
		
		String jsp = "/view/Muokkaussivu.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			   HttpServletResponse response) throws ServletException, IOException {
	
		
		  String valitunPizzanId=request.getParameter("pizza_id");
		  int id = Integer.parseInt(valitunPizzanId);
		  PizzaDAO pizzadao = new PizzaDAO();
		  ArrayList<Pizza> pizza = pizzadao.findAll();
		  
		  Pizza valittuPizza = new Pizza();
		  for(Pizza pizzaa : pizza){
		   if(pizzaa.getPizza_id()==(id)){
		    valittuPizza = pizzaa;
		   }
		  }
		  
		  request.setAttribute("valittuPizza", valittuPizza);
		  
		  String jsp = "/view/Muokkaussivu.jsp";
		  RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		  dispather.forward(request, response);
		  
		  
		  String valitunTaytteenId=request.getParameter("tayte_id");
		  int tid = Integer.parseInt(valitunTaytteenId);
		  TayteDAO taytedao = new TayteDAO();
		  ArrayList<Tayte> tayte = taytedao.findAll();
		  
		  Tayte valittuTayte = new Tayte();
		  for(Tayte taytee : tayte){
			  if(taytee.getTayte_id()==(tid)){
				  valittuTayte = taytee;
			  }
		  }
	}	
	
} 
		
		
		



		
		
		
