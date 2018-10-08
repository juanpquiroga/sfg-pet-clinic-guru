package co.com.rockthorum.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.PetType;
import co.com.rockthorum.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService{

	@Override
	public PetType save(PetType object) {
		return this.save(object.getId(),object);
	}
	
}
