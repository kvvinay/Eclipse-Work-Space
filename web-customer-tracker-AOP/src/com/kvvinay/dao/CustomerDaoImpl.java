package com.kvvinay.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kvvinay.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by firstName",Customer.class);
		List<Customer> customer = query.getResultList();
		return customer;
	}
	
	@Override
	public void saveCustomer(Customer thecustomer){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(thecustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session s = sessionFactory.getCurrentSession();
		Customer c = s.get(Customer.class,id);
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		Session s = sessionFactory.getCurrentSession();
		Query q  = s.createQuery("delete from Customer where id=:custId");
		q.setParameter("custId",id);
		q.executeUpdate();
		
	}
	
	

}
