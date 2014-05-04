package dilu.kxq.learn.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by deelew on 14-5-4.
 */
public class UdpServer {
    public static void main(String[] args ){
        try {
            DatagramSocket ds = new DatagramSocket(9968);
            int len = 100 ;
            byte[] buf = new byte[len] ;
            DatagramPacket p = new DatagramPacket(buf, len);
            while(true){
                ds.receive(p);
                p.setLength(len);
                ds.receive(p);
                System.out.println("udp datagram from " + p.getAddress()) ;
                System.out.println(new String(p.getData()));
                ds.send(p);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
