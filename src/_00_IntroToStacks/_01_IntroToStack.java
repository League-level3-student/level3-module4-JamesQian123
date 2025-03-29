package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
    	Random random = new Random();
    	Double rand = 0.0;
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double> doubes = new Stack();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	for(int i = 0; i < 100; i ++) {
    		rand = random.nextDouble();
    		doubes.push(rand*100);
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	String num = JOptionPane.showInputDialog("please enter a number between 0 and 100");
    	String num2 = JOptionPane.showInputDialog("please enter another number between 0 and 100");
    	Double numasdouble = Double.parseDouble(num);
    	Double num2asdouble = Double.parseDouble(num2);
    	// 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	while(!doubes.isEmpty()) {
	    	Double check = doubes.pop(); 
	    	if(check > numasdouble  && check < num2asdouble) {
	    		System.out.println(check);
	    	}
	    	else if(check < numasdouble && check > num2asdouble) {
	    		System.out.println(check);
	    	}
    	}
        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
