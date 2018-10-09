package co.com.rockthorum.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Vet;
import co.com.rockthorum.sfgpetclinic.repositories.VetRepository;
import co.com.rockthorum.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetJPAService implements VetService {
	
	private VetRepository vetRepository;
	
	@Autowired
	public VetJPAService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		Optional<Vet> vet = vetRepository.findById(id);
		return vet.orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}
	
}
