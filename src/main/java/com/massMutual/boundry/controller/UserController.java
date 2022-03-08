package com.massMutual.boundry.controller;

import java.util.List;

import org.modelmapper.TypeToken;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.massMutual.controll.service.ClientService;
import com.massMutual.entity.model.Client;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {

	private ClientService clientService;

	@Autowired
	public UserController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Client> saveUser(@RequestBody Client user) {
		Client c = clientService.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}

	@PutMapping(value = "/update/{email}")
	public ResponseEntity<?> update(@PathVariable String email, @RequestBody Client user) {
		Client c = (Client) clientService.findOneByEmail(email);
		if (c == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu exista acest user");
		user.setId(c.getId());

		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.update(user));

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Client c = clientService.getById(id);
		try {
			if (c.getEmail() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu exista user cu acest id!");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu exista user cu acest id!");
		}

		clientService.delete(c);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("User sters cu succes!");
	}

	@GetMapping
	public ResponseEntity<List<Client>> getUsers() {
		List<Client> users = clientService.getAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(users);
	}

	@GetMapping(value = "/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email) {

		Client c = (Client) clientService.findOneByEmail(email);
		if (c == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu exista acest user");

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(c);
	}

}
