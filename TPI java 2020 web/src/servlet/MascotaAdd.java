package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Mascota;
import entities.Usuario;

/**
 * Servlet implementation class MascotaAdd
 */
@WebServlet({ "/MascotaAdd", "/mascotaadd" })
public class MascotaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/MascotaAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mascota m = new Mascota();
		Usuario u = new Usuario();
		int id_don;
		m.setNombre(request.getParameter("nombre"));
		m.setNombre(request.getParameter("color"));
		m.setNombre(request.getParameter("especie"));
		m.setNombre(request.getParameter("edad"));
		m.setNombre(request.getParameter("imagenes"));
		u = (Usuario)request.getSession().getAttribute("usuario");
		id_don = u.getId();
	}

}