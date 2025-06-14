/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author raque
 */
public class ContaPoupanca extends Conta implements Rentavel {
    
    private double taxaJuros;

    public ContaPoupanca(int numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
        this.taxaJuros = 0.005; // 0,5% ao mês por exemplo
    }

    @Override
    public void atualizarSaldo() {
        renderJuros();
    }

    @Override
    public void renderJuros() {
        double juros = saldo * taxaJuros;
        saldo += juros;
        historico.add(new Transacao(juros, "juros"));
    }
    
}
