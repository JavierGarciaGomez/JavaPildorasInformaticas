package servlets.servletTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class firstServlet
 */
@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Formato de respuesta
		PrintWriter printWriter = response.getWriter();
		
		// Generar respuesta
		printWriter.println("<html><body>");
		printWriter.println("<h1 style='text-align:center'>Prueba Servlet</h1>");
		printWriter.println("");
		printWriter.println("");
		printWriter.println("");
		printWriter.println("");
		printWriter.println("");
		printWriter.println("Fecha y hora actual: "+new Date());
		printWriter.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
