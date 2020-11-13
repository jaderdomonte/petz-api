package br.com.petz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petz.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{}
