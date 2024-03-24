package servlet;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;
import logic.Login;

/**
 * Servlet implementation class usuarioModif
 */
@WebServlet({ "/usuariobaj", "/usuarioBaj", "/UsuarioBaj" })
public class usuarioBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public usuarioBaja() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/UsuarioBaja.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Usuario old = (Usuario) request.getSession().getAttribute("usuario");
		Login ctrl = new Login();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		old.setFechaBaja(formatter.format(new java.util.Date()));
		System.out.println("usuario baja: " + old.toString());
		request.setAttribute("estado", ctrl.validaBaja(old));
		HttpSession sesion = request.getSession();
		sesion.removeAttribute("usuario");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
