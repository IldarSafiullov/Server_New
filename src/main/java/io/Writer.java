package io;


import authorization.User;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Writer implements Runnable {
    final Socket socket;

    public Writer(Socket socket) {
        this.socket = socket;
    }

    public void writeMessage(String message) throws IOException {
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        dout.writeUTF(message);
    }

    public void run() {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Message to client: ");
            try {
                String messageOut = br.readLine();
                writeMessage(messageOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
