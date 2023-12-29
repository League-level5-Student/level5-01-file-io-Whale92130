package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	JFrame frame = new JFrame("ToDoList");
	JPanel panel = new JPanel();
	JButton add = new JButton("add task");
	JButton view = new JButton("view tasks");
	JButton remove = new JButton("remove task");
	JButton save = new JButton("save task");
	JButton load = new JButton("load task");
	ArrayList<String> list = new ArrayList<String>();

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	void run() {

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.addActionListener(e -> {
			addTask();
		});
		view.addActionListener(e -> {
			viewTasks();
		});
		remove.addActionListener(e -> {
			removeTask();
		});
		save.addActionListener(e -> {
			saveTask();
		});
		load.addActionListener(e -> {
			loadTask();
		});
		frame.pack();
		frame.setVisible(true);
		startUp();
	}

	void addTask() {
		list.add(JOptionPane.showInputDialog("Enter item for your To-Do list"));
	}

	void viewTasks() {
		String output = "";
		for (int i = 0; i < list.size(); i++) {
			output += i + ": " + list.get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}

	void removeTask() {
		String output = "";
		for (int i = 0; i < list.size(); i++) {
			output += i + ": " + list.get(i) + "\n";
		}
		String remove = JOptionPane.showInputDialog("Enter the number of the item you wish to remove\n" + output);
		list.remove(Integer.parseInt(remove));
	}

	void saveTask() {

		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/To_Do_List.txt");
			System.out.println("saving");
			/*
			 * NOTE: To append to a file that already exists, add true as a second parameter
			 * when calling the FileWriter constructor. (e.g. FileWriter fw = new
			 * FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			 */
			String output = "";
			for (int i = 0; i < list.size(); i++) {
				output += i + ": " + list.get(i) + "\n";
			}
			fw.write(output);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void loadTask() {
		String fileName = "";
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			String line = br.readLine();
			while (line != null) {
				list.add(line.split(":")[1].trim());
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void startUp() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/To_Do_List.txt"));

			String line = br.readLine();
			while (line != null) {
				list.add(line.split(":")[1].trim());
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
