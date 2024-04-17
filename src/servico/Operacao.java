package servico;

public interface Operacao extends java.rmi.Remote {

	   int Soma(int VarA, int VarB) throws java.rmi.RemoteException;
	   int Produto(int VarA, int VarB) throws java.rmi.RemoteException;

	}