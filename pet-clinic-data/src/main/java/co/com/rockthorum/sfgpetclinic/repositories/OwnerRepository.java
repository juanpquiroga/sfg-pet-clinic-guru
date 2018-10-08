package co.com.rockthorum.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.rockthorum.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
