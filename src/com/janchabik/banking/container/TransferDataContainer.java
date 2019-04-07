package com.janchabik.banking.container;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.janchabik.banking.entity.Client;
import com.janchabik.banking.entity.Transfer;

public class TransferDataContainer {
	
	private String mail;

	@Min(value=1)
	private int amount;
	
	private Client loggedClient;
	
	private List<Transfer> transferList;
	
	
	public TransferDataContainer() {
		
	}


	public TransferDataContainer(String email, int amount) {
		this.mail = email;
		this.amount = amount;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String email) {
		this.mail = email;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "TransferDataContainer [email=" + mail + ", amount=" + amount + "]";
	}


	public Client getLoggedClient() {
		return loggedClient;
	}


	public void setLoggedClient(Client loggedClient) {
		this.loggedClient = loggedClient;
	}


	public List<Transfer> getTransferList() {
		return transferList;
	}


	public void setTransferList(List<Transfer> transferList) {
		this.transferList = transferList;
	}


	
	
	
}
