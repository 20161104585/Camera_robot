package Udp_text;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udp_receive {

	public static void main(String[] args) throws Exception {
		
		DatagramSocket ds = new DatagramSocket(61789);//指定监听的端口号
		while(true) {
			byte[] buf = new byte[1024];
			int length = buf.length;
			DatagramPacket dp = new DatagramPacket(buf, length);
			
			ds.receive(dp);//程序等待数据到来
			
			String str = new String(dp.getData(),0,dp.getLength());
			InetAddress address = dp.getAddress();
			System.out.println(address+":"+str);
		}

		
//		ds.close();
	}
}
