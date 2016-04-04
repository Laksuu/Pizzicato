package pizzicato.control;
/**
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
@WebServlet("/MuokkaaPizza")
public class Login extends HttpServlet {

		private static final long serialVersionUID = 1L;
    private RequestDispatcher jsp;
    
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        jsp = context.getRequestDispatcher("/view/login.jsp");
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
          
          req.setAttribute("message", "Authentication failed.");
          jsp.forward(req, resp);
          return;
       }
       
       String password = req.getParameter("password");
       if (password == null || !kayttaja.getPassword().equals(password))
       {
          
          req.setAttribute("message", "Authentication failed.");
          jsp.forward(req, resp);
          return;
       }

       HttpSession session = req.getSession();
       Long userId = kayttaja.getId();
       session.setAttribute("userId", userId);
      
       String url = "Etusivu";
       resp.sendRedirect(url);
    }  
}
**/