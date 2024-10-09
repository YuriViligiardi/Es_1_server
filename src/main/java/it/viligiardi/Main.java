package it.viligiardi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        
        try {

            ServerSocket ss = new ServerSocket(5637); //Il server crea un serverSocket

            Socket mySocket = ss.accept(); //Funzione per far rimanere in attesa il socket, in ascolto

            System.out.println("Qualcuno si è collegato");

            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());

            String stringaRicevuta = in.readLine();
            System.out.println("La stringa ricevuta: " + stringaRicevuta);

            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + "\n");
            System.out.println("La stringa inviata: " + stringaMaiuscola);

            mySocket.close();
            ss.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Errore durante l'instanza del server");
            System.exit(1);

        }
        
    }
}