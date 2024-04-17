/**
 * Este é um cliente para um serviço de operações matemáticas distribuídas usando RMI (Remote Method Invocation).
 */
package cliente;

import java.io.*;
import java.rmi.*;

import servico.Operacao;

/**
 * A classe Client é a classe principal que contém o método main, que é o ponto de entrada do programa.
 */
public class Client{
   public static void main(String args[])  { 

        // Define um SecurityManager para o sistema.
        System.setSecurityManager(new RMISecurityManager());

        // Define a política de segurança para permitir acesso ao sistema de arquivos local onde está localizado o arquivo fabio.policy.
        System.setProperty("java.security.policy", "file:///C:/Users/botel/eclipse-workspace/unievaRMI/fabio.policy");

        try {   
            // Procura pelo objeto Operacao no servidor RMI com o nome "OppMathServer".
            Operacao Opp = (Operacao)Naming.lookup("OppMathServer");

            // Imprime uma mensagem indicando que o objeto de operações matemáticas foi localizado com sucesso.
            System.out.println("Objeto Operações matemáticas localizado.");

            // Extrai os argumentos da linha de comando.
            int tipoopp = Integer.parseInt(args[0]);
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);
            int resultado = 0;

            // Executa a operação apropriada com base no tipoopp.
            if (tipoopp == 1) {
                resultado = Opp.Soma(a, b);
            }
            
            if (tipoopp == 2) {
                resultado = Opp.Produto(a, b);
            }

            // Imprime o resultado da operação.
            System.out.println("Resultado = " + resultado);  
        } catch(Exception e){ 
            // Em caso de exceção, imprime a mensagem de erro.
            System.err.println(e.getMessage()); 
        }
        // Termina o programa.
        System.exit(0);
    } // fim public... main
} // fim class
