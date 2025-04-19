package _03_Hangman;

import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
public static void main(String[] args) {
	Stack<String> words = new Stack();
	Utilities utilites = new Utilities();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	String number = JOptionPane.showInputDialog("Choose a number between 0 and 266");
	int numbr = Integer.parseInt(number);
	
	//for loop that has all of the below:
	for(int i = 0; i < numbr; i++) {
		String randomword = utilites.readRandomLineFromFile("dictionary.txt");
		words.push(randomword);
		if(words.contains(randomword)) {
			words.remove(i);
			randomword = utilites.readRandomLineFromFile("dictionary.txt");
			words.push(randomword);
			
		}
	}
	}
}
