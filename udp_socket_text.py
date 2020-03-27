import socket

udp_socket = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

address = ("192.168.137.1", 8080)

send_data = input("请输入要发送的内容：")

udp_socket.sendto(send_data.encode("utf-8"), address)

recv_data = udp_socket.recvfrom(1024)
print(recv_data[0].decode("gbk"))
print(recv_data[1])
udp_socket.close()
