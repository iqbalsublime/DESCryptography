import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Main {

public static void main(String[] argv) {
		
		try{
		    Cipher desCipher;
		    byte[] keyValue = "TheBestS".getBytes();
		    Key key = new SecretKeySpec(keyValue, "DES");
		    // Create the cipher 
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		    
		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, key);

		    //sensitive information
		    byte[] text = "My name is Iqbal".getBytes();

		    System.out.println("Text [Byte Format] : " + text);
		    System.out.println("Text : " + new String(text));
		   
		    // Encrypt the text
		    byte[] textEncrypted = desCipher.doFinal(text);

		    System.out.println("Text Encryted : " + textEncrypted);
		    
		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, key);

		    // Decrypt the text
		    byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		    System.out.println("Text Decryted : " + new String(textDecrypted));
		    
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		} 
	   
	}

}
