package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer implements Runnable {
	private Integer port = null;
	private Selector selector = null;

	public static void main(String[] args) {
		NioServer nioServer = new NioServer(8888);
		new Thread(nioServer).start();
//		nioServer.NioServer();

	}

	public NioServer(Integer port) {
		// TODO Auto-generated constructor stub
		this.port = port;
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress(this.port), 1024);
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Server has listening port:" + this.port);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while (selector.isOpen()) {
			try {
				selector.select(1000);
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					handlerInput(key);// 处理接收到的select 连接
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) {
		// TODO Auto-generated method stub
		if (key.isValid()) {
			if (key.isAcceptable()) {
				try {
					ServerSocketChannel ssc = null;
					SocketChannel sc = null;
					if (sc != null) {
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else if (key.isReadable()) {
				handlerRead(key);
			}
		}

	}

	private void handlerRead(SelectionKey key) {
		// TODO Auto-generated method stub
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int readBytes;
		try {
			readBytes = sc.read(buffer);
			if (readBytes > 0) {
				buffer.flip();
				byte[] data = new byte[buffer.remaining()];
				buffer.get(data);
				String content = new String(data);
				System.out.println("server has receive message:" + content);
				responseWrite(sc, "server has response client");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void responseWrite(SocketChannel socketChannel, String string) {
		// TODO Auto-generated method stub

		ByteBuffer buffer = null;
		if (string != null && string.length() != 0) {
			byte[] data = string.getBytes();
			try {
				buffer = ByteBuffer.allocate(data.length);
				buffer.put(data);
				buffer.flip();
				socketChannel.write(buffer);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
