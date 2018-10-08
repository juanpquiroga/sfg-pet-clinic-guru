package co.com.rockthorum.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Vet extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="VET_SPECIALTY",
			joinColumns=@JoinColumn(name="vet_id"),
			inverseJoinColumns=@JoinColumn(name="specialty_id"))
	private Set<Specialty> specialties = new HashSet<>();

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}
