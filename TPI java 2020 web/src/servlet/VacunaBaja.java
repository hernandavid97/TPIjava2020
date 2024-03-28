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
 * Servlet implementation class VacunaDelete
 */
@WebServlet({ "/VacunaBaja", "/vacunabaja" })
public class VacunaBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VacunaBaja() {
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
		if(usuario == null || usuario.getTipo() != 0) {
			request.getSession().setAttribute("permisos", "No tiene permisos");
			response.sendRedirect("Signin");
			return;
		}
		ArrayList<Vacuna> vacunas = VacunaLogic.getAll();
		request.setAttribute("vacunas", vacunas);
		request.getRequestDispatcher("/WEB-INF/VacunaBaja.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Vacuna> vacunas = VacunaLogic.getAll();
		request.setAttribute("vacunas", vacunas);
		VacunaLogic vlogic = new VacunaLogic();
		Vacuna v = new Vacuna();
		v.setId(Integer.parseInt(request.getParameter("vacuna")));
		String respString;
		try {
			respString = vlogic.validaBaja(v);
			request.setAttribute("estado", respString);
			request.getRequestDispatcher("/WEB-INF/VacunaBaja.jsp").forward(request, response);
		} catch (Exception er) {
			System.out.println(er.getMessage());
			request.setAttribute("estado", "Error");
			request.setAttribute("errorMessage", er.getMessage());
			request.getRequestDispatcher("/WEB-INF/VacunaBaja.jsp").forward(request, response);
		}

	}

}
