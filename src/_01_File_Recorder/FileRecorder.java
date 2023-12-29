package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/yourMessage.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			Scanner scan = new Scanner(System.in);
			System.out.println("Give me a message and it will apear in the yourMessage text file");
			fw.write(scan.nextLine());
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
