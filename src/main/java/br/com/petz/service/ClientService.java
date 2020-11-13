package br.com.petz.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.entity.Client;
import br.com.petz.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client findById(Long id) throws NoSuchElementException{
		return repository.findById(id).orElseThrow();
	}

	public Client save(Client client) {
		return this.repository.save(client);
	}
	
	public List<Client> listAll(){
		return repository.findAll();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
