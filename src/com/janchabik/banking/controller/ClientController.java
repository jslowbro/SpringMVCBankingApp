package com.janchabik.banking.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.janchabik.banking.container.TransferDataContainer;
import com.janchabik.banking.entity.Client;
import com.janchabik.banking.entity.Transfer;
import com.janchabik.banking.service.ClientService;
import com.janchabik.banking.service.TransferService;
import com.sun.javafx.sg.prism.NGShape.Mode;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@Autowired
	private TransferService transferService;
	
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		
		model.addAttribute("client",new Client());
		
		return "client-login";
	}
	
	@PostMapping("/processLogin")
	public String processLogin(@ModelAttribute("client") Client client, Model model) {
		
		
		Client loggedClient = clientService.processLogin(client);
		
		
		if(loggedClient != null) {
			
			TransferDataContainer transferData = new TransferDataContainer();
			
			transferData.setLoggedClient(loggedClient);
			
			List<Transfer> transferList = transferService.getTransferList(loggedClient.getId());
			
			transferData.setTransferList(transferList);
			
			//model.addAttribute("transferList", transferList);
			
			model.addAttribute("transferData", transferData);
			return "client-logged";
		} else {
			return "client-login";
		}
		
	}
	
	@PostMapping("/transferMoney")
	public String processTransfer(@ModelAttribute("transferData") TransferDataContainer transferData, Model model) {
		
		Client recipient = clientService.getClient(transferData.getMail());
		Client loggedClient = transferData.getLoggedClient();
		System.out.println(loggedClient.toString());
		
		if(transferData.getAmount() > loggedClient.getBalance()) {
			System.out.println("You cannot send more than you have");
		} else if(recipient==null) {
			System.out.println("Invalid recepient");
		} else {
			int amount = transferData.getAmount();
			// Updating data
			loggedClient.setBalance(loggedClient.getBalance()-amount);
			recipient.setBalance(recipient.getBalance()+amount);
			Transfer transfer = new Transfer(amount, new Timestamp(System.currentTimeMillis()) , loggedClient, recipient);
			
			clientService.saveClient(loggedClient);
			clientService.saveClient(recipient);	
			transferService.saveTransfer(transfer);
			
		}
		
		List<Transfer> transferList = transferService.getTransferList(loggedClient.getId());
		
		transferData.setTransferList(transferList);
		
		
		model.addAttribute("loggedClient", loggedClient);
		
		return "client-logged";
	}
	
	@GetMapping("/logOut")
	public String logOut(@ModelAttribute("transferData") TransferDataContainer transferData) {
		
		
		
		return "client-login";
	}
}
