package com.janchabik.banking.service;

import java.util.List;

import com.janchabik.banking.entity.Client;

public interface ClientService {
	
	public List<Client> getClientList();
	
	public void saveClient(Client client);
	
	public Client getClient(int id);
	
	public void deleteClient(int id);
	
	public Client processLogin(Client client);
	
	public Client getClient(String email);
}
