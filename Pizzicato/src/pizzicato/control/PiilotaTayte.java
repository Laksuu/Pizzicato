package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.dao.TayteDAO;


@WebServlet("/PiilotaTayte")
public class PiilotaTayte extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idIn = request.getParameter("tid");
		int tayte_id = Integer.parseInt(idIn);
		TayteDAO taytedao = new TayteDAO();
		taytedao.piilotatayte(tayte_id);

		
		String page ="/Pizzicato/Muokkaussivu";
		response.sendRedirect(page);
	}

}
