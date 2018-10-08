package co.com.rockthorum.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Specialty;
import co.com.rockthorum.sfgpetclinic.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty> implements SpecialtyService{

	@Override
	public Specialty save(Specialty object) {
		return this.save(object.getId(), object);
	}

}
