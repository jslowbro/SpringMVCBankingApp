package com.janchabik.banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.janchabik.banking.entity.Transfer;

@Repository
public class TransferDAOImplementation implements TransferDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Transfer> getTransferList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Transfer> query = session.createQuery("from Transfer order by timestamp", Transfer.class);
		
		List<Transfer> list = query.getResultList();
		
		return list;
	}

	@Override
	public void saveTransfer(Transfer transfer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(transfer);

	}

	@Override
	public Transfer getTransfer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransfer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Transfer> getTransferList(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Transfer> query = session.createQuery("from Transfer where from_id=:clientID or to_id=:clientID order by timestamp", Transfer.class);
		
		query.setParameter("clientID", id);
		
		List<Transfer> list = query.getResultList();
		
		return list;

	}
	

}
