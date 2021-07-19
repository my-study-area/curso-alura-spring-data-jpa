package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system;
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public void inicial(Scanner scanner) {
        system = true;
        while (system) {
            System.out.println("Qual ação voce quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar por nome");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    this.buscarFuncionariosPorNome(scanner);
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
}
