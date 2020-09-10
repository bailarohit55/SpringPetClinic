package com.rohit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rohit.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
