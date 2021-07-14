package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@SpringBootApplication
public class CursoAluraSpringDataJpaApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;

	private Boolean system = true;

	public CursoAluraSpringDataJpaApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CursoAluraSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual ação voce quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = scanner.nextInt();
			if (action == 1) {
				cargoService.inicial(scanner);
			} else {
				system =false;
			}
		}
	}
}
