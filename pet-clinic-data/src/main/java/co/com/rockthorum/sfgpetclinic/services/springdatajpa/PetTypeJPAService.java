package co.com.rockthorum.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.PetType;
import co.com.rockthorum.sfgpetclinic.repositories.PetTypeRepository;
import co.com.rockthorum.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeJPAService implements PetTypeService {
	
	private PetTypeRepository petTypeRepository;
	
	@Autowired
	public PetTypeJPAService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		Optional<PetType> petType = petTypeRepository.findById(id);
		return petType.orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}
	
}
