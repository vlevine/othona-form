package org.stcedd.othonaform;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {
	Order save(Order order);

	Optional<Order> load(String email);

	Collection<Order> listAll();
}
