package org.stcedd.othonaform;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	@Transactional
	public Order save(Order order) {
		OrderEntity entity = (order.getId() != null) ? orderRepository.getReferenceById(order.getId()) : new OrderEntity();
		BeanUtils.copyProperties(order, entity);
		entity = orderRepository.save(entity);

		return convert(entity);
	}

	@Override
	public Optional<Order> load(String email) {
		return orderRepository.findFirstByEmail(email).map(this::convert);
	}

	@Override
	public Collection<Order> listAll() {
		return orderRepository.findAll().stream()
				.map(this::convert)
				.collect(Collectors.toList());
	}

	private Order convert(OrderEntity entity) {
		Order result = new Order();
		BeanUtils.copyProperties(entity, result);
		return result;
	}
}
