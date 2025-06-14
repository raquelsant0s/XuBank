/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;

import model.ContaPoupanca;

import model.Rentavel;

/**
 *
 * @author raque
 */
public class BancoController {
    private List<Conta> contas;

    public BancoController() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta c : contas) {
            if (c.getNumeroConta() == numeroConta) {
                return c;
            }
        }
        return null;
    }

    public boolean depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false;
    }

    public void atualizarContas() {
        for (Conta conta : contas) {
            conta.atualizarSaldo();
            if (conta instanceof ContaCorrente) {
                ((ContaCorrente) conta).cobrarTarifa();
            }
        }
    }

    public List<Conta> getContas() {
        return contas;
    }
}
