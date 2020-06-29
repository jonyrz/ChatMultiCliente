package chatmulticliente;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    static final String HOST ="localhost";
    static final int PUERTO=5000;

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando en el puerto: "+PUERTO);
        socket = new Socket(HOST,PUERTO);
        System.out.println("Conexión establecida con el servidor");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        EnviarMsj input = new EnviarMsj(in);
        Thread thread = new Thread(input);
        thread.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String name = sc.nextLine();
        out.writeUTF(name);
        while(true){
            String enviarMsj = sc.nextLine();
            if (enviarMsj.equals("Salir")||enviarMsj.equals("salir")
                            ||enviarMsj.equals("Adios")||enviarMsj.equals("adios")) {
                System.exit(0);
                out.writeUTF("Un usuario se ha desconectado");
            }
            out.writeUTF(enviarMsj);    
        }
    }
}


