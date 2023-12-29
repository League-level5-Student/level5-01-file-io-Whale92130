package _04_Directory_Iteration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		// /Users/league/git/level5-01-file-io-Whale92130/src

		File file = new File("/Users/league/git/level5-01-file-io-Whale92130/src");
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
				File file2 = f;
				File[] files2 = file2.listFiles();
				for (File f2: files2) {
					System.out.println(f2.getAbsolutePath());
					if (f2.getAbsolutePath().contains(".java")) {
						try {
							FileWriter fw = new FileWriter(f2.getAbsolutePath(), true);
							
							/*
							NOTE: To append to a file that already exists, add true as a second parameter when calling the
							      FileWriter constructor.
							      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
							*/
							
							fw.write("//Copyright © 2023 Alexander Sementchenko");
								
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
	}
}
//Copyright © 2023 Alexander Sementchenko