package org.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.taco.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long>{

    List<Order> findByZip(String Zip);

/*
	Order save(Order order);
*/

}
