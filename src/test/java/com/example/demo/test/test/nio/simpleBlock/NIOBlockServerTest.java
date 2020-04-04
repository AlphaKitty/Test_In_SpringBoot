package com.example.demo.test.test.nio.simpleBlock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 没有加入Selector的阻塞式NIO服务端
 */
public class NIOBlockServerTest {
    public static void main(String[] args) throws IOException {
        // 套接字通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 服务端的只需要绑定接收端口
        serverSocketChannel.bind(new InetSocketAddress((6666)));
        // 用于接收的文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\37221\\Desktop\\111.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        // 创建阻塞的客户端通道
        SocketChannel clientChannel = serverSocketChannel.accept();
        // 创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 从阻塞的客户端通道里读出字节数据到byteBuffer 打满1024
        while (clientChannel.read(byteBuffer) != -1) {
            // 切换到读出状态
            byteBuffer.flip();
            // 向文件通道里写入字节数据
            fileChannel.write(byteBuffer);
            // 把榨干的字节缓冲区重新置回写入状态
            byteBuffer.clear();
        }

        // 回复图片接收成功
        byteBuffer.put("image is received!".getBytes());
        byteBuffer.flip();
        clientChannel.write(byteBuffer);
        byteBuffer.clear();

        // 依次关闭通道!
        clientChannel.close();
        fileChannel.close();
        serverSocketChannel.close();
    }
}
