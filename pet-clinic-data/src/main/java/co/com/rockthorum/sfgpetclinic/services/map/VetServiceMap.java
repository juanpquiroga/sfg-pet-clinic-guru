package co.com.rockthorum.sfgpetclinic.services.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Vet;
import co.com.rockthorum.sfgpetclinic.services.SpecialtyService;
import co.com.rockthorum.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

	private SpecialtyService specialityService;
	
	@Autowired
	public VetServiceMap(SpecialtyService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		Vet savedVet = null;
		if ( object != null ) { 
			if ( object.getSpecialties() != null ) {
				object.getSpecialties().forEach(spe->{
					if ( spe.getId() != null ) {
						specialityService.save(spe);
					} 
				});
			}
			
			savedVet = super.save(object.getId(), object);
			
		} 
		return savedVet;
	}

}
