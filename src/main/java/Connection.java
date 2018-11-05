import io.Reader;
import io.Writer;

import java.io.IOException;
import java.net.Socket;


public class Connection implements Runnable{

    private final Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            new Writer(socket).writeMessage("Welcome " + socket.getInetAddress() + " " + socket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(socket.getInetAddress() + " " + socket.getPort() + " - has been connected");
        new Thread(new Reader(socket)).start();
        new Thread(new Writer(socket)).start();
    }
}
