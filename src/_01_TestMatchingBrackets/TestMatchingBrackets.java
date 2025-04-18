package _01_TestMatchingBrackets;

import java.util.ArrayList;
import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> brackets = new Stack<Character>();
    	Character bracket;
    	for(int i = 0;i <b.length();i++) {
    		if(b.charAt(i) =='{'){
    			brackets.push(b.charAt(i));
    		}
    		if(b.charAt(i) =='}') {
    			if(brackets.size() != 0) {
    				brackets.pop();
    			}
    			else {
    				return false;
    			}
    		}
    	}
    	if(brackets.size() == 0) {
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}