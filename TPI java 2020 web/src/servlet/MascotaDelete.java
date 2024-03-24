package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Mascota;
import logic.CtrlMas;

/**
 * Servlet implementation class LocalidadDelete
 */
@WebServlet({ "/MascotaDelete", "/mascotadelete" })
public class MascotaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MascotaDelete() {
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
		request.getRequestDispatcher("/WEB-INF/MascotaBaja.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CtrlMas ctrl = new CtrlMas();
		Mascota m = new Mascota();
		m.setId(Integer.parseInt(request.getParameter("mascota")));
		String respString;
		try {
			respString = ctrl.validaBaja(m);
			request.setAttribute("estado", respString);
			request.getRequestDispatcher("/WEB-INF/MascotaBaja.jsp").forward(request, response);
		} catch (Exception er) {
			System.out.println(er.getMessage());
			request.setAttribute("estado", "Error");
			request.setAttribute("errorMessage", er.getMessage());
			request.getRequestDispatcher("/WEB-INF/MascotaBaja.jsp").forward(request, response);
		}

	}

}
