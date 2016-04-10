package pizzicato.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import pizzicato.model.Kayttaja;
import pizzicato.model.dao.KayttajaDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestDispatcher jsp;
    
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        jsp = context.getRequestDispatcher("/view/Login.jsp");
     }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
       
       jsp.forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
     
       String username = req.getParameter("username");
       Kayttaja kayttaja = new KayttajaDAO().findByUsername(username);
       if (kayttaja == null)
       {
          req.setAttribute("message", "Tarkista käyttäjätunnus ja salasana.");
          jsp.forward(req, resp);
          return;
       }
       
       String password = req.getParameter("password");
       if (password == null || !kayttaja.getPassword().equals(password))
       {
          
          req.setAttribute("message", "Tarkista käyttäjätunnus ja salasana.");
          jsp.forward(req, resp);
          return;
       }

       HttpSession session = req.getSession();
       String Username = kayttaja.getUsername();
       session.setAttribute("Username", Username);
       System.out.println("TESTINGGGGGGGGG");
       String url = "Etusivu";
       resp.sendRedirect(url);
       System.out.println(Username);
       
      session = req.getSession(false);
       if (session == null || session.getAttribute("Username") == null) {
           // user is not logged in, do something about it
       } else {
           // user IS logged in, do something: set model or do whatever you need
       }
      
      
    }
      
    
    
    }  

