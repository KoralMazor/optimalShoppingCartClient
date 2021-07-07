package com.hit.server;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class HandleRequest<T> implements Runnable , Serializable {
    private Gson gson_handler;
    private String jsonString;
    T obj;
    private Socket socket;
    transient ObjectInputStream inStream;
    transient ObjectOutputStream outStream;
    private Response response;
    private Request request;
    public HandleRequest(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException  { // Add controller
    this.socket = socket;
    this.inStream  = inStream;
    this.outStream = outStream;
    }


    @Override
    public void run() {
        while(!socket.isClosed()){

            try {
                    response = gson_handler.fromJson((String)inStream.readObject(),Response.class);
                    outStream = new ObjectOutputStream(socket.getOutputStream());
                    outStream.writeObject(response);
                    inStream = new ObjectInputStream(socket.getInputStream());
                    request = gson_handler.fromJson((String)inStream.readObject(),Request.class);
                    System.out.println(request.headers.getAction());

                } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            gson_handler = new Gson();


                switch (request.headers.getAction()){
                }
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //outStream.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        }
    }



