package com.janchabik.banking.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.janchabik.banking.entity.Client;
import com.janchabik.banking.entity.Transfer;
import com.janchabik.banking.service.ClientService;
import com.janchabik.banking.service.TransferService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private TransferService transferService;
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	@GetMapping("/welcome")
	public String initialize() {
		return "welcome-view";
	}
	
	@GetMapping("/showAdminView")
	public String showAdminView(Model model) {
		
		List<Client> clients = clientService.getClientList();
		
		model.addAttribute("clientList", clients);
		
		return "admin.client-list";
	}
	
	@GetMapping("/showAllTransfers")
	public String showAllTransfers(Model model) {
		
		
		
		List<Transfer> transfers = transferService.getTransferList();
		
		model.addAttribute("transferList", transfers);
		
		return "admin.client-view";
	}
	
	@GetMapping("/clientView")
	public String showClientView(@RequestParam ("Id") int id, Model model) {
		
		List<Transfer> transfers = transferService.getTransferList(id);
		
		Client client = clientService.getClient(id);
		
		model.addAttribute("client", client);
		
		model.addAttribute("transferList", transfers);
		
		return "admin.client-view";
		
	}
	@GetMapping("/showFormforAdd")
	public String showClientView(Model model) {
		
		Client client = new Client();
		client.setBalance(0);
		
		model.addAttribute("client", client );
		
		return "admin.add-client";
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "admin.add-customer";
		} else {
			client.setPassword(client.getLastName());
			clientService.saveClient(client);
			return "redirect:/admin/showAdminView";
		}
	}
	
	
	
}
