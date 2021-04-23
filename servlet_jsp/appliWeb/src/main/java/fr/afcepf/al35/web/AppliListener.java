package fr.afcepf.al35.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppliListener
 *
 */
@WebListener
public class AppliListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppliListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 ServletContext application = sce.getServletContext();
         Integer compteurConnexions  = (Integer)
        		 application.getAttribute("compteurConnexions");
         System.out.println("a l'arret de l'appli, compteurConnexions="
        		      +compteurConnexions);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext application = sce.getServletContext();
         application.setAttribute("compteurConnexions", 0);
    }
	
}
