package com.ada.caixaverso.service;

import com.ada.caixaverso.model.Transacoes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Processardor {

    public Map<String, List<Transacoes>> processar(List<Transacoes> transacoes) {
        return transacoes.stream()
                .distinct()
                .sorted(Comparator.comparing(Transacoes::getDatahora))
                .collect(Collectors.groupingBy(Transacoes::getTitular));
    }

    public double calcularSaldo(List<Transacoes> operacoes) {
        double saldo = 0.0;
        for (Transacoes t : operacoes) {
            if (t.getOperacao().equals("DEPOSITO")) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }

}
