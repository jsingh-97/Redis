package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    HashMap<Integer,String> cache;
    Server(){
        this.cache=new HashMap<>();
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(2032);
        while(true){
            Socket socket=serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            Thread readingThread=getClientReadingThread(dataInputStream);
            Thread writingThread=getClientWritingThread(dataOutputStream);
            readingThread.start();
            writingThread.start();
        }
    }
    private static Thread getClientWritingThread(DataOutputStream dataOutputStream) {
        return new Thread();
    }

    private static Thread getClientReadingThread(DataInputStream dataInputStream) {
        return new Thread();
    }
}
