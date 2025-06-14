/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author raque
 */
public class ContaCorrente extends Conta {
    
   private double tarifaMensal;

    public ContaCorrente(int numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
        this.tarifaMensal = 10.0; // Exemplo de tarifa fixa
    }

    @Override
    public void atualizarSaldo() {
        // Pode implementar algum rendimento ou taxa se desejar
    }

    public double calcularTributo() {
        return tarifaMensal;
    }

    public boolean cobrarTarifa() {
        if (saldo >= tarifaMensal) {
            saldo -= tarifaMensal;
            historico.add(new Transacao(tarifaMensal, "tarifa"));
            return true;
        }
        return false;
    }

    
}
