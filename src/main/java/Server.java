import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Connection(socket)).start();
        }
    }
}
