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
 * Servlet implementation class LocalidadModif
 */
@WebServlet({ "/LocalidadMod", "/localidadmod" })
public class LocalidadModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalidadModif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/LocalidadModif.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Localidad  nueva = new Localidad();	
		Localidad  old = new Localidad();	
		nueva.setNombre(request.getParameter("nombre_localidad"));
		nueva.setProvincia(request.getParameter("provincia"));	
		old.setId(Integer.parseInt(request.getParameter("id")));
		CtrlLoc ctrlLoc = new CtrlLoc();
		request.setAttribute("estado", ctrlLoc.validaModif(nueva,old));
		request.getRequestDispatcher("/WEB-INF/LocalidadModif.jsp").forward(request, response);
	}

}
