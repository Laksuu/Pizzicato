package pizzicato.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ostoskori
 */
@WebServlet("/Ostoskori")
public class Ostoskori extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jsp = "/view/Ostoskori.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		
		
		String strid = request.getParameter("pizza_id");
		String strlkm = request.getParameter("lkm");
		
		// muunna string-tiedot luvuiksi
		int pizza_id = new Integer(strid);
		int lkm = new Integer(strlkm);
		
		
		System.out.print("Pizzan id:"+pizza_id);
		System.out.print("Pizzan id:"+strid);
		System.out.print("Pizzan lukum‰‰r‰:"+strlkm);
		
		
	
	}

}
