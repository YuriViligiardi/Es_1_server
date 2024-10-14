package it.viligiardi;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class MyThread extends Thread{
    //attributes
    private Socket s;
    
    //methods and constructions
    public MyThread(Socket s){
        this.s = s;
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringaRicevuta = in.readLine();
            System.out.println("La stringa ricevuta: " + stringaRicevuta);

            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + "\n");
            System.out.println("La stringa inviata: " + stringaMaiuscola);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'instanza del server");
            System.exit(1);
        }
    }
}
