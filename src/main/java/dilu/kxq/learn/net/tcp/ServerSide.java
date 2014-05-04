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
				System.out.println("receive access from ");
				System.out.println(remoteAddr.toString()) ;
				client.getInputStream() ;
				InetAddress clientIAdr = client.getInetAddress();
				System.out.println("remote ip:");
				System.out.println(clientIAdr.getHostAddress());
				InputStream input = client.getInputStream() ;
				byte[] bytes = new byte[100];
				input.read(bytes);
				System.out.write(bytes);
				System.out.println(new String(bytes));
				OutputStream out = client.getOutputStream();
				out.write(("hello " + clientIAdr.getHostAddress()).getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
			tryCloseSocket(sSocket);
		}finally{
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
