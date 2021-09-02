package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system;
    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public void inicial(Scanner scanner) {
        system = true;
        while (system) {
            System.out.println("Qual ação voce quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar por nome");
            System.out.println("2 - Buscar funcionário por nome, data de contratação e salário maior");
            System.out.println("3 - Buscar funcionário por data de contratação");
            System.out.println("4 - Buscar funcionário salário");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    this.buscarFuncionariosPorNome(scanner);
                    break;
                case 2:
                    this.buscarFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    this.buscarFuncionarioPorDataContratacao(scanner);
                    break;
                case 4:
                    this.buscarFuncionarioSalario();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscarFuncionariosPorNome(Scanner scanner) {
        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.next();
        List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
        funcionarios.forEach(System.out::println);
    }

    private void buscarFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();

        System.out.println("Qual data de contratação deseja pesquisar?");
        String data = scanner.next();
        LocalDate dataLocal = LocalDate.parse(data, formatter);

        System.out.println("Qual salário deseja pesquisar?");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarios = funcionarioRepository.findByNomeSalarioMaiorDataContratacao(nome, salario, dataLocal);
        funcionarios.forEach(System.out::println);
    }

    private void buscarFuncionarioPorDataContratacao(Scanner scanner) {
        System.out.println("Qual data de contratação deseja pesquisar?");
        String data = scanner.next();
        LocalDate dataLocal = LocalDate.parse(data, formatter);
        List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(dataLocal);
        funcionarios.forEach(System.out::println);
    }

    private void buscarFuncionarioSalario() {
        List<FuncionarioProjecao> funcionariosSalario = funcionarioRepository.findFuncionarioSalario();
        funcionariosSalario.forEach( f -> {
            System.out.print("Funcionario: ");
            System.out.print("id: " + f.getId());
            System.out.print(" | nome: " + f.getNome());
            System.out.println(" | salário: " + f.getSalario());
        });
    }
}
