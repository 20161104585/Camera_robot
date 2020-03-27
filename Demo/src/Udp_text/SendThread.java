package Udp_text;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class SendThread extends Thread {
	
	private int port;
	
	public SendThread(int port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			Scanner s = new Scanner(System.in);
			
			while(true) {
				String str = s.nextLine();
				if(str.equals("end")) {
					break;
				}
				byte[] buf = str.getBytes();
				//byte[] buf = "Hello Python!I am java!".getBytes();//发送的数据字符
				int length = buf.length;//数据的长度
				InetAddress address = InetAddress.getByName("192.168.137.1");//目标ip
				//int port = 8081;//目标端口号
				DatagramPacket dp = new DatagramPacket(buf, length, address, port);
				
				ds.send(dp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ds!=null)
				ds.close();
		}
			
	}
}
