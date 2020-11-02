package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Localidad;

import logic.CtrlLoc;

/**
 * Servlet implementation class LocalidadDelete
 */
@WebServlet({"/LocalidadDelete", "/localidaddelete"})
public class LocalidadDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalidadDelete() {
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
		CtrlLoc ctrl = new CtrlLoc();
		Localidad l = new Localidad();
		l.setId(Integer.parseInt(request.getParameter("localidad")));		
		request.setAttribute("estado", ctrl.validaBaja(l));
		request.getRequestDispatcher("LocalidadBaja.jsp").forward(request, response);
		
	}

}
