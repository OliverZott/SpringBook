package org.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.taco.model.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
	
/*
	Taco save(Taco design);
*/

}
