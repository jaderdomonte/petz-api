package br.com.petz.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.entity.Client;
import br.com.petz.exception.ResourceNotFoundException;
import br.com.petz.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client findById(Long id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	public Client save(Client client) throws ResourceNotFoundException {
		Client clientSaved = new Client();
		try {
			clientSaved = this.repository.save(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException();
		}
		
		return clientSaved;
	}
	
	public List<Client> listAll(){
		return repository.findAll();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}