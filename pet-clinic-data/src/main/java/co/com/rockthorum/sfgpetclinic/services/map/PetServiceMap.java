package co.com.rockthorum.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Pet;
import co.com.rockthorum.sfgpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService{

	@Override
	public Pet save(Pet object) {
		return this.save(object.getId(),object);
	}

}
