package co.com.rockthorum.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Owner;
import co.com.rockthorum.sfgpetclinic.repositories.OwnerRepository;
import co.com.rockthorum.sfgpetclinic.repositories.PetRepository;
import co.com.rockthorum.sfgpetclinic.repositories.PetTypeRepository;
import co.com.rockthorum.sfgpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerJPAService implements OwnerService {
	
	private OwnerRepository ownerRepo;
	private PetRepository petRepository;
	private PetTypeRepository petTypeRepository;
	
	@Autowired
	public OwnerJPAService(OwnerRepository ownerRepo, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepo = ownerRepo;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById(Long id) {
		Optional<Owner> owner = ownerRepo.findById(id);
		return owner.orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepo.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		
		ownerRepo.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public void delete(Owner object) {
		ownerRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepo.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		Optional<Owner> owner = ownerRepo.findByLastName(lastname);
		return owner.orElse(null);
	}
	
}
