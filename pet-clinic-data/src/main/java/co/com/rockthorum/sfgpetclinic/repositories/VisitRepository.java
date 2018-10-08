package co.com.rockthorum.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.rockthorum.sfgpetclinic.model.Visit;

/**
 * Repositorio para la clase Visit
 * @author Juan Pablo Quiroga
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
