package com.rohit.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rohit.model.Owner;
import com.rohit.model.Pet;
import com.rohit.model.PetType;
import com.rohit.model.Speciality;
import com.rohit.model.Vet;
import com.rohit.model.Visit;
import com.rohit.services.OwnerService;
import com.rohit.services.PetTypeService;
import com.rohit.services.SpecialityService;
import com.rohit.services.VetService;
import com.rohit.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, 
			SpecialityService specialitiesService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialitiesService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if(count == 0) {
			loadData();
		}
		
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality saveRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		radiology.setDescription("Surgery");
		Speciality saveSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		radiology.setDescription("Dentistry");
		Speciality saveDentistry = specialityService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Jordan");
		owner1.setAddress("123 Westons");
		owner1.setCity("Miami");
		owner1.setTelephone("1234567890");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosho");
		
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Robert");
		owner2.setLastName("Downey");
		owner2.setAddress("123 Westons");
		owner2.setCity("Miami");
		owner2.setTelephone("1234567890");
		
		Pet robsCat = new Pet();
		robsCat.setName("Billi");
		robsCat.setOwner(owner2);
		robsCat.setBirthDate(LocalDate.now());
		robsCat.setPetType(savedCatPetType);
		
		owner2.getPets().add(robsCat);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(robsCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Cat");
		
		visitService.save(catVisit);
		
		System.out.println("Loaded Owners....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Aman");
		vet1.setLastName("Saxena");
		vet1.getSpecialities().add(radiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Sanjay");
		vet2.setLastName("Arora");
		vet2.getSpecialities().add(surgery);
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets....");
	}

}
