package Udp_text;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_TCP_receive {
	public static void main(String[] args) throws Exception{
		
		ServerSocket ss = new ServerSocket(7878);
		
		Socket client = ss.accept();//接收，建立跟发送端的连接
		//new Socket("192.168.137.1",7878);这个时候，会发送跟接受端建立连接的请求
		
		InputStream input = client.getInputStream();
		
		byte[] buf = new byte[1024];
//		while(true) {
//			int length = input.read(buf);
//
//			System.out.println(new String(buf,0,length));
//		}
		int length = -1;
		while((length = input.read(buf))!=-1) {
			System.out.println(new String(buf,0,length));
		}
		
		client.close();
		ss.close();
		
	}
}
