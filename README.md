[![Build Status](https://travis-ci.org/jaderdomonte/petz-api.svg?branch=master)](https://travis-ci.org/jaderdomonte/petz-api)

# petz-api
API de Clientes para o processo seletivo da Petz.

Esta API dispõe dos 5 serviços a seguir:

Listar todos os Clientes e seus Pets.
- Salvar Cliente e seus Pets.
- Atualizar Cliente.
- Apagar Cliente e seus Pets.
- Retornar Cliente e seus Pets por ID do Cliente.
- A documentação completa dos serviços estará disponível em https://petz-api-app.herokuapp.com/swagger-ui.html e o swagger em https://petz-api-app.herokuapp.com/v2/api-docs

Abaixo seguem as ferramentas utilizadas no projeto:

- Apache Maven 3.6.0
- Project Lombok 1.18.16
- Spring Boot 2.3.0
- Spring Data JPA 2.3
- Spring MVC 2.3.0
- Hibernate 5.4.15
- Swagger2 2.9.2

A API está hospedada no endereço https://petz-api-app.herokuapp.com. Seguem instruções para consumir a API:
1. Listar todos os Clientes e seus Pets (Método GET): 
 	https://petz-api-app.herokuapp.com/v1/clients
2. Salvar Cliente e seus Pets (Método POST): 
	https://petz-api-app.herokuapp.com/v1/clients
3. Atualizar Cliente (Método PUT): 
	https://petz-api-app.herokuapp.com/v1/clients
4. Apagar Cliente e seus Pets (Método DELETE): 
	https://petz-api-app.herokuapp.com/v1/clients/{id} 
5. Retornar Cliente e seus Pets por ID do Cliente (Método GET): 
	https://petz-api-app.herokuapp.com/v1/clients/{id}
