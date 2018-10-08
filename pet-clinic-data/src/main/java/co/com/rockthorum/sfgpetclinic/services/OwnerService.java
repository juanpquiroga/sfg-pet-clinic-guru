package co.com.rockthorum.sfgpetclinic.services;

import co.com.rockthorum.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long> {
	Owner findByLastName(String lastname);
}
