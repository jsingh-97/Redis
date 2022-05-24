package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    //valid actions PUT GET
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(2031);
        while(true){
            Socket socket=serverSocket.accept();
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            Thread clientReadingThread=getClientReadingThread(dataInputStream);
            Thread clientWritingThread=getClientWritingThread(dataOutputStream);
            clientReadingThread.start();
            clientWritingThread.start();

        }
    }

    private static Thread getClientWritingThread(DataOutputStream dataOutputStream) {
        return new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
    }

    private static Thread getClientReadingThread(DataInputStream dataInputStream) {
        return new Thread(){
            @Override
            public void run() {
                String message="";
                Scanner sc=new Scanner(dataInputStream);
                do{
                    System.out.println("Message received");
                    message=sc.nextLine();
                    System.out.println(message);
                }while(!"EXIT".equals(message));

            }
        };
    }
}
