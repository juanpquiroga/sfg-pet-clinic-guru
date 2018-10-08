package co.com.rockthorum.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.rockthorum.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
