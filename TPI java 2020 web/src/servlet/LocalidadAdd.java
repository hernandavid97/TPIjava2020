package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Localidad;
import entities.Usuario;
import logic.CtrlLoc;
import logic.Login;

/**
 * Servlet implementation class LocalidadAdd
 */
@WebServlet({ "/LocalidadAdd", "/localidadadd", "/localidadAdd" })
public class LocalidadAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalidadAdd() {
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
		Localidad l = new Localidad();		
		l.setNombre(request.getParameter("nombre_localidad"));
		l.setProvincia(request.getParameter("provincia"));		
		CtrlLoc ctrlLoc = new CtrlLoc();
		ctrlLoc.validaAlta(l);
		l = ctrlLoc.validaLocalidad(l);	
		request.setAttribute("loc", l);
		request.getRequestDispatcher("LocalidadAdd.jsp").forward(request, response);
	}

}
