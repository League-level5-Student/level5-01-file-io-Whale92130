package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/message.txt"));
			Scanner scan = new Scanner(System.in);
			System.out.println("Give key");
			int key = scan.nextInt();
			String message = br.readLine();
			br.close();
			String weturn = "";
			char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			for (int i = 0; i < message.length(); i++) {
				if (message.charAt(i) == ' ') {
					weturn += " ";
				}
				for (int o = 0; o < alpha.length; o++) {
					if (message.toLowerCase().charAt(i) == alpha[o]) {
						if (o - key < 0) {
							weturn += alpha[o - key + 26];
						} else {
							weturn += alpha[o - key];
						}
					}
				}
			}
			System.out.println("weturn: " + weturn);
			JOptionPane.showMessageDialog(null, "The decrypted messgae is: " + weturn);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//Copyright © 2023 Alexander Sementchenko