package Udp_text;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveThread extends Thread {
	
	private int port;
	
	public ReceiveThread(int port) {
		this.port = port;
	}
	@Override
	public void run() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(port);//指定监听的端口号
			while(true) {
				byte[] buf = new byte[1024];
				int length = buf.length;
				DatagramPacket dp = new DatagramPacket(buf, length);
				
				ds.receive(dp);//程序等待数据到来
				
				String str = new String(dp.getData(),0,dp.getLength() );
				InetAddress address = dp.getAddress();
				System.out.println(address+":"+str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ds!=null)
				ds.close();
		}


		
//		ds.close();
	}
}
