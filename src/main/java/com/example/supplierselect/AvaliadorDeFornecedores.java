package com.example.supplierselect;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class AvaliadorDeFornecedores {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("ksession-rules");

        // Criando fornecedores com dados simulados
        Fornecedor fornecedorA = new Fornecedor("Fornecedor A", 950, 9, 3, 4.5, 600);
        Fornecedor fornecedorB = new Fornecedor("Fornecedor B", 1200, 8, 6, 3.5, 450);
        Fornecedor fornecedorC = new Fornecedor("Fornecedor C", 1000, 10, 4, 5.0, 700);

        // Inserindo os fornecedores no motor de regras
        kSession.insert(fornecedorA);
        kSession.insert(fornecedorB);
        kSession.insert(fornecedorC);

        // Executando as regras
        kSession.fireAllRules();

        // Fechando sessão
        kSession.dispose();

        // Exibindo a pontuação final
        System.out.println(fornecedorA.getNome() + ": " + fornecedorA.getPontuacao());
        System.out.println(fornecedorB.getNome() + ": " + fornecedorB.getPontuacao());
        System.out.println(fornecedorC.getNome() + ": " + fornecedorC.getPontuacao());
    }
}
