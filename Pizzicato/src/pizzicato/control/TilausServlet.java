package pizzicato.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Ostos;
import pizzicato.model.Tilaus;
import pizzicato.model.Tilausrivi;

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

		HttpSession session = request.getSession(false);

		String jsp = "/view/Ostoskori.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession(false);
		List<Ostos> ostokset = null;
		ostokset = (List<Ostos>) session.getAttribute("ostokset");
	
		/* luo tilaus olio */
		// for toistolla lis‰t‰‰n tilausrivej‰ tilaukselle
		
		
		Tilaus tilaus = new Tilaus();
		
		
		
		Tilausrivi tilausrivi = null;
		Ostos ostos;
		for (int i = 0; i < ostokset.size(); i++) {
			ostos = ostokset.get(i);
			// luodaan tilausrivi olio
			
		 tilausrivi = new Tilausrivi();
		 tilausrivi.setPizza(ostos.getPizza()) ;
		 tilausrivi.setExtramauste(ostos.getExtramauste());
		 tilausrivi.setMaara(ostos.getLkm());
		 tilausrivi.setRivihinta(ostos.getRivihinta());
		 tilaus.addTilausrivi(tilausrivi);
			
			
		}
		
		tilaus.Laskehinta();
		
		System.out.println("gjudafhdsfhdshgfdsfh " +tilausrivi);

		
	}

}
