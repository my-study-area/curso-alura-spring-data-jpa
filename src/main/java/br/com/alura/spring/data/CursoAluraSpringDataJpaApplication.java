package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CursoAluraSpringDataJpaApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private Boolean system = true;

	public CursoAluraSpringDataJpaApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
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
			System.out.println("2 - Funcionário");

			int action = scanner.nextInt();
			if (action == 1) {
				cargoService.inicial(scanner);
			} else if (action == 2) {
				funcionarioService.inicial(scanner);
			}
			else {
				system =false;
			}
		}
	}
}
