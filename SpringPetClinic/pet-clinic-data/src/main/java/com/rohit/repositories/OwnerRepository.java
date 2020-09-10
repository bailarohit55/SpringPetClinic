package com.rohit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rohit.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);

}
