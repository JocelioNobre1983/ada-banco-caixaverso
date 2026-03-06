# 💰 Sistema bancário - CaixaVerso - Curso

Sistema de processamento de transações bancárias que lê operações a partir de um arquivo CSV, agrupa por titular e calcula o saldo final de cada conta.

## 🚀 Funcionalidades

- Leitura e parse de arquivos CSV com transações bancárias
- Remoção de transações duplicadas
- Agrupamento de operações por titular
- Ordenação cronológica das transações
- Cálculo de saldo final (depósitos e saques)

## 🛠️ Tecnologias

- Java 17+

## 📁 Estrutura

```
src/
└── main/
    ├── java/com/ada/caixaverso/
    │   ├── model/       # Transacoes.java
    │   ├── reader/      # CsvReader.java
    │   ├── service/     # Processador.java
    │   └── Program.java
    └── resources/
        └── operacoes_100.csv
```

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/caixaverso.git
```

2. Compile e execute:
```bash
mvn compile exec:java -Dexec.mainClass="Program"
```

## 📄 Formato do CSV

```
agencia,conta,banco,titular,operacao,datahora,valor
0001,12345-6,Banco X,João Silva,DEPOSITO,2024-01-15T10:30:00,1500.00
```

## 📊 Exemplo de saída

```
═══ Titular: JOÃO SILVA ═══
[2024-01-15T10:30] DEPOSITO   R$   1500,00 | Conta: 0001-12345-6 (Banco X)
[2024-01-16T14:00] SAQUE      R$    200,00 | Conta: 0001-12345-6 (Banco X)
Saldo final: R$ 1300,00
```
