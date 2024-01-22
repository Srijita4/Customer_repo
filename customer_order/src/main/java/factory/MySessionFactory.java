package factory;
import com.ibm.customer_order.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MySessionFactory {
	
	private static SessionFactory sessionFactory=null;
	static{
		try {
			sessionFactory = new Configuration().configure()
	        		.addAnnotatedClass(Order.class).addAnnotatedClass(Customer.class).buildSessionFactory();
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() throws Exception
	{
		return sessionFactory;
	} 

}
