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
 * Servlet implementation class TransitoAdd
 */
@WebServlet({ "/TransitoAdd", "/transitoadd" })
public class TransitoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransitoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/TransitoAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mascota m = new Mascota();
		Transito t = new Transito();
		Usuario u = new Usuario();
		m.setNombre(request.getParameter("nombre_mascota"));
		m.setTipo(request.getParameter("tipo"));
		m.setEdad(Integer.parseInt(request.getParameter("edad")));
		m.setColor(request.getParameter("color"));
		m.setImagenes(request.getParameter("imagenes"));
		m.setDisponible(true);
		u = (Usuario)request.getSession().getAttribute("usuario");
		
		TransitoLogic.insertOne(t, m, u);
		
    	ArrayList<Transito> transitos = TransitoLogic.getAll();
    	request.setAttribute("listaTransitos", transitos);
		request.getRequestDispatcher("/WEB-INF/TransitoList.jsp").forward(request, response);
		
		request.getRequestDispatcher("WEB-INF/TransitoList.jsp").forward(request, response);
	}
}