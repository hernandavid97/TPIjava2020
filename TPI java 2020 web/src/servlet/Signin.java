package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.Usuario;
import logic.Login;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Signin", "/signin" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//VALIDAR INGRESOS Y PERSONA NULL
		
		String usuario = request.getParameter("username");
		String pass = request.getParameter("pass");
		Login ctrl = new Login();
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setPassword(pass);
		user = ctrl.validate(user);
		
		request.getSession().setAttribute("usuario", user);	
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

}
