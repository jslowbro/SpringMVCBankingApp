package com.janchabik.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janchabik.banking.dao.ClientDAO;
import com.janchabik.banking.entity.Client;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Service
public class ClientServiceImplementation implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	
	@Override
	@Transactional
	public List<Client> getClientList() {
		return clientDAO.getClientList();
	}

	@Override
	@Transactional
	public void saveClient(Client client) {
		clientDAO.saveClient(client);
	}

	@Override
	@Transactional
	public Client getClient(int id) {
		return clientDAO.getClient(id);
	}

	@Override
	@Transactional
	public void deleteClient(int id) {
		clientDAO.deleteClient(id);
	}

	@Override
	@Transactional
	public Client processLogin(Client client) {
		return clientDAO.processLogin(client);
	}

	@Override
	@Transactional
	public Client getClient(String email) {
		
		return clientDAO.getClient(email);
	}

	
	
	
	

}
