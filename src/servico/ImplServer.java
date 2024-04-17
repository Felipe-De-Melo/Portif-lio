package servico;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ImplServer extends UnicastRemoteObject implements Operacao {

  public ImplServer(String name) throws RemoteException{
      super();
      System.out.println("Servidor Operações matemáticas criado!");
   }

  public int Soma(int VarA, int VarB) {

	int soma = VarA + VarB;
	    
        return soma;
    }

  public int Produto(int VarA, int VarB) {

	int produto = VarA * VarB;
	    
        return produto;
    }


}