package pizzicato.control;

import java.io.IOException;

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
 * Servlet implementation class MuokkaaTayte
 */
@WebServlet("/MuokkaaTayte")
public class MuokkaaTayte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuokkaaTayte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tayte_id;
		String tayte_idstr = null;
		double hinta;
		String hintastr;
		try 
		{
			hintastr = request.getParameter("hinta");
			hinta = Double.parseDouble(request.getParameter("hinta"));
			
			tayte_idstr = request.getParameter("tayte_id");
			tayte_id = Integer.parseInt(request.getParameter("tayte_id"));
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		String taytenimi = request.getParameter("tayte");
		System.out.println("TESTI1" + tayte_id);
		
		System.out.println("TESTI2" + hinta);
		Tayte tayte = new Tayte(tayte_id, hinta, taytenimi);
		TayteDAO taytedao = new TayteDAO();
		System.out.println("TESTI3");
		taytedao.muokkaa(tayte);
		
		String page = "Muokkaussivu";
		response.sendRedirect(page);
	}
}
