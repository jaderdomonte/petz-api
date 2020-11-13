package br.com.petz.endpoint;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.constant.MessageErrorEnum;
import br.com.petz.entity.Client;
import br.com.petz.exception.ResourceNotFoundException;
import br.com.petz.service.ClientService;

@RestController
@RequestMapping("v1/clients")
public class ClientEndpoint {
	
	@Autowired
	private ClientService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClientById(@PathVariable("id") Long id){
		Client client = null;
		
		try {
			client = service.findById(id);
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(MessageErrorEnum.CLIENT_NOT_FOUND_BY_ID.getMessage() + id);
		}
				
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Client client){
		return new ResponseEntity<>(service.save(client), HttpStatus.CREATED);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Client client){
		return new ResponseEntity<>(service.save(client), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		try {
			service.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(MessageErrorEnum.CLIENT_NOT_FOUND_BY_ID.getMessage() + id);
		}		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}