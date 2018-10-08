package co.com.rockthorum.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import co.com.rockthorum.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity> {
	protected Map<Long,T> data = new HashMap<>();
	
	public Set<T> findAll() {
		return new HashSet<>(data.values());
	}
	
	public T findById(Long id) {
		if ( data.containsKey(id) ) {
			return data.get(id);
		}
		return null;
	}
	
	public T save( Long id, T object) {
		
		if ( object != null ) {
			if ( object.getId() == null) {
				object.setId(getNextId());
			}
			if ( !data.containsKey(object.getId()) ) {
				data.put(object.getId(), object);
			}

		} else {
			throw new RuntimeException("Object cannot be null");
		}
		
		return object;
	}
	
	public void delete(T object) {
		data.entrySet().removeIf(entry->entry.getValue().equals(object));
	}
	
	public void deleteById(Long id) {
		if ( data.containsKey(id)) {
			data.remove(id);
		}
	}
	
	public Long getNextId() {
		if ( data.keySet().size() == 0 ) {
			return 1L;
		} else {
			return Collections.max(data.keySet())+1;
		}
		/*Long max = 0;
		for ( Long key: data.keySet()) {
			if ( key > max ) {
				max = key;
			}
		}
		return max;*/
	}
}
