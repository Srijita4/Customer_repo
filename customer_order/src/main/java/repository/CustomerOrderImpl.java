package repository;
import javax.persistence.TypedQuery;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import factory.MySessionFactory;
import com.ibm.customer_order.*;
public class CustomerOrderImpl implements CustomerOrder{
	private SessionFactory sessionFactory = null;
	private Session session = null;
	{
		try {
			sessionFactory = MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public Customer insertCustomerOrder(Customer customer) throws Exception{
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.persist(customer);
			session.getTransaction().commit();
			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomerOrders() throws Exception {
		session = sessionFactory.openSession();
		TypedQuery<Customer> query = session.createQuery("FROM Customer C", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer findByCustomerId(String cusId) throws Exception {
		session = sessionFactory.openSession();
		Customer customer = session.find(Customer.class, cusId);
		return customer;
	}

	@Override
	public Customer updateByCustomerId(Customer cus) throws Exception {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(cus);
		session.getTransaction().commit();
		return cus;
	}

	@Override
	public Boolean deleteByCustomerId(Customer cus) throws Exception {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.remove(cus);
		session.getTransaction().commit();
		return null;
	}
	

}
