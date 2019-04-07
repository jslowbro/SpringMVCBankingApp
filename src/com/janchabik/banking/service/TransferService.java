package com.janchabik.banking.service;

import java.util.List;

import com.janchabik.banking.entity.Transfer;

public interface TransferService {
	
	public List<Transfer> getTransferList();
	
	public void saveTransfer(Transfer Transfer);
	
	public Transfer getTransfer(int id);
	
	public void deleteTransfer(int id);
	
	public List<Transfer> getTransferList(int id);
	
	
}
