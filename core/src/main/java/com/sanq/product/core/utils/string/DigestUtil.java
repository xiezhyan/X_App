package com.sanq.product.core.utils.string;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
	
	/**
	 * 
	 *	version:md5加密
	 *	@param msg	要加密的数据
	 *	@return
	 *----------------------
	 * 	author:xiezhyan
	 *	date:2017-6-5
	 */
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
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
