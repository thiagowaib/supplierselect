# SupplierSelect

SupplierSelect é um Sistema de Apoio à Decisão (SAD) desenvolvido em Java com integração ao Drools, um motor de regras, para ajudar na seleção de fornecedores de uma empresa de manufatura. Este sistema permite importar dados de fornecedores a partir de um arquivo CSV, organizar e ordenar os fornecedores por pontuação, ajudando na tomada de decisão com base em critérios estabelecidos.

## Descrição do Projeto

O projeto tem como objetivo avaliar e selecionar fornecedores de matéria-prima com base em múltiplos critérios:
- **Preço**: Ajustado com base em índices de mercado.
- **Qualidade**: Avaliação da qualidade dos produtos fornecidos.
- **Prazos de Entrega**: Consideração do histórico de pontualidade nas entregas.
- **Reputação**: Pontuação baseada em feedback de clientes e fornecedores anteriores.
- **Capacidade de Atendimento**: Avaliação da capacidade de atender grandes pedidos.

Os fornecedores são avaliados e ranqueados de acordo com uma pontuação final calculada pelo sistema, considerando pesos maiores para critérios críticos, como qualidade e capacidade de atendimento.

## Regras Definidas no Drools

O Drools é utilizado para definir as regras de avaliação dos fornecedores. Abaixo estão algumas das regras implementadas:

- **Regra de Preço Acessível**:
  - Fornecedores com preço abaixo de um limite recebem uma pontuação extra.

    ```drools
    rule "Avaliar Preço Acessível"
    when
        $fornecedor : Fornecedor(preco < 1000)
    then
        $fornecedor.setPontuacao($fornecedor.getPontuacao() + 20);
    end
    ```

- **Regra de Alta Qualidade**:
  - Fornecedores com alta qualidade recebem pontuação adicional.

    ```drools
    rule "Avaliar Alta Qualidade"
    when
        $fornecedor : Fornecedor(qualidade >= 9)
    then
        $fornecedor.setPontuacao($fornecedor.getPontuacao() + 30);
    end
    ```

- **Regra de Reputação Positiva**:
  - Fornecedores com reputação acima de um determinado nível recebem um incremento na pontuação.

    ```drools
    rule "Avaliar Reputação Positiva"
    when
        $fornecedor : Fornecedor(reputacao >= 4.0)
    then
        $fornecedor.setPontuacao($fornecedor.getPontuacao() + 15);
    end
    ```

Essas regras são apenas alguns exemplos das condições configuradas no Drools para avaliar os fornecedores com base nos critérios definidos.

## Funcionalidade Básica

1. **Importação de Fornecedores**:
   - O sistema permite importar fornecedores a partir de um arquivo CSV. O arquivo deve estar no seguinte formato:
     ```plaintext
     nome,preco,qualidade,prazoEntrega,reputacao,capacidade,pontuacao
     Fornecedor A,950,9,3,4.5,600,80
     Fornecedor B,1200,8,6,3.5,450,65
     Fornecedor C,1000,10,4,5.0,700,90
     ```

2. **Avaliação de Fornecedores**:
   - Após a importação, o sistema avalia cada fornecedor com base nas regras definidas no Drools e calcula uma pontuação final para cada um.

3. **Listagem e Ordenação**:
   - O sistema permite listar os fornecedores em uma tabela formatada, ordenados pela pontuação em ordem decrescente para facilitar a visualização dos melhores candidatos.

## Como Executar o Projeto

### Requisitos

- **Java 8** ou superior
- **Maven** para gerenciar dependências e construção do projeto

### Configuração e Execução

**Compilação e execução com o script `run.sh`**:
   - O projeto inclui um script Bash (`run.sh`) para compilar e executar o sistema automaticamente.
- Execute o script com:
     ```bash
     ./run.sh
     ```

   O script irá compilar o projeto, verificando possíveis erros de compilação, e iniciar o sistema.

### Interação com o Sistema

Ao iniciar o sistema, você verá o seguinte menu no terminal:

```plaintext
===========================
       MENU DE OPÇÕES      
===========================
1 - Importar fornecedores do CSV
2 - Listar fornecedores por pontuação
3 - Sair
Escolha uma opção: 
```

- **Opção 1**: Importar Fornecedores
  - Ao selecionar esta opção, o sistema abrirá uma caixa de seleção de arquivos (usando `JFileChooser`) para que você escolha o arquivo CSV de fornecedores.

- **Opção 2**: Listar Fornecedores
  - O sistema exibirá uma lista de fornecedores, ordenados pela pontuação.

- **Opção 3**: Sair
  - Encerra o sistema.

---