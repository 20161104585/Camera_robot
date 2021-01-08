package com.imnu.mm.service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendSignalServiceImp extends Thread {	
	
	private int port;
	private InetAddress address;
	public SendSignalServiceImp(int port,InetAddress address) {
		this.port = port;
		this.address = address;
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
				int length = buf.length;//数据的长度
				//InetAddress address = InetAddress.getByName("192.168.137.1");//目标ip

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