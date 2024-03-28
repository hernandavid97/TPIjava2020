package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;
import entities.Vacuna;
import logic.VacunaLogic;

/**
 * Servlet implementation class TransitoList
 */
@WebServlet({ "/VacunaList", "/vacunalist" })
public class VacunaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VacunaList() {
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
		ArrayList<Vacuna> vacunas = VacunaLogic.getAll();
		request.setAttribute("listaVacunas", vacunas);
		request.getRequestDispatcher("/WEB-INF/VacunaList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}