package dilu.kxq.learn.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public class UdpClient {
	public static void main(String[] arg){
		try {
			DatagramSocket data = new DatagramSocket();
			byte[] buf = "hello udp".getBytes();
			int length = buf.length;
			DatagramPacket p = new DatagramPacket(buf, length);
			p.setAddress(InetAddress.getByName("127.0.0.1"));
			p.setPort(9968);
			data.send(p);
			byte[] buf1 = new byte[buf.length];
			DatagramPacket r = new DatagramPacket(buf1, length);
			data.receive(r);
			InetAddress adr = r.getAddress() ;
			String host = adr.getHostAddress() ;
			System.out.println(host);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
