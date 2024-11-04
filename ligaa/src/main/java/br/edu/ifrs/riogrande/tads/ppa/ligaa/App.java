package br.edu.ifrs.riogrande.tads.ppa.ligaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		// Injeção de dependências (Dependency Injection)
		// Não da new no objeto, o Spring faz isso pra nos.
		// Tudo é um singleton no Spring.
	}
}