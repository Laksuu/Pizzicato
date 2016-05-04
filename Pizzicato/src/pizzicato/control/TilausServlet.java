package pizzicato.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Ostos;

/**
 * Servlet implementation class TilausServlet
 */
@WebServlet("/TilausServlet")
public class TilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TilausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession(false);
		List<Ostos> ostokset = null;
		ostokset = (List<Ostos>) session.getAttribute("ostokset");
	
	
	}

}
