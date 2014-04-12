package dilu.kxq.learn.net;

import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

public class InetAddressExample {

	public static void main(String[] arg){
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces() ;
			if(interfaces==null){
				System.out.println("interfaces is null");
				return ;
			}
			while(interfaces.hasMoreElements()){
				NetworkInterface iface = interfaces.nextElement() ;
				System.out.println(iface.getName());
				List<InterfaceAddress> iadrs = iface.getInterfaceAddresses() ;
				for(InterfaceAddress iadr : iadrs){
					
				}
			}
			NetworkInterface en0 = NetworkInterface.getByName("en0");
			byte[] mac = en0.getHardwareAddress() ;
			System.out.println(String.valueOf(mac));
			Enumeration<InetAddress> adrs = en0.getInetAddresses() ;
			while(adrs.hasMoreElements()){
				
				InetAddress adr = adrs.nextElement();
				
				String host = adr.getHostAddress() ;
				String chost = adr.getCanonicalHostName() ;
				byte[] ipbyte = adr.getAddress() ;
				StringBuilder sb = new StringBuilder() ;
				for(byte b :ipbyte){
					sb.append(b&0xff).append(".");
				}
				if(sb.length() > 1)
					sb.deleteCharAt(sb.length() -1);
				if(adr instanceof Inet4Address)
					System.out.print("ipv4 -- ");
				if(adr instanceof Inet6Address)
					System.out.print("ipv6 -- ");
				System.out.println("host:"+host+" chost:"+chost+" ip:"+sb.toString());
			}
			
			List<InterfaceAddress> ifaceAdrs = en0.getInterfaceAddresses() ;
			for(InterfaceAddress ifaceAdr :ifaceAdrs){
				InetAddress _adr = ifaceAdr.getAddress() ; 
				InetAddress _adrbr = ifaceAdr.getBroadcast() ;
				short prexlen = ifaceAdr.getNetworkPrefixLength() ;
				System.out.println(_adr.getHostAddress());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
