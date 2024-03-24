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
 * Servlet implementation class usuarioModif
 */
@WebServlet({ "/usuariomod", "/usuarioMod", "/UsuarioMod" })
public class usuarioModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarioModif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/UsuarioModif.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario  nuevo = new Usuario();	
		Usuario  old = (Usuario)request.getSession().getAttribute("usuario");	
		nuevo.setNroDoc(request.getParameter("nrodoc"));
		nuevo.setTipoDoc("DNI");
		nuevo.setId(old.getId());
		nuevo.setUsuario(request.getParameter("username"));
		nuevo.setNombre(request.getParameter("nombre"));
		nuevo.setApellido(request.getParameter("apellido"));	
		nuevo.setEmail(request.getParameter("email"));
		nuevo.setDomicilio(request.getParameter("domicilio"));
		nuevo.setDonante(true);
		nuevo.setAdoptante(true);
		nuevo.setTipo(old.getTipo());
		nuevo.setPassword(request.getParameter("pass"));
		Localidad local = new Localidad();
		local.setId(Integer.parseInt(request.getParameter("localidad")));
		//System.out.println("trae localidad: " + request.getParameter("localidad"));
		nuevo.setLocalidad(local);	
		//System.out.println("localidad seteada " + nuevo.getLocalidad().getId());
		Login ctrl = new Login();				
		request.setAttribute("estado", ctrl.validaModif(nuevo,old));
		request.getRequestDispatcher("/WEB-INF/UsuarioModif.jsp").forward(request, response);
	}

}
