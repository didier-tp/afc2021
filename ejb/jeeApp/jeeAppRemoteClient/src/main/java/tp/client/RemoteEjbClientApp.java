package tp.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import tp.core.bs.CalculTvaRemote;
import tp.core.dto.ResCalculTva;

public class RemoteEjbClientApp {

	public static void main(String[] args) {
		try {
			String machineServeur = "localhost"; //ou "192.168.xx.yy"
			
			
			Properties props = new Properties();//java.util
			//Context et InitialContext de javax.naming (JNDI)
			
			//props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			
			
			props.put(Context.INITIAL_CONTEXT_FACTORY,
		    			/* "org.jboss.naming.remote.client.InitialContextFactory"*/
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
					    
			props.put(Context.PROVIDER_URL, "http-remoting://"+machineServeur+":8080");
					// remote://localhost:4447 for Jboss7.1 , http-remoting://localhost:8080 for wildfly 8,9
			//props.put(Context.SECURITY_PRINCIPAL, "guest"); // username : "admin" , "guest" , "..."
			//props.put(Context.SECURITY_CREDENTIALS, "guest007"); //password : "pwd", "guest007"
					//avec utilisateur ajouté via la commande JBOSS_7_HOME/bin/add-user
					//et roles associés admin,guest,.... sur partie "ApplicationRealm" .
			//props.put("jboss.naming.client.ejb.context", true); //quelquefois indispensable pour accès @Remote
			Context jndiContext = new InitialContext(props);
			
			//NB: ce nom logique (respectant la norme JEE6) s'affiche dans la console jboss
			//lors du démarrage du projet servEjb
			String nomLogiqueEjbCalculateur= "jeeAppEar-0.0.1-SNAPSHOT/JeeAppCoreEjb/CalculTvaImpl!tp.core.bs.CalculTvaRemote";
			//ne pas utiliser le préfixe "ejb:" avec cette version/configuration (de Jboss, du client , ...) 
			//connection à l'objet distant RMI via son nom logique
			CalculTvaRemote proxyCalculateurTva = (CalculTvaRemote) jndiContext.lookup(nomLogiqueEjbCalculateur);
			//appels de méthodes à distance (via le réseau):
			double tva= proxyCalculateurTva.tva(200.0, 20.0);
			String auteur = proxyCalculateurTva.getAuteur();
			ResCalculTva resCalculTva = proxyCalculateurTva.tvaEtTtc(200.0, 20.0);
			
			System.out.println("RemoteEjbClientApp\n************");
			System.out.println("ttc="+resCalculTva.getTtc());
			System.out.println("tva="+tva);
			System.out.println("auteur (ejb remote)="+auteur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
