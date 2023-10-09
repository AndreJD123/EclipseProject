

package CSS1035SECUREBANK;

import java.text.Normalizer;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.spec.SecretKeySpec;
//import java.io.UnsupportedEncodingException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Arrays;
//import java.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;

//import java.util.logging.*;
public class Bankingapplicationatm {
	private static SecretKeySpec secretKey;
		
	
	
	
	public static void main(String[] args) {



		String s = "\uFE64" + "script" + "\uFE65";
		System.out.println("String we will normalize is the following: " + s);
		s = Normalizer.normalize(s, Normalizer.Form.NFKC);
		System.out.println("String we normalized is the following: " + s);
		Pattern pattern = Pattern.compile("[<>]");
		System.out.println("We will validate by looking for and throwing exception on the pattern:"+pattern);

		Matcher matcher = pattern.matcher(s);
		
		 

		try (Scanner sc = new Scanner(System.in)) {

			try {
				System.out.println("Hello, Welcome to Team 4 ATM \n What's your name?");
				String fname = sc.next();
				System.out.println("Nice to meet you " + fname);
				//String plaintext = "Sensitive information";
				String phonykey = "phonykey"; //weak key !!!beware

				System.out.println("input text : " + fname);
				System.out.println("input text : " + phonykey);

				String encryptedString = encrypt(fname, phonykey);

				// encryption pass       
				System.out.println("cipher text: " + encryptedString);

				String decryptedString = decrypt(encryptedString, phonykey);
				


				// decryption pass
				System.out.println("plain text : " + decryptedString );
				System.out.println("Do you want to open a (c)checking or (s)saving accounts?");
				String accounttype = sc.next();
				if (accounttype.equals("c")) {
					System.out.println("Ok, You want to enter a (a)account type? " + accounttype);
					CheckingAccount ca = new CheckingAccount();
					System.out.println("How much do you want to deposit?");
					String deposit = sc.next();
					ca.deposit((new Integer(deposit)).intValue());
					System.out.println("Your new balance is: " + ca.getbalance());
					System.out.println("How much do you want to withdrawl?");//risk:can deposit more then you have deposited
					String withdrawl = sc.next();
					ca.withdrawl((new Integer(withdrawl)).intValue());
					System.out.println("Your new balance is: " + ca.getbalance());//risk:make sure the balance is accurate
				}

				if (accounttype.equals("s")) {
					System.out.println("Ok, You want to enter a (a)account type? " + accounttype);
					SavingAccount sa = new SavingAccount();
					System.out.println("How much do you want to deposit?");
					String deposit = sc.next();
					sa.deposit((new Integer(deposit)).intValue());
					System.out.println("Your new balance is: " + sa.getbalance());
					System.out.println("How much do you want to withdrawl?");//risk the amount of money withdrawl can succeed the amount of money in your bank
					String withdrawl = sc.next();
					sa.withdrawl((new Integer(withdrawl)).intValue());
					System.out.println("Your new balance is: " + sa.getbalance());//risk: could get a wrong balance
				}
				// String querybeforeencoding = "<>";  
				// System.out.println("Here is our URL before encoding: " + querybeforeencoding);
				// System.out.println("Here is our URL after encoding: " + buildEncodedUrl(querybeforeencoding));
			} catch (InputMismatchException ex) {
				System.out.println("Try again. (" + "Incorrect input: an integer is required)");
				sc.nextLine(); 
			}
			catch (OverDraftException ex) {
				System.out.println("Try again. (" + "Overdraft, Must pay a fee.) ");
				sc.nextLine(); 
			}
			finally {
			}
			int number1 = sc.nextInt();
			int number2 = sc.nextInt();

			if (number2 != 0)
				System.out.println(number1 + " / " + number2 + " is " + (number1 / number2));
			else
				System.out.println("Divisor cannot be zero ");
			if (matcher.find()) {
				System.out.println("Invalid pattern found during analysis!  Throwing exception");


				throw new IllegalStateException();
			} else {

			}
			
		} 
	}
	static String buildEncodedUrl(String q) {
		String encodedUrl = "https://example.com?query=" + Base64.getUrlEncoder().encodeToString(q.getBytes());

		return encodedUrl;
	}

	public static String encrypt(String strToEncrypt, String secret) 
	{
		try
		{
			//setKey(secret);
			moreRandomSetKey();
			//the SunJCE provider uses ECB as the default mode, and PKCS5Padding as the default padding scheme
			Cipher cipher = Cipher.getInstance("AES"); //Better choice "AES/GCM/PKCS5Padding"  or "AES/GCM/NoPadding" (based on bug report https://bugs.openjdk.java.net/browse/JDK-8229043)
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} 
		catch (Exception e) 
		{
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt, String secret) 
	{
		try
		{
			//the SunJCE provider uses ECB as the default mode, and PKCS5Padding as the default padding scheme
			Cipher cipher = Cipher.getInstance("AES");  //Better choice "AES/GCM/PKCS5Padding"  or  "AES/GCM/NoPadding" (based on bug report https://bugs.openjdk.java.net/browse/JDK-8229043)
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} 
		catch (Exception e) 
		{
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}


	public static void moreRandomSetKey() {

		try {
			SecureRandom secureRandom = new SecureRandom();
			byte[] key = new byte[32];
			secureRandom.nextBytes(key);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



