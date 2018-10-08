package co.com.rockthorum.sfgpetclinic.services.map;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.rockthorum.sfgpetclinic.model.Owner;
import co.com.rockthorum.sfgpetclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {
	private PetServiceMap petService;
	private PetTypeServiceMap petTypeService;

	@Autowired
	public OwnerServiceMap(PetServiceMap petService, PetTypeServiceMap petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner save(Owner object) {
		Owner savedOwner = null;
		if ( object != null ) { 
			if ( object.getPets() != null ) {
				object.getPets().forEach(pet->{
					if ( pet.getPetType() != null ) {
						if ( pet.getPetType().getId() != null ) {
							petTypeService.save(pet.getPetType());
						}
					} else {
						new RuntimeException("Pet type is required");
					}
					if ( pet.getId() != null ) {
						petService.save(pet);
					} 
				});
			}
			
			savedOwner = super.save(object.getId(), object);
			
		} 
		return savedOwner;
		
	}

	@Override
	public Owner findByLastName(String lastname) {
		List<Entry<Long,Owner>> salida = this.data.entrySet().stream()
				.filter(entry -> entry.getValue().getLastName().equals(lastname)).collect(Collectors.toList());
		if( salida.size() > 0 ) { 
			return salida.get(0).getValue();
		} else {
			return null;
		}
	}

}
