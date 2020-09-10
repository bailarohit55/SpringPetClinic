package com.rohit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rohit.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
