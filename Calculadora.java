import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
    float soma(float x, float y) throws RemoteException;
    float subtrai(float x, float y) throws RemoteException;
    float divide(float x, float y) throws RemoteException;
    float multiplica(float x, float y) throws RemoteException;
}
