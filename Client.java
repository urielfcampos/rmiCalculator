import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        float x = Float.parseFloat(args[0]);
        float y = Float.parseFloat(args[1]);

        String host = "10.16.1.179";
        int port = 10101;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Calculadora stub = (Calculadora) registry.lookup("Calculadora");
            float response = stub.soma(x, y);
            System.out.println("response: " + response);
            response = stub.soma(x, y);
            System.out.println("response: " + response);
            response = stub.soma(x, y);
            System.out.println("response: " + response);
            response = stub.soma(x, y);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}