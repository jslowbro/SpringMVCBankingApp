package com.janchabik.banking.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transfer")
public class Transfer {
	
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="timestamp")
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name="from_id")
	private Client sender;
	
	@ManyToOne
	@JoinColumn(name="to_id")
	private Client receiver;
	
	public Transfer() {
		
	}
	
	
	
	public Transfer(int amount, Timestamp timestamp, Client sender, Client receiver) {
		this.amount = amount;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.sender = sender;
		this.receiver = receiver;
	}
	

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", amount=" + amount + ", timestamp=" + timestamp + ", sender=" + sender
				+ ", receiver=" + receiver + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public Client getReceiver() {
		return receiver;
	}

	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}
	
	
	
	
}
