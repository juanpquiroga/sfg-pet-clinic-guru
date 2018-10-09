package co.com.rockthorum.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Visit;
import co.com.rockthorum.sfgpetclinic.services.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {

	public VisitServiceMap() {
	}

	@Override
	public Visit save(Visit object) {
		if ( object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null ||
				object.getPet().getOwner().getId() == null ) {
			throw new RuntimeException("Invalid visit");
		}
		Visit savedVisit = super.save(object.getId(), object);
		return savedVisit;
	}

}
