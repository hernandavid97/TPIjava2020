package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Localidad;
import entities.Mascota;
import logic.CtrlLoc;
import logic.CtrlMas;

/**
 * Servlet implementation class LocalidadModif
 */
@WebServlet({ "/mascotamod", "/MascotaMod" })
public class MascotaModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaModif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/MascotaModif.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mascota  nueva = new Mascota();	
		Mascota  old = new Mascota();	
		nueva.setNombre(request.getParameter("nombre_mascota"));
		nueva.setColor(request.getParameter("color"));	
		nueva.setTipo(request.getParameter("tipo"));	
		nueva.setEdad(Integer.parseInt(request.getParameter("edad")));	
		nueva.setImagenes(request.getParameter("imagenes"));	
		System.out.println(nueva.getNombre());
		old.setId(Integer.parseInt(request.getParameter("id")));
		CtrlMas ctrlmas = new CtrlMas();
		request.setAttribute("estado", ctrlmas.validaModif(nueva,old));
		request.getRequestDispatcher("/WEB-INF/MascotaModif.jsp").forward(request, response);
	}

}
