package com.massMutual.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.massMutual.entity.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	

	Client findOneByEmail(String email);
}
