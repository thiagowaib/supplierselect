package com.example.supplierselect.ui;

import java.util.List;

import com.example.supplierselect.Fornecedor;

public class ListaDeFornecedores {
    
    public static void exibir(List<Fornecedor> fornecedores) {
        System.out.println("\n=================================================================================================================");
        System.out.printf("| %-12s | %-8s | %-10s | %-13s | %-10s | %-10s | %-15s |%n",
        "Nome", "Preco", "Qualidade", "Prazo Entrega", "Reputacao", "Capacidade", "Pontuacao Final");
        System.out.println("=================================================================================================================");
        
        for (Fornecedor f : fornecedores) {
            System.out.printf("| %-12s | %-8.2f | %-10d | %-13d | %-10.1f | %-10d | %-15d |%n",
                f.getNome(), f.getPreco(), f.getQualidade(), f.getPrazoEntrega(),
                f.getReputacao(), f.getCapacidade(), f.getPontuacao());
        }
        System.out.println("=================================================================================================================\n");
    }
}