package co.com.rockthorum.sfgpetclinic.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.com.rockthorum.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Optional<Owner> findByLastName(String lastName);
}
