package dilu.kxq.learn.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSide {

	public static void main(String[] arg ){
		int port = 7001;
		String host = "127.0.0.1";
		Socket socket = null ;
		OutputStream output = null ;
		try {
			socket = new Socket(host , port);
			System.out.println("connected to server, start to commutication...");
			output = socket.getOutputStream();
			byte[] b = "hello server from cliet ".getBytes();
			output.write(b);
			output.flush();
			System.out.println("msgSendToServer done : " + new String(b));
			InputStream in = socket.getInputStream() ;
			byte[] fromServer = new byte[10];
			StringBuilder sb = new StringBuilder();
			while(true){
				
				int len = in.read(fromServer);
				if(len==-1)
					break;
				sb.append(new String(fromServer,0,len));
				if(len < fromServer.length)
					break ;
			}
			System.out.println(sb.insert(0, "echo from server: ")); ;
		}catch(IOException e){
			e.printStackTrace();
			tryCloseSIO(socket, output);
		}finally{
			tryCloseSIO(socket,output);
		}
	}

	private static void tryCloseSIO(Socket socket, OutputStream output) {
		if(output!= null){
			try{
				output.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		if(socket != null){
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
