package tp.client;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MyJMSClient {
	
	private static Properties props = new Properties();
	
	public static void main(String[] args) {
		initJndiClientProperties();
		try {
			Context jndiContext = new InitialContext(props);
			testJms(jndiContext);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	public static void initJndiClientProperties() {
		
		String machineServeur = "localhost"; //ou "192.168.xx.yy"
		
		props.put(Context.INITIAL_CONTEXT_FACTORY,
    			/* "org.jboss.naming.remote.client.InitialContextFactory"*/
			"org.wildfly.naming.client.WildFlyInitialContextFactory");
			    
	    props.put(Context.PROVIDER_URL, "http-remoting://"+machineServeur+":8080");
	
		props.put(Context.SECURITY_PRINCIPAL, "guest");//"admin" , "guest" , "..."
		props.put(Context.SECURITY_CREDENTIALS, "guest007"); //"pwd", "guest007"
		//avec admin = utilisateur ajouté via la commande JBOSS7_HOME/bin/add-user 
		//mot de passe=pwd et rôles associés admin,guest
		//et avec "guest" = rôle configuré sur la partie "messaging" de standalone(-full).xml *
}
	
	private static Connection initJmsConnection(Context jndiContext){
		ConnectionFactory connectionFactory=null;
		
		Connection connection = null;
		try  {
				 connectionFactory = (ConnectionFactory)jndiContext.lookup("jms/RemoteConnectionFactory");
				//avec <entry name="java:jboss/exported/jms/RemoteConnectionFactory"/>           
				//dans standalone(-full).xml 
				 
				 connection = connectionFactory.createConnection( props.getProperty(Context.SECURITY_PRINCIPAL),
				                                                    props.getProperty(Context.SECURITY_CREDENTIALS)); 
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void testJms(Context jndiContext) {
		try {
			Connection connection = initJmsConnection(jndiContext);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//queue = (Queue) jndiContext.lookup("myQueue"); //or jms/myQueue ?
			//Queue queue = (Queue) ic.lookup("jms/queue/myQueue"); 
			// avec queue/myQueue qui doit etre exporté dans standalone(-full).xml 
			//<entry name="java:jboss/exported/jms/queue/test"/> 
			
			Queue queue=session.createQueue("myQueue"); //NB: createQueue() create a new queue or open an existing one
			
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message = session.createTextMessage();
			
			final int NUM_MSGS=4;
			for (int i = 0; i < NUM_MSGS; i++) {
			    message.setText("message du vendredi , " + (i + 1));
			    System.out.println("Sending message: " + message.getText());
			    messageProducer.send(message);
			}
			messageProducer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

}
