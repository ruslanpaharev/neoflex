package support;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MySecurity {
	
	public static String getHashCodeDigest(String text) {
		
		String mess = "";
				
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] inputBytes = text.getBytes();
			digest.update(inputBytes);
			byte[] hashedBytes = digest.digest();
			mess = convertByteArrayToHexString(hashedBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
				
		return mess;
	}
	
	private static String convertByteArrayToHexString(byte[] arrayBytes){
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		return stringBuffer.toString();
	}
	
}
