package com.ada.caixaverso.reader;

import com.ada.caixaverso.model.Transacoes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public List<Transacoes> ler(String caminhoCsv) throws IOException {
        List<Transacoes> transacoes = new ArrayList<>();
        int linhaAtual = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminhoCsv), StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                linhaAtual++;
                if (linhaAtual == 1 || linha.isBlank()) continue;

                try {
                    transacoes.add(parseLinha(linha, linhaAtual));
                } catch (Exception ignored) {}
            }
        }

        return transacoes;
    }

    private Transacoes parseLinha(String linha, int numLinha) {
        String[] campos = linha.split(",", -1);

        if (campos.length < 7) {
            throw new IllegalArgumentException("Campos insuficientes na linha " + numLinha);
        }

        String agencia        = campos[0].trim();
        String conta          = campos[1].trim();
        String banco          = campos[2].trim();
        String titular        = campos[3].trim().toUpperCase();
        String operacao       = campos[4].trim().toUpperCase();
        LocalDateTime dataHora = LocalDateTime.parse(campos[5].trim(), FORMATO);
        double valor          = Double.parseDouble(campos[6].trim().replace(",", "."));

        return new Transacoes(agencia, conta, banco, titular, operacao, valor, "N/A", dataHora);
    }
}