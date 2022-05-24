package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)  {
        try {
            InetAddress ia;
            ia = InetAddress.getByName("localhost");
            Socket client = new Socket(ia, 2031);
            DataInputStream dataInputStream= new DataInputStream(client.getInputStream());
            DataOutputStream dataOutputStream= new DataOutputStream(client.getOutputStream());
            PrintStream printStream=new PrintStream(dataOutputStream);
            Thread writingThread = new Thread(){
                @Override
                public void run() {
                    System.out.println("Client started...");
                    System.out.println("Valid actions GET,PUT,EXIT");
                    String command = "";
                    Scanner sc=new Scanner(System.in);
                    while(!"EXIT".equals(command)) {
                        System.out.println("Enter command:");
                        command = sc.nextLine();
                        printStream.println(command);
                    }
                    printStream.println("EXIT");
                    printStream.flush();
                }
            };
            writingThread.start();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host exception occurred");
        } catch (IOException e) {
            System.out.println("IO exception occurred");
        }
    }
}
