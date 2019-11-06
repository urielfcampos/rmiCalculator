import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculadora {
    @Override
    public float soma(float x, float y) {return x + y;}
    @Override
    public float subtrai(float x, float y) {return x - y;}
    @Override
    public float divide(float x, float y) {return x / y;}
    @Override
    public float multiplica(float x, float y) {return x * y;}

    public static void main(String args[]) {
        String address = "10.16.4.52";
        int port = 1099;

        try {
            Server obj = new Server();
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            LocateRegistry.createRegistry(port);
            Registry registry = LocateRegistry.getRegistry(address, port);
            registry.bind("Calculadora", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}