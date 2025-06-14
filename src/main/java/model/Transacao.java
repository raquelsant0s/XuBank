/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author raque
 */
public class Transacao {
    
    private LocalDateTime dataHora;
    private double valor;
    private String tipo; // "deposito" ou "saque"

    public Transacao(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now();
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo + ": R$" + String.format("%.2f", valor) + " em " + dataHora;
    }
    
    
}
