//Digital Signature Algorithm - DSA with SHA-1

import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;
//import java.io.*;


class DigitalSignature
{
	public static byte[] sign(byte message[],PrivateKey prvk) throws Exception
	{
		Signature sg = Signature.getInstance("SHA1withDSA");
	    sg.initSign(prvk);
	    sg.update(message);
	    return sg.sign();
	}


	public static boolean verify (byte message[], PublicKey pubk, byte[] signature) throws Exception
	{
   	    Signature sg = Signature.getInstance("SHA1withDSA");
	    sg.initVerify(pubk);
	    sg.update(message);
	    return sg.verify(signature);
	}
}


public class DSATest 
{
	public static void main(String args[]) throws Exception 
	{
	    // Generate a key-pair
	    
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
	    kpg.initialize(512); // 512 is the key size.
	    KeyPair kp = kpg.generateKeyPair();
	    PublicKey pubk = kp.getPublic();
	    PrivateKey prvk = kp.getPrivate();

	    //InputStreamReader isr = new InputStreamReader( System.in );
	    //BufferedReader stdin = new BufferedReader( isr );
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println( "Enter the message" );
	    String input = sc.nextLine();
	    System.out.println( "Your input = " + input );
	    //int x = Integer.valueOf(input);
	    //System.out.println("Integer x  = " + x);
	    sc.close();

	    byte[] message = input.getBytes();
	    byte[] signature = DigitalSignature.sign(message, prvk);

	    String str1 = new String(signature);
	    System.out.println("The signature of input data : " + str1);    
	    
	    boolean result = DigitalSignature.verify(message, pubk, signature);
	    System.out.println("Signature Verification Result = " + result);
	     
	 }
}



