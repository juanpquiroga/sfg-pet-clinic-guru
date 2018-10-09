package co.com.rockthorum.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Specialty;
import co.com.rockthorum.sfgpetclinic.repositories.SpecialtyRepository;
import co.com.rockthorum.sfgpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtyJPAService implements SpecialtyService {
	
	private SpecialtyRepository specialtyRepository;
	
	@Autowired
	public SpecialtyJPAService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Specialty findById(Long id) {
		Optional<Specialty> specialty = specialtyRepository.findById(id);
		return specialty.orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<>();
		
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}
	
}
