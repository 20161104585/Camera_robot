package Udp_text;

public class Demo_chat_user01 {
	public static void main(String[] args) {
		SendThread st = new SendThread(7878);
		ReceiveThread rt = new ReceiveThread(7879);
		st.start();
		rt.start();
		
	}
}
