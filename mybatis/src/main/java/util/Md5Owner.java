package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.mysql.cj.conf.url.SingleConnectionUrl;

public class Md5Owner {
	public static String md5(String str) {
		byte[] secretBytes = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			secretBytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new RuntimeException("no this md5");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}

	public static void main(String[] args) {
//		System.out.println(md5("aaaaa"));
		Random random = new Random();
		byte[] bytes = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' };
		random.nextBytes(bytes);
		System.out.println(random.nextInt());
	}
}
