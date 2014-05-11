package dilu.kxq.learn.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by deelew on 14-5-11.
 */
public class LoopWriteClient {
    public static void main(String[] args){
        String toSend = "loopWrite" ;
        int count =0 ;
        try {
            Socket socket = new Socket(ConfigParams.ip, ConfigParams.port);
            OutputStream out = socket.getOutputStream();
            while(true){
                out.write(toSend.getBytes());
                out.flush();
                System.out.println("writing " + count++);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
