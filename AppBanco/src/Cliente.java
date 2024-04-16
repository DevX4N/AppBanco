import java.util.Scanner;

public class Cliente {
    public String nome;
    public String sobrenome;
    public String cpf;
    public double saldo;
    private Scanner scanner;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public void consultaSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor para depósito inválido, R$" + valor + " não permitido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido");
        }
    }

    public void interacaoUsuario() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nO que você deseja?");
            System.out.println("[1] - Consultar saldo");
            System.out.println("[2] - Depositar");
            System.out.println("[3] - Sacar");
            System.out.println("[4] - Encerrar aplicação\n");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    consultaSaldo();
                    break;

                case 2:
                    System.out.println("Informe o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    depositar(valorDeposito);
                    break;

                case 3:
                    System.out.println("Informe o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    sacar(valorSaque);
                    break;

                case 4:
                    continuar = false;
                    System.out.println("Encerrando a aplicação, até breve");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Nome", "Sobrenome", "123.456.789-00");
        cliente.interacaoUsuario();
    }
}
