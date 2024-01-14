package com.imooc;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

//NIO服务器端
public class NioServer {
    public void start(){  //启动
//        1.创建selector
        Selector selector = Selector.open();

//        2.创建channel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

//        3.绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));

//        4.设置非阻塞模式
        serverSocketChannel.configureBlocking(false);

//        5.注册到selector，监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

//        6.循环等待新接入的连接
        for (;;){
            //获取可用channel数量
            int readyChannels = selector.select();

            //
            if (readyChannels == 0) continue;
            //获取可用channel的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                //selectionkey实例
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                //移除set中的当前selectionkey
                iterator.remove();

//                7.根据就绪状态，调用对应方法处理业务逻辑
//                接入事件

//                可读事件


            }
        }




    }
    public static void main(String[] args) {
        NioServer nioServer = new NioServer();
    }
}
