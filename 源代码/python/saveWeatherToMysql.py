import serial
import pymysql                              # 导入pymysql包

log=0                                       # 传输次数记录
ser = serial.Serial()
ser.baudrate = 9600                         # 设置波特率
ser.port = 'COM6'                           # 端口是COM6
print(ser)
ser.open()                                  # 打开串口
print(ser.is_open)                          # 检验串口是否打开

db = pymysql.connect(
    host="localhost",
    port=3306,
    user="root",
    password="123456",
    database="db_camerarobot",
    charset="utf8"
)                                           # 打开数据库，配置数据库

while (1):
    s = ser.readline().decode("UTF-8")      #  读一行数据，以/n结束，要是没有/n就一直读，阻塞。
    log += 1                                # 传输次数记录+1
    data_pre = str(s)                       # 强制用字符串格式

    
    strlist = data_pre.split(',')           # 分割字符串
    temperature = strlist[0]                # 获取温度值
    humidity = strlist[1]                   # 获取湿度值
    rainfall = strlist[2]                   # 获取降雨量
    print(temperature,humidity,rainfall)    # 打印获取值

    cursor = db.cursor() # 数据库操作
    sql = "update weather set temperature=%s, humidity=%s, rainfall=%s where weatherid=1;"   # 存入数据库
    val = ("3", "3", "3")
    res = cursor.execute(sql,[temperature,humidity,rainfall])  # 执行数据库语句

    db.commit()                                                # 涉及写操作要提交
    cursor.close()

    print(res, " 条记录已更新")
