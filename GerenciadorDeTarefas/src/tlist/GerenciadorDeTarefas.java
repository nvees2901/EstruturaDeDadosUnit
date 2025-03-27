package tlist;

import java.util.Scanner;

public class GerenciadorDeTarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTarefas lista = new ListaTarefas();
        int opcao;
        
        do {
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Editar Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Listar Tarefas");
            System.out.println("5. Buscar Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    lista.adicionarTarefa(descricao);
                    break;
                case 2:
                    System.out.print("ID da tarefa a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDescricao = scanner.nextLine();
                    lista.editarTarefa(idEditar, novaDescricao);
                    break;
                case 3:
                    System.out.print("ID da tarefa a remover: ");
                    int idRemover = scanner.nextInt();
                    lista.removerTarefa(idRemover);
                    break;
                case 4:
                    lista.listarTarefas();
                    break;
                case 5:
                    System.out.print("ID da tarefa a buscar: ");
                    int idBuscar = scanner.nextInt();
                    lista.buscarTarefa(idBuscar);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
