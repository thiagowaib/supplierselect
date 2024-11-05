#!/bin/bash

# Variável para o nome da classe principal
MAIN_CLASS="com.example.supplierselect.AvaliadorDeFornecedores"

# Compila o projeto com Maven
echo "Compilando o projeto..."
mvn clean compile

# Verifica se a compilação foi bem-sucedida
if [ $? -eq 0 ]; then
  echo "Compilação bem-sucedida. Iniciando o projeto..."
  mvn exec:java -Dexec.mainClass=$MAIN_CLASS
else
  echo "Erro na compilação. Verifique os erros acima."
fi
