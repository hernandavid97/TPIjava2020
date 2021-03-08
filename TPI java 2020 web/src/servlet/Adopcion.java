package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Mascota;
import entities.Transito;
import entities.Usuario;
import logic.TransitoLogic;

/**
 * Servlet implementation class Adopcion
 */
@WebServlet({ "/Adopcion", "/adopcion" })
public class Adopcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adopcion() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		String adopcion = request.getParameter("seleccionada");
		if (adopcion != null) {
			Integer id_transito = Integer.parseInt(adopcion);
			TransitoLogic.adopcion(id_transito, u.getId());
		}
		


		
    	ArrayList<Transito> transitos = TransitoLogic.getAll();
    	request.setAttribute("listaTransitos", transitos);
		request.getRequestDispatcher("/WEB-INF/TransitoList.jsp").forward(request, response);
		
		request.getRequestDispatcher("WEB-INF/TransitoList.jsp").forward(request, response);
	}
}