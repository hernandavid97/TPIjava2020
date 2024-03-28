package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Mascota;
import entities.Usuario;
import logic.MascotaLogic;

/**
 * Servlet implementation class MascotaAdd
 */
@WebServlet({ "/MascotaList", "/mascotalist" })
public class MascotaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MascotaList() {
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
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		if(usuario == null ) {
			request.getSession().setAttribute("permisos", "Usuario inválido, inicie sesión");
			response.sendRedirect("Signin");
			return;
		}
		LinkedList<Mascota> mascotas = MascotaLogic.getAll();
		request.setAttribute("listaMascotas", mascotas);
		request.getRequestDispatcher("/WEB-INF/MascotaList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}