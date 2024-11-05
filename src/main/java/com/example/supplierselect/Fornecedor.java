package com.example.supplierselect;

public class Fornecedor {
    private String nome;
    private double preco;
    private int qualidade;
    private int prazoEntrega;
    private double reputacao;
    private int capacidade;
    private int pontuacao;

    public Fornecedor(String nome, double preco, int qualidade, int prazoEntrega, double reputacao, int capacidade) {
        this.nome = nome;
        this.preco = preco;
        this.qualidade = qualidade;
        this.prazoEntrega = prazoEntrega;
        this.reputacao = reputacao;
        this.capacidade = capacidade;
        this.pontuacao = 0;
    }

    // Getters e setters para cada campo
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQualidade() { return qualidade; }
    public int getPrazoEntrega() { return prazoEntrega; }
    public double getReputacao() { return reputacao; }
    public int getCapacidade() { return capacidade; }
    public int getPontuacao() { return pontuacao; }

    public void setPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }
}
