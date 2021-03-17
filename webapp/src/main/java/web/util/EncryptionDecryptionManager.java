package web.util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import web.controller.WizardController;
 
public class EncryptionDecryptionManager {
	//private static final Logger mLog = LoggerFactory.getLogger(EncryptionDecryptionManager.class.getName());
	private static final Logger mLog = LoggerFactory.getLogger(EncryptionDecryptionManager.class);
	
	private static SecretKeySpec secretKey;
	    private static byte[] key;
	  
	    public static String decode(String valueToEncode) {
	    	try {
	    		mLog.info("valueToEncode [ " + valueToEncode + "]");
				String decodeValue = java.net.URLDecoder.decode(valueToEncode, StandardCharsets.UTF_8.toString());
			    return decodeValue;
	    	} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
	    		mLog.error(e.getMessage());
				//e.printStackTrace();
			}
	    return null;
	    }
	 public static String encode(String valueToEncode) {
		String encodedValue = null;
		try {
			mLog.info("valueToEncode [ " + valueToEncode + "]");
			encodedValue = URLEncoder.encode( valueToEncode, StandardCharsets.UTF_8.toString());
			mLog.info("encodedValue [ " + encodedValue + "]");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			mLog.error(e.getMessage());
		}
	    return encodedValue;
	 }
	   static 
	    {
	    	String myKey = "test";
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes("UTF-8");
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKey = new SecretKeySpec(key, "AES");
	        } 
	        catch (NoSuchAlgorithmException e) {
	        	mLog.error(e.getMessage());
	            
	        } 
	        catch (UnsupportedEncodingException e) {
	        	mLog.error(e.getMessage());
	        }
	    }
	   public static String encrypt(Integer intToEncrypt)  {
		   String encrypt = encrypt(intToEncrypt.toString()) ; 
		   return encrypt;
	   }
	    public static String encrypt(String strToEncrypt) 
	    {
	        try
	        {
	            
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            String encrptyValue = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	            mLog.info("encrptyValue [" + encrptyValue + "]");
	            
	            //encrptyValue = encode(encrptyValue);
	            //mLog.info("encode [" + encrptyValue + "]");
	            return encrptyValue;
	        } 
	        catch (Exception e) 
	        {
	        	mLog.error("Error while encrypting: " + e.toString());
	        }
	        return null;
	    }
	 
	    public static String decrypt(String strToDecrypt) 
	    {
	        try
	        {
	            //decode first
	        	mLog.info("strToDecrypt [" + strToDecrypt + "]");
	        	//String decodeValue = decode(strToDecrypt);
	        	//mLog.info("decodeValue [" + decodeValue + "]");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	        } 
	        catch (Exception e) 
	        {
	            mLog.error("Error while decrypting: " + e.toString());
	        }
	        return null;
	    }
}
