package dilu.kxq.learn.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerSide {
	
	public static void main(String[] args){
		ServerSocket sSocket = null;
		try {
			int port = 7001;
			sSocket = new ServerSocket(port) ;
			while(true){
				System.out.println("ok server start...");
				Socket client = sSocket.accept() ;
				SocketAddress remoteAddr = client.getRemoteSocketAddress();
				System.out.println("receive access from " + remoteAddr.toString());
				InetAddress clientIAdr = client.getInetAddress();
				System.out.println("remote ip:" + clientIAdr.getHostAddress());
				InputStream input = client.getInputStream() ;
				byte[] bytes = new byte[100];
                int len = input.read(bytes,0,10);
                input.close();
//                int left = len ;
//                int index ;
                System.out.println(new String(bytes));
//                OutputStream out = client.getOutputStream();
//                while(left-- > 0){
//                    index = len - left - 1;
//                    out.write(bytes, index, 1);
//                    Thread.sleep(1000);
//                    out.flush();
//
//                }
//                System.out.println(bytes.length);
//				out.write(("hello " + clientIAdr.getHostAddress()).getBytes());
//                out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			tryCloseSocket(sSocket);
//		} catch (InterruptedException e) {
//            e.printStackTrace();
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
