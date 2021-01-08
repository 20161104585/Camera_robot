import socket
import json

#创建socket
udp_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
#绑定端口
udp_socket.bind(("",8081))
left = "False"
top = "False"
right = "False"
bottom = "False"
while True:
    recv_data = udp_socket.recvfrom(1024*1024)
    ip = recv_data[1]
    msg = json.loads(recv_data[0].decode("utf-8"))
    
    #print(msg)
    #print(">>>%s: %s " % (str(ip),msg))
    # 调用解析
    #print('将jsons1遍历后的结果如下：')
    for key in msg:
        #print(key + ":"+str(msg[key]))
        if(key=="left"):
            left=str(msg[key])
        elif(key=="top"):
            top=str(msg[key])
        elif(key=="right"):
            right=str(msg[key])
        elif(key=="bottom"):
            bottom=str(msg[key])
    #print(left,top,right,bottom)
    if(left=="False" and right=="False" and top=="True" and bottom=="False"):
        print("前进")
    if(left=="False" and right=="False" and top=="False" and bottom=="True"):
        print("后退")
    if(left=="True" and right=="False" and top=="False" and bottom=="False"):
        print("左转")
    if(left=="False" and right=="True" and top=="False" and bottom=="False"):
        print("右转")
    if(left=="True" and right=="False" and top=="True" and bottom=="False"):
        print("左转弯------前左")
    if(left=="False" and right=="True" and top=="True" and bottom=="False"):
        print("右转弯------前右")
    if(left=="True" and right=="False" and top=="False" and bottom=="True"):
        print("左后转弯----左后")
    if(left=="False" and right=="True" and top=="False" and bottom=="True"):
        print("右后转弯----右后")
   
        

