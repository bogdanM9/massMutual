package com.massMutual.controll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.massMutual.entity.model.Client;
import com.massMutual.entity.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepo;

	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}


	@Override
	public List<Client> getAll() {
		return clientRepo.findAll();
	}


	@Override
	public Client save(Client client) {
		return clientRepo.save(client);
	}


	

	@Override
	public Client update(Client client) {		
		return clientRepo.save(client);
	}


	@Override
	public Client findOneByEmail(String email) {
		return clientRepo.findOneByEmail(email);
	}


	@Override
	public Client getById(Long id) {
		return clientRepo.getOne(id);
	}


	@Override
	public void delete(Client c) {
		clientRepo.delete(c);
		
	}
	
	
}
