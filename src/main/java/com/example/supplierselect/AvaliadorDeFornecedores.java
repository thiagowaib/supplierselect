package com.example.supplierselect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.example.supplierselect.ui.Header;
import com.example.supplierselect.ui.ListaDeFornecedores;
import com.example.supplierselect.ui.Menu;

public class AvaliadorDeFornecedores {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Fornecedor> fornecedores = new ArrayList<>();

    private static void carregaInformacoes() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kSession = kc.newKieSession("ksession-rules");

        fornecedores = Fornecedor.carregarFornecedoresCSV(kSession);
        fornecedores.forEach(kSession::insert);
        kSession.fireAllRules();
        kSession.dispose();
    }

    private static void mostraInformacoes() {
        fornecedores.sort(Comparator.comparing(Fornecedor::getPontuacao).reversed());
        ListaDeFornecedores.exibir(fornecedores);
    }

    public static void main(String[] args) {
        Header.exibir();


        // Menu de navegacao no terminal
        while (true) {
            Menu.exibir();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    carregaInformacoes();
                    break;
                case 2:
                    mostraInformacoes();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opcao inválida, tente novamente.");
            }
        }
    }
}
