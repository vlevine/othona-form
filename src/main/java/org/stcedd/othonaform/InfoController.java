package org.stcedd.othonaform;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class InfoController {

	@GetMapping("/info")
	public Info getInfo(OAuth2AuthenticationToken authentication) {
		LOG.debug("Authentication {}", authentication);
		return new Info()
				.setPrincipal(authentication.getPrincipal().getAttributes());
	}

	@Data
	@Accessors(chain = true)
	private static class Info {
		private Map<String, Object> principal;
	}
}