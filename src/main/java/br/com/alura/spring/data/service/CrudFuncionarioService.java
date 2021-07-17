package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    private Boolean system = true;
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação voce quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    this.salvar(scanner);
                    break;
                case 2:
                    this.atualizar(scanner);
                    break;
                case 3:
                    this.visualizar();
                    break;
                case 4:
                    this.deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Nome do funcionário:");
        String nome = scanner.next();
        
        System.out.println("CPF do funcionário:");
        String cpf = scanner.next();

        System.out.println("Salário do funcionário:");
        Double salario = scanner.nextDouble();

        System.out.println("Id do cargo:");
        Integer idCargo = scanner.nextInt();

        Optional<Cargo> cargo = cargoRepository.findById(idCargo);
        Funcionario funcionario = new Funcionario(nome, cpf, salario, cargo.get());
        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id do funcionário:");
        int id = scanner.nextInt();

        System.out.println("Nome do funcionário:");
        String nome = scanner.next();

        System.out.println("CPF do funcionário:");
        String cpf = scanner.next();

        System.out.println("Salário do funcionário:");
        Double salario = scanner.nextDouble();

        System.out.println("Id do Cargo:");
        Integer idCargo = scanner.nextInt();

        Optional<Cargo> cargo = cargoRepository.findById(idCargo);

        Funcionario funcionario = new Funcionario(id, nome, cpf, salario, cargo.get());
        funcionarioRepository.save(funcionario);
        System.out.println("Atualizado");
    }

    private void visualizar() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
