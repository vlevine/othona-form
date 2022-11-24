package org.stcedd.othonaform;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@PostMapping("/order")
	public String save(@ModelAttribute Order order, Model model) {
		model.addAttribute("order", orderService.save(order));

		return "order";
	}

	@GetMapping("/order")
	public String getOrder(Model model) {
		//SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("order", orderService.load("poppa@home")
				.orElse(Order.builder().email("poppa@home").build()));

		return "order";
	}

	@GetMapping("/orders")
	public String getAllOrders(Model model) {
		model.addAttribute("orders", orderService.listAll());

		return "orders";
	}
}
