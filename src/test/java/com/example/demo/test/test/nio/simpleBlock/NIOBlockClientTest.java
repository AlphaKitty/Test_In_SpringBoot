package com.example.demo.test.test.nio.simpleBlock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 没有加入Selector的阻塞式NIO客户端
 */
public class NIOBlockClientTest {
    public static void main(String[] args) throws IOException {
        // 套接字通道 客户端的要指定URL和端口
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        // 文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\37221\\Pictures\\Camera Roll\\JAVA\\JMM.jpg"), StandardOpenOption.READ);
        // byte缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 从fileChannel里读出字节 打满1024
        while (fileChannel.read(byteBuffer) != -1) {
            // 切换byteBuffer为读出模式(从byteBuffer里往外读字节)
            byteBuffer.flip();
            // 向socketChannel中写入byte
            socketChannel.write(byteBuffer);
            // byteBuffer重新置回写入模式 等待下次写入
            byteBuffer.clear();
        }

        // 必须要显示的告诉服务端 我的数据发送完了!
        socketChannel.shutdownOutput();

        // // 读取回复信息
        int len;
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(), 0, len));
            byteBuffer.clear();
        }

        // 依次关闭通道!
        fileChannel.close();
        socketChannel.close();
    }
}
