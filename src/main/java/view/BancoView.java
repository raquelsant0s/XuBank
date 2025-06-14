/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.BancoController;
import java.util.Scanner;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Transacao;

/**
 *
 * @author raque
 */
public class BancoView {
    private BancoController controller;
    private Scanner scanner;

    public BancoView() {
        controller = new BancoController();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\\n*** XuBank Menu ***");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Mostrar Conta");
            System.out.println("6 - Atualizar Contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarContaCorrente();
                    break;
                case 2:
                    criarContaPoupanca();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    mostrarConta();
                    break;
                case 6:
                    atualizarContas();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Obrigado por usar XuBank!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void criarContaCorrente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());

        Cliente cliente = new Cliente(nome, cpf);
        ContaCorrente conta = new ContaCorrente(numeroConta, cliente);
        controller.adicionarConta(conta);
        System.out.println("Conta Corrente criada com sucesso!");
    }

    private void criarContaPoupanca() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());

        Cliente cliente = new Cliente(nome, cpf);
        ContaPoupanca conta = new ContaPoupanca(numeroConta, cliente);
        controller.adicionarConta(conta);
        System.out.println("Conta Poupança criada com sucesso!");
    }

    private void depositar() {
        System.out.print("Número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor para depositar: ");
        double valor = Double.parseDouble(scanner.nextLine());

        if (controller.depositar(numeroConta, valor)) {
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void sacar() {
        System.out.print("Número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor para sacar: ");
        double valor = Double.parseDouble(scanner.nextLine());

        if (controller.sacar(numeroConta, valor)) {
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou conta não encontrada.");
        }
    }

    private void mostrarConta() {
        System.out.print("Número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());

        Conta conta = controller.buscarConta(numeroConta);
        if (conta != null) {
            System.out.println(conta);
            System.out.println("Histórico de transações:");
            for (Transacao Transacao : conta.getHistorico()) {
                boolean t = false;
                System.out.println(t);
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void atualizarContas() {
        controller.atualizarContas();
        System.out.println("Contas atualizadas com juros e tarifas.");
    }
}
