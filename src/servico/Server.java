package servico;

import java.rmi.*;
import java.rmi.server.*;

public class Server {

    public static void main(String args[]) {
        // Defina a política de segurança para o servidor
        System.setProperty("java.security.policy", "file:///C:/tmp/fabio.policy");

        // Defina o gerenciador de segurança para o servidor
        System.setSecurityManager(new RMISecurityManager());
      
        try {
            // Crie uma instância do objeto que implementa o serviço
            ImplServer obj = new ImplServer("OppMathServer");
            
            // Registre o serviço com o nome "OppMathServer"
            Naming.rebind("OppMathServer", obj);

            System.out.println("Servidor de Operações Matemáticas Registrado com Sucesso!");
        } catch (Exception e) { 
            // Capture e imprima quaisquer exceções que ocorram durante o processo
            System.out.println(e.getMessage());
        }   
    }
}
