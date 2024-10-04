package TrabHospital;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class SistemadeConsulta {
    private ArrayList<Paciente> pacientes;

    public SistemadeConsulta() {
        pacientes = new ArrayList<>();
    }
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente adicionado: " + paciente.getNome());
    }

    public Paciente pesquisarPacientePorNome(String nome) {
        for (Paciente p : pacientes) {
            if (p.getNome().equalsIgnoreCase(nome) && p.isAtivo()) {
                return p;
            }
        }
        return null;
    }
    public void alterarPaciente(String nome) {
        Paciente paciente = pesquisarPacientePorNome(nome);
        if (paciente != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Alterando dados do paciente: " + nome);
            System.out.print("Novo nome: ");
            paciente.setNome(scanner.nextLine());
            System.out.println("Dados alterados com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
    public void realizarAtendimento(String nome, Atendimento atendimento) {
        Paciente paciente = pesquisarPacientePorNome(nome);
        if (paciente != null) {
            paciente.adicionarConsulta(atendimento);
            System.out.println("Atendimento adicionado ao paciente: " + nome);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
    public void listarPacientes() {
        for (Paciente p : pacientes) {
            if (p.isAtivo()) {
                System.out.println(p);
            }
        }
    }
    public void mostrarPaciente(String nome) {
        Paciente paciente = pesquisarPacientePorNome(nome);
        if (paciente != null) {
            System.out.println(paciente);
            ArrayList<Atendimento> atendimentos = paciente.getAtendimentos();
            for (int i = 0; i < atendimentos.size(); i += 5) {
                for (int j = i; j < i + 5 && j < atendimentos.size(); j++) {
                    System.out.println(atendimentos.get(j));
                }
                if (i + 5 < atendimentos.size()) {
                    System.out.println("Pressione Enter para continuar...");
                    new Scanner(System.in).nextLine();
                }
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
    public void removerPaciente(String nome) {
        Paciente paciente = pesquisarPacientePorNome(nome);
        if (paciente != null) {
            paciente.setAtivo(false);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
    public static void main(String[] args) {
        SistemadeConsulta sistema = new SistemadeConsulta();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Consulta Médica ---");
            System.out.println("1. Incluir paciente");
            System.out.println("2. Alterar paciente");
            System.out.println("3. Realizar atendimento");
            System.out.println("4. Listar pacientes");
            System.out.println("5. Mostrar paciente");
            System.out.println("6. Apagar paciente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sobrenome do paciente: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("Data de nascimento (yyyy-mm-dd): ");
                    String dataNasc = scanner.nextLine();
                    LocalDate dataNascimento = LocalDate.parse(dataNasc);

                    Paciente novoPaciente = new Paciente(nome, sobrenome, dataNascimento);
                    sistema.adicionarPaciente(novoPaciente);
                    break;

                case 2:
                    System.out.print("Nome do paciente para alterar: ");
                    String nomeAlterar = scanner.nextLine();
                    sistema.alterarPaciente(nomeAlterar);
                    break;

                case 3:
                    System.out.print("Nome do paciente para atendimento: ");
                    String nomeAtendimento = scanner.nextLine();
                    System.out.print("Descrição do atendimento: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data do atendimento (yyyy-mm-dd): ");
                    String dataAtendimento = scanner.nextLine();
                    LocalDate dataAtend = LocalDate.parse(dataAtendimento);

                    Atendimento atendimento = new Atendimento(dataAtend, descricao);
                    sistema.realizarAtendimento(nomeAtendimento, atendimento);
                    break;

                case 4:
                    System.out.println("\n--- Lista de Pacientes Ativos ---");
                    sistema.listarPacientes();
                    break;

                case 5:
                    System.out.print("Nome do paciente para mostrar: ");
                    String nomeMostrar = scanner.nextLine();
                    sistema.mostrarPaciente(nomeMostrar);
                    break;

                case 6:
                    System.out.print("Nome do paciente para remover: ");
                    String nomeRemover = scanner.nextLine();
                    sistema.removerPaciente(nomeRemover);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}