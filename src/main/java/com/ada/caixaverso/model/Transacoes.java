package com.ada.caixaverso.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transacoes {
    private String agencia;
    private String conta;
    private String banco;
    private String titular;
    private String operacao; //"SAQUE" OU "DEPÓSITO"
    private double valor;
    private String operador;
    private LocalDateTime datahora;

    //CONSTRUTORES
    public Transacoes() {
    }

    public Transacoes(String agencia, String conta, String banco, String titular,
                     String operacao, double valor, String operador,
                      LocalDateTime datahora) {

        this.agencia = agencia;
        this.conta = conta.trim();
        this.banco = banco;
        this.titular = titular.toUpperCase().trim();
        this.operacao = operacao.toUpperCase().trim();
        this.valor = valor;
        this.operador = operador;
        this.datahora = datahora;
    }

    //GETTERS
    public String getAgencia() { return agencia; }

    public String getConta() { return conta; }

    public String getBanco() { return banco; }

    public String getTitular() { return titular; }

    public String getOperacao() { return operacao; }

    public double getValor() { return valor; }

    public String getOperador() { return operador; }

    public LocalDateTime getDatahora() { return datahora; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transacoes that = (Transacoes) o;
        return Double.compare(valor, that.valor) == 0
                && Objects.equals(operacao, that.operacao)
                && Objects.equals(operador, that.operador)
                && Objects.equals(datahora, that.datahora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operacao, valor, operador, datahora);
    }

    @Override
    public String toString(){
        return String.format("[%s] %-10s R$ %10.2f | Operador: %-15s | Conta: %s-%s (%s)",
                datahora, operacao, valor, operador, agencia, conta, banco);
    }
}
