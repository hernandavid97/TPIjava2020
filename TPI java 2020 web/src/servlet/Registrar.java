package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Localidad;
import entities.Usuario;
import logic.Login;

/**
 * Servlet implementation class Registrar
 */
@WebServlet({ "/Registrar", "/registrar" })
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setUsuario(request.getParameter("username"));
		u.setPassword(request.getParameter("pass"));
		u.setNombre(request.getParameter("nombre"));
		u.setApellido(request.getParameter("apellido"));
		u.setEmail(request.getParameter("email"));
		u.setDomicilio(request.getParameter("domicilio"));
		Localidad local = new Localidad();
		local.setId(Integer.parseInt(request.getParameter("localidad")));
		u.setLocalidad(local);
		u.setNroDoc(request.getParameter("nrodoc"));
		u.setTipo(1);
		u.setTipoDoc("dni");
		Login ctrl = new Login();
		ctrl.validaRegistro(u);
		u = ctrl.validate(u);
		request.getSession().setAttribute("usuario", u);	
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

}
