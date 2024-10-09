package it.viligiardi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        
        ServerSocket ss = new ServerSocket(5673); //Il server crea un serverSocket

        Socket mySocket = ss.accept(); //Funzione per far rimanere in attesa il socket, in ascolto

        System.out.println("Qualcuno si è collegato");
    }
}