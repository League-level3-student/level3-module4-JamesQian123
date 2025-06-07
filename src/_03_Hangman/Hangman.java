package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	String mysteryWord;
	Stack<String> words = new Stack();
	Utilities utilites = new Utilities();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	int lives = 10;
	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		frame.add(panel);
		panel.add(label);
		frame.add(label2);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		String number = JOptionPane.showInputDialog("Choose a number between 0 and 266");
		int numbr = Integer.parseInt(number);

		// for loop that has all of the below:
		for (int i = 0; i < numbr; i++) {
			String randomword = utilites.readRandomLineFromFile("dictionary.txt");
			words.push(randomword);
			if (words.contains(randomword)) {
				words.remove(i);
				randomword = utilites.readRandomLineFromFile("dictionary.txt");
				words.push(randomword);

			}
		}
		mysteryWord = words.pop();
		System.out.println(mysteryWord);
		int charCount = mysteryWord.length();
		for (int i = 0; i < charCount; i++) {
			label.setText(label.getText() + "_");
		}
		label2.setText("Lives: " + lives);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		char key = arg0.getKeyChar();
		if (mysteryWord.contains(String.valueOf(key))) {
			ArrayList<Integer> locations = new ArrayList();
			int start = 0;
			while (true) {
				int loc = mysteryWord.indexOf(key, start);
				if (loc != -1) {
					locations.add(loc);
					start = loc + 1;
					if (start > mysteryWord.length() - 1) {
						break;
					}
				} else {
					break;
				}
			}

			StringBuilder stringbuilder = new StringBuilder(label.getText());
			for (int i = 0; i < locations.size(); i++) {
				if(locations.get(i) != key) {
					lives--;
					label2.setText("Lives :" + lives);
				}
				String keyAsString = Character.toString(key);
				stringbuilder.replace(locations.get(i), locations.get(i)+1, keyAsString);
			}
			label.setText(stringbuilder.toString());
		}
	}
}
