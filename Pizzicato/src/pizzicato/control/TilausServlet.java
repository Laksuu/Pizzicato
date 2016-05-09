package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
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
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TilausDAO;

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
		
	
		

		String nimi = request.getParameter("nimi");
		String osoite = request.getParameter("osoite");
		String sposti = request.getParameter("sposti");
		
		String strpuh = request.getParameter("puh");
		int puh  = new Integer(strpuh);
		
		
		String valittutoimitus = request.getParameter("toimitus");
		String valittumaksutapa = request.getParameter("maksutapa");
		
	
		
		
		boolean toimitus = false;
		
		boolean maksutapa = false;
		
		
		if (valittutoimitus.equals("0") && valittumaksutapa.equals("0")) {
			toimitus = true;
			maksutapa = true;
		}
		else if (valittutoimitus.equals("1") && valittumaksutapa.equals("0")) {
		toimitus= false;
		maksutapa = true;
		}
		
		else if (valittutoimitus.equals("0") && valittumaksutapa.equals("1")) {
			toimitus= true;
			maksutapa = false;
		}
		else {
				toimitus= false;
				maksutapa= false;
			}
	
		
		tilaus.setNimi(nimi);
		tilaus.setOsoite(osoite);
		tilaus.setPuh(puh);
		tilaus.setSposti(sposti);
		tilaus.setToimitus(toimitus);
		tilaus.setMaksu(maksutapa);
		
		
		
		Tilausrivi tilausrivi = new Tilausrivi();
		Ostos ostos;
		for (int i = 0; i < ostokset.size(); i++) {
			ostos = ostokset.get(i);
			// luodaan tilausrivi olio
		 tilausrivi.setPizza(ostos.getPizza()) ;
		 tilausrivi.setExtramauste(ostos.getExtramauste());
		 tilausrivi.setMaara(ostos.getLkm());
		 tilausrivi.setRivihinta(ostos.getRivihinta());
		 tilaus.addTilausrivi(tilausrivi);
		 
			
			
		}

	
		
		
		
		TilausDAO tilausdao = new TilausDAO();
		try {
			tilausdao.addTilaus(tilaus);
			session.invalidate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		tilaus.Laskehinta();
		
		
		
		
		String jsp = "/view/Ostoskori.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);
	}

}
