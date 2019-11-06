import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        float x = Float.parseFloat(args[0]);
        float y = Float.parseFloat(args[1]);

        String host = "10.16.4.52";
        int port = 1099;
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Calculadora stub = (Calculadora) registry.lookup("Calculadora");
            float response = stub.soma(x, y);
            System.out.println("soma: " + response);
            response = stub.subtrai(x, y);
            System.out.println("Subtração: " + response);
            response = stub.divide(x, y);
            System.out.println("Divisão: " + response);
            response = stub.multiplica(x, y);
            System.out.println("Multiplicação: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}