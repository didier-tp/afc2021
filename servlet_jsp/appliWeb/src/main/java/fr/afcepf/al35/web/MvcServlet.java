package fr.afcepf.al35.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afcepf.al35.web.model.CaddyBean;
import fr.afcepf.al35.web.model.LoginBean;
import fr.afcepf.al35.web.model.RechercheBean;

/**
 * Servlet implementation class MvcServlet
 */
@WebServlet("/MvcServlet")
public class MvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tache = request.getParameter("tache");
		switch(tache) {
		case "rechercheInfosPays":
			doRechercheInfosPays(request,response);
			break;
		case "login":
			doLogin(request,response);
			break;
		case "addInCaddy":
			doAddInCaddy(request,response);
			break;
		}
	}
	
	protected void doRechercheInfosPays(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomPays = request.getParameter("nomPays");
		String urlPage = "/recherche.jsp";
		RechercheBean  recherchePays = new RechercheBean();
		recherchePays.setNomPays(nomPays);
		if(recherchePays.rechercherPays()) {
			//...
		}else {
			//...
		}
		//on ajoute (avant le forward) dans l'objet request une information
		//qui servira à accéder au bean depuis la page jsp
		//ex: ${rechercheBean.message} coté jsp
		request.setAttribute("rechercheBean",recherchePays);
		
		RequestDispatcher rd =
		    getServletContext().getRequestDispatcher(urlPage);
		rd.forward(request,response);//redirection du servlet vers page JSP
	}
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlPage ;
		LoginBean  loginBean = new LoginBean();
		loginBean.setUsername(request.getParameter("username")); 
		loginBean.setPassword(request.getParameter("password")); 
		if(	loginBean.loginUser()) {
			urlPage = "/utilisateur.jsp";
		}else {
			urlPage = "/login.jsp";
		}
		//on ajoute (avant le forward) dans l'objet request une information
		//qui servira à accéder au bean depuis la page jsp
		//ex: ${loginBean.message} coté jsp
		//request.setAttribute("loginBean",loginBean);
		
		HttpSession session = request.getSession(); //session de l'utilisateur courant
		session.setAttribute("loginBean",loginBean);
		
		RequestDispatcher rd =
		    getServletContext().getRequestDispatcher(urlPage);
		rd.forward(request,response);//redirection du servlet vers page JSP
	}
	
	protected void doAddInCaddy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlPage = "/addInCaddy.jsp" ;
		CaddyBean  caddyBean = new CaddyBean();
		HttpSession session = request.getSession(); //session de l'utilisateur courant
		caddyBean.addProduitDansCaddy(request.getParameter("produit"),
				                     session);
		
		request.setAttribute("caddyBean",caddyBean);
		
		RequestDispatcher rd =
		    getServletContext().getRequestDispatcher(urlPage);
		rd.forward(request,response);//redirection du servlet vers page JSP
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
