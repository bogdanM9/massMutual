package com.massMutual.controll.service;

import java.util.List;

import com.massMutual.entity.model.Client;



public interface ClientService {

	
	 List<Client> getAll();
	 
	 Client save (Client client);
	 
	 Client findOneByEmail(String email);
	 
	 Client update (Client client);

	Client getById(Long id);

	void delete(Client c);
	
}
