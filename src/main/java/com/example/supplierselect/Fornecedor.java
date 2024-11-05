package com.example.supplierselect;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.kie.api.runtime.KieSession;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

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

    public static ArrayList<Fornecedor> carregarFornecedoresCSV(KieSession kSession) {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleciona o Arquivo CSV de Fornecedores.");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int res = fileChooser.showOpenDialog(null);

        String caminho = null;
        if(res == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            caminho = arquivoSelecionado.getAbsolutePath();
        } else {
            System.out.println("Arquivo de fornecedores não fornecido...");
            return  fornecedores;
        }
       

        try (CSVReader csvReader = new CSVReader(new FileReader(caminho))) {
            List<String[]> linhas = csvReader.readAll();
            linhas.remove(0);  // Remover cabeçalho do CSV

            for (String[] linha : linhas) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int qualidade = Integer.parseInt(linha[2]);
                int prazoEntrega = Integer.parseInt(linha[3]);
                double reputacao = Double.parseDouble(linha[4]);
                int capacidade = Integer.parseInt(linha[5]);

                Fornecedor fornecedor = new Fornecedor(nome, preco, qualidade, prazoEntrega, reputacao, capacidade);
                fornecedores.add(fornecedor);
                kSession.insert(fornecedor);  // Inserir no Drools para possível processamento
            }

            kSession.fireAllRules();
            System.out.println("Fornecedores importados com sucesso!");

        } catch (IOException | CsvException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return fornecedores;
    }
}
