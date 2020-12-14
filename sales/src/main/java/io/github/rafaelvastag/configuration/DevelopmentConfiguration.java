package io.github.rafaelvastag.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import io.github.rafaelvastag.annotations.Development;

@Development
public class DevelopmentConfiguration {
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
		};
	}

}
