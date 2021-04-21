package fr.afcepf.al35.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TvaServlet
 */
@WebServlet("/TvaServlet")
public class TvaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int compteur=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TvaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * exemple url : http://localhost:8080/appliWeb/TvaServlet?ht=200&taux=20
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sHt = request.getParameter("ht");
		String sTaux = request.getParameter("taux");
		Double ht = Double.parseDouble(sHt);
		Double taux = Double.parseDouble(sTaux);
		Double tva = ht * taux / 100;
		Double ttc = ht + tva;
		
		synchronized(this) {
		   compteur++;
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>tva="+tva+"</p>");
		out.println("<p>ttc=<b>"+ttc+"</b></p>");
		out.println("<p>compteur=<i>"+compteur+"</i></p>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
