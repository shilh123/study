package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NioClient implements Runnable {
	private String host = null;
	private int port = -1;
	private Selector selector = null;
	private SocketChannel socketChannel = null;

	public static void main(String[] args) {
		NioClient nioClient = new NioClient(8888, "127.0.0.1");
		new Thread(nioClient).start();
	}

	public NioClient(int port, String host) {
		// TODO Auto-generated constructor stub
		this.port = port;
		this.host = host;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			selector = Selector.open();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void run() {
		// TODO Auto-generated method stub
		doConnect();
		while (selector.isOpen()) {
			try {
				selector.select(1000);
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					handlerInput(key);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void handlerInput(SelectionKey key) {
		// TODO Auto-generated method stub
		try {
			SocketChannel sc = null;
			if (key.isValid()) {
				if (key.isConnectable()) {
					sc = (SocketChannel) key.channel();
					if (sc.finishConnect()) {
						sc.register(selector, SelectionKey.OP_READ);
						sendWrite(sc, "Client msagess");
					}
				} else {
					handlerRead(key);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void handlerRead(SelectionKey key) {
		// TODO Auto-generated method stub
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try {
			int readBytes = sc.read(buffer);
			if (readBytes > 0) {
				buffer.flip();
				byte[] data = new byte[buffer.remaining()];
				buffer.get(data);
				String content = new String(data);
				System.out.println(content);
			} else {
				key.cancel();
				sc.close();
				buffer.clear();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void doConnect() {
		// TODO Auto-generated method stub
		System.out.println("doConnect");
		boolean connect;
		try {
			System.out.println(host + "==" + port);
			connect = socketChannel.connect(new InetSocketAddress(host, port));
			if (connect) {
				System.out.println("has connect");
				socketChannel.register(selector, SelectionKey.OP_READ);
				sendWrite(socketChannel, "Client send message");
			} else {
				System.out.println("has not connect");
				socketChannel.register(selector, SelectionKey.OP_CONNECT);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendWrite(SocketChannel socketChannel2, String string) {
		// TODO Auto-generated method stub
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		if (string != null && string.length() != 0) {
			try {
				byte[] data = string.getBytes();
				buffer.put(data);
				buffer.flip();
				socketChannel2.write(buffer);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
