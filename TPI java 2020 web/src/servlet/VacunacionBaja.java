package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataVacunacion;
import entities.Mascota;
import entities.Transito;
import entities.Usuario;
import entities.Vacunacion;
import logic.TransitoLogic;
import logic.VacunacionLogic;

/**
 * Servlet implementation class TransitoAdd
 */
@WebServlet({ "/vacunacionbaja", "/VacunacionBaja" })
public class VacunacionBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VacunacionBaja() {
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
		request.getRequestDispatcher("WEB-INF/VacunacionBaja.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
  
        try {
			Vacunacion v = new Vacunacion();
			v.setId_vacunacion(Integer.parseInt(request.getParameter("selectVacuna")));
			System.out.println(v.getId_vacuna());
			VacunacionLogic ctrlVac = new VacunacionLogic();
			String res = ctrlVac.validaBaja(v);
			System.out.println(res);
			request.setAttribute("message", res);
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("estado", "Ha ocurrido un error" );
			request.getRequestDispatcher("/WEB-INF/VacunacionAdd.jsp").forward(request, response);
		}

	}
}