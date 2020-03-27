package Udp_text;

public class Demo_chat_user02 {
	public static void main(String[] args) {
		ReceiveThread rt = new ReceiveThread(7878);
		SendThread st = new SendThread(7879);
		rt.start();
		st.start();
	}
}
