package chatmulticliente;

import java.io.*;
import java.net.*;

public class Servidor {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream out;
    static Usuarios[] usuario = new Usuarios[10];
    static DataInputStream in;
    //static final String HOST ="localhost";
    static final int PUERTO=5000;
    
    public static void main(String[] args) throws Exception {
        serverSocket = new ServerSocket(PUERTO);
        System.out.println("Iniciando en el puerto: "+PUERTO);
        System.out.println("Conexion establecida con el cliente");
        while(true){
            socket = serverSocket.accept();
            for(int i=0; i<10; i++){
                System.out.println("Conectando desde la direccion IP: " + socket.getInetAddress());
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream()); 
                if(usuario[i]==null){
                    usuario[i] = new Usuarios(out,in,usuario);
                    Thread thread = new Thread(usuario[i]);  
                    thread.start();
                    break;
                } 
            }     
        }  
    }
}

    
    
    

    
    