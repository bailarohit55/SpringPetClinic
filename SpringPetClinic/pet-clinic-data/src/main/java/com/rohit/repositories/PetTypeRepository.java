package com.rohit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rohit.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
