package com.sanq.product.core.utils.string;

import java.security.MessageDigest;


public class DigestUtil {

	private DigestUtil() {}
	
	private static DigestUtil instance;
	
	public static DigestUtil getInstance() {
		if(instance == null) {
			synchronized (DigestUtil.class) {
				if(instance == null) {
					instance = new DigestUtil();
				}
			}
		}
		return instance;
	}
	
	public String md5(String msg) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] bs = digest.digest(msg.getBytes("UTF-8"));
			if(bs != null) {
				StringBuffer sb = new StringBuffer();
				String hexStr;
				for(byte b : bs) {
					int i = b & 0xFF;
					hexStr = Integer.toHexString(i);
					if(hexStr.length() < 2) {
						hexStr = "0" + hexStr;
					}
					sb.append(hexStr);
				}
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
