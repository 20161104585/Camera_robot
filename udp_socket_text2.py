import socket


def send_msg(udp_socket):
    msg = input("请输入你要发送的内容：")
    ip = input("请输入对方的ip地址：")
    port = int(input("请输入对方的端口号："))
    udp_socket.sendto(msg.encode("utf-8"),(ip, port))

def recv_msg(udp_socket):
    recv_data = udp_socket.recvfrom(1024)
    ip = recv_data[1]
    msg = recv_data[0].decode("gbk")
    print(">>>%s: %s " % (str(ip),msg))
    #print(recv_data[0].decode("gbk"))
    #print(recv_data[1])

def main():
    #创建socket
    udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    #绑定端口
    udp_socket.bind(("",8081))
    while True:
        op_num = input("请输入你要选择的功能序号(或输入0退出)：")
        if op_num == '1':
            send_msg(udp_socket)
        elif op_num == '2':
            recv_msg(udp_socket)
        elif op_num == '0':
            break
        else:
            print("输入错误！！！")
if __name__ == '__main__':
    main()
