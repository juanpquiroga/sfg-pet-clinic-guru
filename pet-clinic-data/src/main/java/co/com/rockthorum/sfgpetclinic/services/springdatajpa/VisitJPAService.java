package co.com.rockthorum.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Visit;
import co.com.rockthorum.sfgpetclinic.repositories.VisitRepository;
import co.com.rockthorum.sfgpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitJPAService implements VisitService {
	
	private VisitRepository visitRepository;
	
	@Autowired
	public VisitJPAService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id) {
		Optional<Visit> visit = visitRepository.findById(id);
		return visit.orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
	
}
