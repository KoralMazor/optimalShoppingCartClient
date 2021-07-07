package com.hit.model;

import com.google.gson.Gson;
import com.hit.server.HandleRequest;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable  {
    private Socket socket;
    private BufferedReader cin;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    public void makeContact(){

    }
    @Override
    public void run() {
        try {
            while (true) {
                String s = "{\n" +
                        "   \"headers\":{\n" +
                        "      \"action\":\"UPDATE\"\n" +
                        "   },\n" +
                        "   \"body\":{\n" +
                        "      \"name\":\"”Hobbit”\",\n" +
                        "      \"content\":\"Some String Data\"\n" +
                        "   }\n" +
                        "}";

                Gson gson = new Gson();
                try {
                    System.out.println("socket is running");
                    socket = null;
                    socket = new Socket("localhost", 5000);
                    objectInputStream = new ObjectInputStream(socket.getInputStream());
                    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    HandleRequest request = new HandleRequest(socket, objectInputStream, objectOutputStream);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                cin.close();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }

    }
}

