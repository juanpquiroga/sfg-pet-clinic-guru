package co.com.rockthorum.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.com.rockthorum.sfgpetclinic.model.Owner;
import co.com.rockthorum.sfgpetclinic.model.Pet;
import co.com.rockthorum.sfgpetclinic.model.PetType;
import co.com.rockthorum.sfgpetclinic.model.Specialty;
import co.com.rockthorum.sfgpetclinic.model.Vet;
import co.com.rockthorum.sfgpetclinic.services.OwnerService;
import co.com.rockthorum.sfgpetclinic.services.PetService;
import co.com.rockthorum.sfgpetclinic.services.PetTypeService;
import co.com.rockthorum.sfgpetclinic.services.SpecialtyService;
import co.com.rockthorum.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		
		if (count == 0 ) {
			loadData();
		}
	}

	private void loadData() {
		initSpecialties();
		initPetTypes();
		initOwners();
		initVets();
		//initPets();
	}

	private void initSpecialties() {
		Specialty spe1 = new Specialty();
		spe1.setDescription("radiology");
		specialtyService.save(spe1);
		
		Specialty spe2 = new Specialty();
		spe2.setDescription("surgery");
		specialtyService.save(spe2);
		
		Specialty spe3 = new Specialty();
		spe3.setDescription("dentistry");
		specialtyService.save(spe3);
	}

	private void initPetTypes() {
		PetType petType1 = new PetType();
		petType1.setName("dog");
		petTypeService.save(petType1);
		
		PetType petType2 = new PetType();
		petType2.setName("cat");
		petTypeService.save(petType2);
		
		PetType petType3 = new PetType();
		petType3.setName("hamster");
		petTypeService.save(petType3);
	}

	private void initVets() {
		Vet vet1 = new Vet();
		vet1.setFirstName("Ramiro");
		vet1.setLastName("Ortiz");
		
		Specialty spe1 = specialtyService.findById(1L);
		vet1.getSpecialties().add(spe1);
	
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Luisa");
		vet2.setLastName("Gomez");
		Specialty spe2 = specialtyService.findById(2L);
		vet2.getSpecialties().add(spe2);
		vetService.save(vet2);
		
		System.out.println("Loaded Vets....");
	}

	private void initOwners() {
		Owner owner1 = new Owner();
		owner1.setFirstName("Juan");
		owner1.setLastName("Quiroga");
		owner1.setAddress("Calle falsa 123");
		owner1.setCity("Bogota");
		owner1.setTelephone("2121212");
		
		Pet pet1 = new Pet();
		PetType petType1 = petTypeService.findById(1L);
		pet1.setName("Pirañin");
		pet1.setPetType(petType1);
		pet1.setBirthDate(LocalDate.of(2010, 1, 10));
		owner1.getPets().add(pet1);

		Pet pet2 = new Pet();
		pet2.setName("Tinga");
		PetType petType2 = petTypeService.findById(2L);
		pet2.setPetType(petType2);
		pet2.setBirthDate(LocalDate.of(2013, 3, 10));
		
		owner1.getPets().add(pet2);
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Diego");
		owner2.setLastName("Ramirez");
		owner2.setAddress("Calle falsa 234");
		owner2.setCity("Cali");
		owner2.setTelephone("3131313");
		
		Pet pet3 = new Pet();
		pet3.setName("Hogan");
		PetType petType3 = petTypeService.findById(3L);
		pet1.setPetType(petType3);
		pet1.setBirthDate(LocalDate.of(2017, 5, 20));
		
		owner2.getPets().add(pet3);
		ownerService.save(owner2);

		Owner owner3 = new Owner();
		owner3.setFirstName("Roberto");
		owner3.setLastName("Arias");
		owner3.setAddress("Calle falsa 345");
		owner3.setCity("Medellin");
		owner3.setTelephone("4141414");
		
		Pet pet4 = new Pet();
		pet4.setName("Red");
		pet4.setPetType(petType1);
		pet4.setBirthDate(LocalDate.of(2014, 9, 1));
		owner3.getPets().add(pet4);
		
		ownerService.save(owner3);
		
		System.out.println("Loaded Owners....");
	}
	
	private void initPets() {
		Pet pet1 = new Pet();
		
		PetType petType1 = new PetType();
		petType1.setName("Perro");
		pet1.setPetType(petType1);
		
		pet1.setBirthDate(LocalDate.of(2010, 1, 10));
		Owner owner1 = ownerService.findById(1L);
		pet1.setOwner(owner1);
		
		petService.save(pet1);
		
		System.out.println("Loaded Pets....");
	}

}
