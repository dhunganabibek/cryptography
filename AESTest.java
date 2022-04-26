//Symmetric Cryptosystem - AES (than DES)

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.util.Scanner;

class Encryption
{
	static byte[] encrypt(byte s[], Cipher c, SecretKey sk) throws Exception
	{
	    c.init(Cipher.ENCRYPT_MODE, sk);
	    return c.doFinal(s);
	}

	static byte[] decrypt(byte s[], Cipher c, SecretKey sk) throws Exception
	{
	    c.init(Cipher.DECRYPT_MODE, sk);
	    return c.doFinal(s);
	}
}

public class AESTest {
	public static void main(String args[]) throws Exception 
	{
	try{
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		SecretKey key = keygen.generateKey();
		
		Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
		//Electronic Code Book mode
		//128 bits

		//BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data: ");
		String str = sc.nextLine();
		System.out.println("The string you entered is: " + str);
	   	sc.close();
			
		byte[] cleartext = str.getBytes();
	   	byte[] ciphertext = Encryption.encrypt(cleartext, aesCipher, key);
	   	String str2 = new String(ciphertext);
	   	System.out.println("The encrypted data is: " + str2);

		byte[] plaintext = Encryption.decrypt(ciphertext, aesCipher, key);
		String str3 = new String(plaintext);
		System.out.println("The data after decryption is: " + str3);
	 	}
		catch (Exception e){
	 		e.printStackTrace();
	 	}
	}
}

