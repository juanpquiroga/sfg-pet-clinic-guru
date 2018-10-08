package co.com.rockthorum.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.rockthorum.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
