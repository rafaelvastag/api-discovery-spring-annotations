package io.github.rafaelvastag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rafaelvastag.annotations.Development;
import io.github.rafaelvastag.annotations.Gato;
import io.github.rafaelvastag.interfaces.Animal;

@SpringBootApplication
@RestController
public class SalesApplicationStarter {

	@Autowired
	@Qualifier("applicationName")
	private String applicationName;

	@Value("${application.name}")
	private String welcomeText;

	@Autowired
	@Gato
	private Animal animal;

	@Bean(name = "executarBarulhoAnimal")
	public CommandLineRunner executar() {
		return args -> {
			this.animal.fazerBarulho();
		};
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SalesApplicationStarter.class, args);
	}

	@GetMapping("/start")
	public String sendMessageToBrowser() {

		return applicationName + " " + welcomeText;
	}

}
