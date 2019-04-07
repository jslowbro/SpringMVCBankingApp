package com.janchabik.banking.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.janchabik.banking.entity.Client;


@Repository
public class ClientDAOImplementation implements ClientDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Client> getClientList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Client> query = session.createQuery("from Client order by lastName", Client.class);
		
		List<Client> list = query.getResultList();
		
		return list;
	}

	@Override
	public void saveClient(Client client) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(client);
			
	}

	@Override
	public Client getClient(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Client.class, id);
	}

	@Override
	public void deleteClient(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(session.get(Client.class, id));

	}

	@Override
	public Client processLogin(Client client) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Client> query = session.createQuery("from Client where email=:clientEmail and password=:clientPassword", Client.class);
		
		//System.out.println("DAO: Client's email and password : " + client.getEmail() + "   " + client.getPassword());
		query.setParameter("clientEmail", client.getEmail());
		query.setParameter("clientPassword", client.getPassword());
		
		List<Client> list = query.getResultList();
		
		return getListElement(list);
		
		
	}

	@Override
	public Client getClient(String email) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Client> query = session.createQuery("from Client where email=:clientEmail", Client.class);
		
		query.setParameter("clientEmail", email);
		
		List<Client> list = query.getResultList();
		
		return getListElement(list);
		
	}
	
	private Client getListElement(List<Client> list) {
		if(list.size() != 1) {
			System.out.println("List size : " + list.size());
			System.out.println("Oops something went wrong... Here is the list of clients found by query: ");
			for(Client tempclient : list) {
				
				System.out.println(tempclient);
			}
			return null;
		} else {
			//System.out.println("Found a client! Here he is");
			//System.out.println(list.get(0));
			return list.get(0);
		}
	}
	
	

}
