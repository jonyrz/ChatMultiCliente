
package chatmulticliente;

import java.io.DataInputStream;
import java.io.IOException;

public class EnviarMsj implements Runnable{
    DataInputStream in;
    
    public EnviarMsj(DataInputStream in){
        this.in = in;
    }
    public void run(){
        while(true){
            String msj;
            try{
                msj = in.readUTF();
                System.out.println(msj);
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
       
    }
}
