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
import javax.servlet.http.HttpSession;

import pizzicato.model.Pizza;
import pizzicato.model.Ostos;
import pizzicato.model.dao.PizzaDAO;

@WebServlet("/Ostoskori")
public class Ostoskori extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String jsp = "/view/Ostoskori.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(
				jsp);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		List<Ostos> ostokset = null;
		try {
			ostokset = (List<Ostos>) session.getAttribute("ostokset");

		} catch (Exception e) {
		}

		if (ostokset == null) {
			ostokset = new ArrayList<Ostos>();
		}

		String strid = request.getParameter("pizza_id");
		String strlkm = request.getParameter("lkm");

		// muunna string-tiedot luvuiksi
		int pizza_id = new Integer(strid);
		int lkm = new Integer(strlkm);

		String valittuOregano = request.getParameter("oregano");

		boolean oregano = false;

		if (valittuOregano != null) {
			oregano = true;
		}

		String valittuValkosipuli = request.getParameter("valkosipuli");

		boolean valkosipuli = false;

		if (valittuValkosipuli != null) {
			valkosipuli = true;
		}

		System.out.print("Valittu Oregano" + valittuOregano);
		System.out.print("valittu valkosipuli" + valittuValkosipuli);

		// t‰‰ if-leikki toimii ja ilmoittaa int-tietona mit‰ on tai ei ole
		// 0= ei mit‰‰n, 1=oregano, 2=valkosipuli, 3=oregano&valkosipuli

		int extramauste = 0;

		if (oregano == true && valkosipuli == true) {
			extramauste = 3;
		} else if (oregano == false && valkosipuli == true)
			extramauste = 2;
		else if (oregano == true && valkosipuli == false)
			extramauste = 1;
		else {
			extramauste = 0;
		}

		PizzaDAO pizzadao = new PizzaDAO();

		Pizza uusiPizza = pizzadao.etsiPizza(pizza_id);
		System.out.print("PIZZA:" + uusiPizza);
		double rivihinta = lkm * uusiPizza.getHinta();

		Ostos uusiostos = new Ostos();
		uusiostos.setPizza(uusiPizza);
		uusiostos.setLkm(lkm);
		uusiostos.setRivihinta(rivihinta);
		uusiostos.setExtramauste(extramauste);
		uusiostos.setOregano(oregano);
		uusiostos.setValkosipuli(valkosipuli);

		ostokset.add(uusiostos);
		// luo ostoskorin, jos ostoskori on koko on nolla
		if (ostokset.size() == 0) {
			session = request.getSession(true);

		}

		session.setAttribute("ostokset", ostokset);

		System.out.print("ostokset::::" + ostokset);

		response.sendRedirect("/Pizzicato/Ostoskori");

	}
}