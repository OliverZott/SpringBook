package org.taco.data;

import org.taco.model.Order;

public interface OrderRepository {
	
	Order save(Order order);

}
