package dilu.kxq.learn.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class CorpseTcpServer {

    public static void main(String[] args){
        ServerSocket sSocket = null;
        try {
            int port = 7001;
            sSocket = new ServerSocket(port) ;
            while(true){
                synchronized (Thread.currentThread()){

                    System.out.println("ok server start...");
                    Thread.currentThread().wait();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            tryCloseSocket(sSocket);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            tryCloseSocket(sSocket);
        }
    }

    private static void tryCloseSocket(ServerSocket sSocket) {
        if(sSocket != null){
            try {
                sSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
