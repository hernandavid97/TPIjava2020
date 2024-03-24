package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Mascota;
import entities.Transito;
import entities.Usuario;
import entities.Vacuna;
import logic.CtrlLoc;
import logic.TransitoLogic;
import logic.VacunaLogic;

/**
 * Servlet implementation class TransitoAdd
 */
@WebServlet({ "/VacunaAdd", "/vacunaadd" })
public class VacunaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VacunaAdd() {
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
		request.setAttribute("existe", false);
		request.getRequestDispatcher("WEB-INF/VacunaAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vacuna v = new Vacuna();
		v.setTitulo(request.getParameter("titulo"));
		v.setEspecie(request.getParameter("especie"));
		v.setDescripcion(request.getParameter("descripcion"));
		Integer id = VacunaLogic.altaVacuna(v);

		VacunaLogic vlogic = new VacunaLogic();
		boolean existe = vlogic.validaVacuna(id);
		System.out.print(existe);
		request.setAttribute("existe", existe);
		request.getRequestDispatcher("/WEB-INF/VacunaAdd.jsp").forward(request, response);

	}
}