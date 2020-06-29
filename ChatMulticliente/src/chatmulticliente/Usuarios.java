package chatmulticliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Usuarios implements Runnable{
    DataOutputStream out;
    DataInputStream in;
    Usuarios[] usuario = new Usuarios[10];
    String nombre;
    
    public Usuarios(DataOutputStream out, DataInputStream in, Usuarios[] usuario){
        this.out = out;
        this.in = in;
        this.usuario = usuario;
    }

    public void run() {
        try {
             nombre = in.readUTF();
        } catch (IOException e1){
            e1.printStackTrace();
        }
        while (true) {
            try {
                String msj = in.readUTF();
                for (int i = 0; i < 10; i++) {
                    if (usuario[i] != null) {
                        usuario[i].out.writeUTF(nombre+":"+msj);
                    }
                }
            }catch(IOException e){
                this.out = null;
                this.in = null;
            }
        }
    }
}