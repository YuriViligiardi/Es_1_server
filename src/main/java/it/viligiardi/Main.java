package it.viligiardi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        
        ServerSocket ss2 = new ServerSocket(5637);

        do {
            Socket s = ss2.accept();
            System.out.println("Qualcuno si è collegato");
            MyThread t = new MyThread(s);
            t.start();
        } while (true);

    } 
}