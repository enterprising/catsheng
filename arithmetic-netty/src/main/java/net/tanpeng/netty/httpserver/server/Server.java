package net.tanpeng.netty.httpserver.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by peng.tan on 2019/1/5.
 */
public class Server {
    private EventLoopGroup eventLoopGroup = null;
    private Channel channel = null;

    private void start(int port) throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap().group(eventLoopGroup).childHandler(new HttpServerInitializer()).channel(NioServerSocketChannel.class);
        channel = bootstrap.bind(port).sync().channel();
    }

    private void sync() throws InterruptedException {
        channel.closeFuture().sync();
    }

    public void stop() {
        eventLoopGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start(3000);
        server.sync();
    }
}
