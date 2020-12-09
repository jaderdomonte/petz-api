package br.com.petz.endpoint;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "clients")
@RestController
@RequestMapping("v1/clients")
public class ClientEndpoint {
	
	@Autowired
	private ClientService service;

	@ApiOperation(value = "Listar todos os Clientes e seus Pets", response = Client[].class, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retornar Cliente e seus Pets por ID do Cliente.", response = Client.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getClientById(@PathVariable("id") Long id){
		Client client = null;
		
		try {
			client = service.findById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(MessageErrorEnum.CLIENT_NOT_FOUND_BY_ID.getMessage() + id);
		}
				
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Salvar Cliente e seus Pets.", response = Client.class, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Client client){
		return new ResponseEntity<>(service.save(client), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualizar Cliente.", response = Client.class)
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Client client){
		try {
			return new ResponseEntity<>(service.save(client), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(MessageErrorEnum.CLIENT_NOT_FOUND_BY_ID.getMessage() + client.getId());
		}
	}
	
	@ApiOperation(value = "Apagar Cliente e seus Pets.", response = Client.class, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		try {
			service.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(MessageErrorEnum.CLIENT_NOT_FOUND_BY_ID.getMessage() + id);
		}		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}