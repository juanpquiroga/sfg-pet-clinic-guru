package co.com.rockthorum.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Pet;
import co.com.rockthorum.sfgpetclinic.repositories.PetRepository;
import co.com.rockthorum.sfgpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetJPAService implements PetService {
	
	private PetRepository petRepository;
	
	@Autowired
	public PetJPAService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> pet = petRepository.findById(id);
		return pet.orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
	
}
