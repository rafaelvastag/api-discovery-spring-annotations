package io.github.rafaelvastag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalesApplicationStarter {

	@Autowired
	@Qualifier("applicationName")
	private String applicationName;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SalesApplicationStarter.class, args);
	}

	@GetMapping("/start")
	public String sendMessageToBrowser() {

		return applicationName;
	}

}
