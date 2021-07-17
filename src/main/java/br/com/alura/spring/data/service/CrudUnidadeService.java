package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeService {
    private Boolean system;
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;
    private final UnidadeRepository unidadeRepository;

    public CrudUnidadeService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository, UnidadeRepository unidadeRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
        this.unidadeRepository = unidadeRepository;
    }

    public void inicial(Scanner scanner) {
        system = true;
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
        System.out.println("Descrição da unidade:");
        String descricao = scanner.next();
        
        System.out.println("Endereço da Unidade:");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho(descricao, endereco);
        unidadeRepository.save(unidadeTrabalho);
        System.out.println("Unidade de Trabalho Salva");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Id da Unidade de Trabalho:");
        Integer id = scanner.nextInt();

        System.out.println("Descrição da da Unidade de Trabalho:");
        String descricao = scanner.next();

        System.out.println("Endereço da da Unidade de Trabalho:");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho(id, descricao, endereco);
        unidadeRepository.save(unidadeTrabalho);
        System.out.println("Unidade de Trabalho atualizada");
    }

    private void visualizar() {
        Iterable<UnidadeTrabalho> unidades = unidadeRepository.findAll();
        unidades.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        unidadeRepository.deleteById(id);
        System.out.println("Unidade de Trabalho Deletada");
    }

}
