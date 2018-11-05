package io;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Reader implements Runnable {
    private final Socket socket;

    public Reader(Socket socket) {
        this.socket = socket;
    }

    public Message readMessage() throws IOException {
        DataInputStream din = new DataInputStream(socket.getInputStream());
        String rawMessage = din.readUTF();
        return new ObjectMapper().readValue(rawMessage, Message.class);
    }

    public void run() {

        while (true){
            try {
                Message message = readMessage();
                String name = (String)message.getPayload().get("name");
                System.out.println(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

