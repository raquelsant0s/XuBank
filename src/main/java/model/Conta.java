/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author raque
 */
public abstract class Conta {
    
    protected int numeroConta;
    protected Cliente cliente;
    protected double saldo;
    protected List<Transacao> historico;

    public Conta(int numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0;
        this.historico = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getHistorico() {
        return historico;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add(new Transacao(valor, "deposito"));
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historico.add(new Transacao(valor, "saque"));
            return true;
        }
        return false;
    }

    public abstract void atualizarSaldo();

    @Override
    public String toString() {
        return "Conta " + numeroConta + " - Cliente: " + cliente.getNome() + " - Saldo: R$" + String.format("%.2f", saldo);
    }
    
}
