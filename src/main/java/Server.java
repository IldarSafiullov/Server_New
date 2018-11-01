import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import io.Writer;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Connection(socket)).start();
            new Writer(socket).writeMessage("Welcome " + socket.getInetAddress() + " " + socket.getPort());
        }
    }
}
