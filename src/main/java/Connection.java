import io.Reader;
import io.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable{

    private final Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(socket.getInetAddress() + " " + socket.getPort() + " - has been connected");
        while (true){
            String messageIn = null;
            try {
                messageIn = new Reader(socket).readMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Message from: " + socket.getInetAddress() + " " + socket.getPort() + " :" + messageIn);
        }
    }
}
