package com.example.demo.test.test.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferTest {
    public static void main(String[] args) {
        // 初始化一个ByteBuffer 默认是写入模式
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("init capacity---" + byteBuffer.capacity());
        System.out.println("init limit---" + byteBuffer.limit());
        System.out.println("init position---" + byteBuffer.position());
        System.out.println("init mark---" + byteBuffer.mark());
        System.out.println();

        // 这时缓冲区中记录的还是写入状态 描述的是空闲区域 position(11)~limit(1024)
        byteBuffer.put("Hello World".getBytes());

        System.out.println("put capacity---" + byteBuffer.capacity());
        System.out.println("put limit---" + byteBuffer.limit());
        System.out.println("put position---" + byteBuffer.position());
        System.out.println("put mark---" + byteBuffer.mark());
        System.out.println();

        // flip方法让缓冲区变为读取状态 描述的是已占用区域 position(0)~limit(11)
        byteBuffer.flip();

        System.out.println("flip capacity---" + byteBuffer.capacity());
        System.out.println("flip limit---" + byteBuffer.limit());
        System.out.println("flip position---" + byteBuffer.position());
        System.out.println("flip mark---" + byteBuffer.mark());
        System.out.println();

        // 获取缓冲区中的内容 这时只是做了读取操作 并没有清空缓冲区
        byte[] b = new byte[byteBuffer.limit()];
        byteBuffer.get(b);
        System.out.println(new String(b, 0, b.length));

        System.out.println("get capacity---" + byteBuffer.capacity());
        System.out.println("get limit---" + byteBuffer.limit());
        System.out.println("get position---" + byteBuffer.position());
        System.out.println("get mark---" + byteBuffer.mark());
        System.out.println();

        // 这里才是真正的清空 又进入了写入模式
        byteBuffer.clear();

        System.out.println("clear capacity---" + byteBuffer.capacity());
        System.out.println("clear limit---" + byteBuffer.limit());
        System.out.println("clear position---" + byteBuffer.position());
        System.out.println("clear mark---" + byteBuffer.mark());

        // 向文件中写入bytes
        try {
            // FileInputStream fileInputStream = new FileInputStream("C:\\Users\\37221\\Desktop\\test.nsi");
            // FileChannel channel = fileInputStream.getChannel();
            FileChannel fileChannel = FileChannel.open(Paths.get("C:\\Users\\37221\\Desktop\\test.txt"), StandardOpenOption.WRITE);
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
