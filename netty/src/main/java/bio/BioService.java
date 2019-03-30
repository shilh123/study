/** 
 * Project Name:netty 
 * File Name:Bio.java 
 * Package Name:bio 
 * Date:2019年3月29日下午3:21:41 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * ClassName:Bio <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午3:21:41 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class BioService {
	public static void main(String[] args) throws IOException {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {
				// TODO: handle exception

			}
		}

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("The time server is start in port:" + port);
			Socket socket = null;
			while (true) {
				socket = serverSocket.accept();
				new Thread(new BioServerHander(socket)).start();
			}
		} finally {
			if (serverSocket != null) {
				System.out.println("the time server close");
				serverSocket.close();
				serverSocket = null;
			}
		}
	}

}

class BioServerHander implements Runnable {
	private Socket socket;

	public BioServerHander(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			String currentTime = null;
			String body = null;
			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}
				System.out.println("The time server receive order" + body);
				currentTime = "QUERY TIME ORDER".equals(body)
						? new java.util.Date(System.currentTimeMillis()).toString()
						: "BAD ORDER";
				out.println(currentTime);
			}
		} catch (Exception e) {
			// TODO: handle exception
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				this.socket = null;
			}
		}
	}
}