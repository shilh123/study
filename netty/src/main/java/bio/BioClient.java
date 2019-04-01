/** 
 * Project Name:netty 
 * File Name:BioClient.java 
 * Package Name:bio 
 * Date:2019年3月29日下午3:38:57 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * ClassName:BioClient <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午3:38:57 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class BioClient {

	public static void main(String[] args) {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			socket = new Socket(inetAddress, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("QUERY TIME ORER");
//			System.out.println("Send order 2 server succeed");
//			String resp = in.readLine();
//			System.out.println("Now is :" + resp);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				socket = null;
			}
		}

	}
}
