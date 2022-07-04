package com.jefponte.springexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jefponte.springexample.model.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{
    
}
