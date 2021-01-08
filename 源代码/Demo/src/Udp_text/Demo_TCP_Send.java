package Udp_text;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo_TCP_Send {
	public static void main(String[] args) throws Exception{
		//使用TCP 发送端client客户端，接收端server服务器端
		//Socket
		//TCP需要建立连接
		Socket s = new Socket("192.168.137.1",7878);//跟指定IP、port建立连接
		
		OutputStream output = s.getOutputStream();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String str = scanner.nextLine();
			if(str.equals("end"))break;
			
			output.write(str.getBytes());
		}

		s.close();
	}
}
