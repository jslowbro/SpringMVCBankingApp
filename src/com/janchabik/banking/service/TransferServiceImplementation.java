package com.janchabik.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janchabik.banking.dao.TransferDAO;
import com.janchabik.banking.entity.Transfer;

@Service
public class TransferServiceImplementation implements TransferService {
	
	@Autowired
	private TransferDAO transferDAO;
	
	
	
	@Override
	@Transactional
	public List<Transfer> getTransferList() {
		
		return transferDAO.getTransferList();
	}

	@Override
	@Transactional
	public void saveTransfer(Transfer transfer) {
		transferDAO.saveTransfer(transfer);

	}

	@Override
	@Transactional
	public Transfer getTransfer(int id) {
		
		return transferDAO.getTransfer(id);
	}

	@Override
	@Transactional
	public void deleteTransfer(int id) {
		transferDAO.deleteTransfer(id);
	}

	@Override
	@Transactional
	public List<Transfer> getTransferList(int id) {
		
		return transferDAO.getTransferList(id);
	}
	
	

}
