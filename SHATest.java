//Message Digest Algorithm - SHA-1

import java.security.MessageDigest;
//import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Hashing {
	
	public static byte[] generate(String msg) throws Exception
	{
	   MessageDigest md = MessageDigest.getInstance("SHA-1");
	   byte[] message = msg.getBytes();
	   md.update(message);
	   byte[] mdbytes = md.digest();
	   return(mdbytes);
	}
	
	public static Boolean verify(byte[] hashValue, String msg) throws Exception
    {
	   /*
	   MessageDigest md = MessageDigest.getInstance("SHA-1");
	   byte[] msgBytes = msg.getBytes();
	   md.update(msgBytes);
	   byte[] mdBytes = md.digest();
	   */
	   
	   byte[] mdBytes = generate(msg);
	  
	   if (MessageDigest.isEqual(hashValue, mdBytes))
		   return true;
	   else
		   return false;
	}
}

public class SHATest {	
	public static void main (String args[]) throws Exception
	{
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the strings: ");
		String str = sc.nextLine();
		System.out.println("The string you entered is : " + str);
		sc.close();
		
		byte hashValue[]= Hashing.generate(str);
		
		//System.out.println("The message digest of your input is : " + hashValue);
		
		System.out.println("The message digest of your input is : " + Arrays.toString(hashValue));
		
		if (Hashing.verify(hashValue, str))
		   System.out.println("Message is valid and not corrupted");
		else
			System.out.println("Message has been corrupted");
	
	}
}
