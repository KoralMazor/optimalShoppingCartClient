package com.hit.model;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable  {
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private Socket socket;
    private BufferedReader cin;


//    public ThreadClient(Socket socket) throws IOException {
//        this.socket = socket;
//        this.cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//    }

    @Override
    public void run() {
        try {
            while (true) {
                Gson gson = new Gson();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                String json = gson.toJson(inputStream.read());
                System.out.println(json);


            }
        } catch (SocketException e) {
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                cin.close();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}

