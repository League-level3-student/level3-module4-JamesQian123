package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> character = new Stack();
	
	public _02_TextUndoRedo() {
		frame.add(panel);
		panel.add(label);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}















	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}















	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char letter = e.getKeyChar();
		label.setText(label.getText() + letter);
		character.push(label.getText());
		if(e.getExtendedKeyCode()==8) {
			
			System.out.println("A");
			if(character.size()>0) {
				System.out.println("B");
				character.pop();
				label.setText(character.peek());
			}
		
		}
		
		
	}















	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
