package org.stcedd.othonaform;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> attributes = ((OAuth2AuthenticationToken) authentication).getPrincipal().getAttributes();
		String name = (String) attributes.get("name");
		String email = (String) attributes.get("email");

		model.addAttribute("order", orderService.load(email)
				.orElse(Order.builder().email(email).name(name).build()));

		return "order";
	}

	@GetMapping("/orders")
	public String getAllOrders(Model model) {
		model.addAttribute("orders", orderService.listAll());

		return "orders";
	}
}
