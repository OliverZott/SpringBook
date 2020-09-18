package org.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.taco.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
	
/*
	Order save(Order order);
*/

}
