package GeneralString;

import java.util.Stack;

public class RepeatativeCharacter {

	public static void main(String[] args) {
		String inputStr="abcdeabcdeaaedcb";
		String output=removeRepeatative(inputStr);
		String output1=removeRepeatative1(inputStr);
		System.out.println(output);
		System.out.println(output1);
	}

	private static String removeRepeatative1(String inputStr) {
		Stack<Character> s=new Stack<>();
		for(Character c:inputStr.toCharArray()) {
			if(!s.isEmpty() && s.peek()==c) {
				s.pop();
			}
			else {
				s.push(c);
			}
		}
		String output="";
		while(!s.isEmpty()) {
			output=s.pop()+output;
		}
		return output;
	}

	private static String removeRepeatative(String inputStr) {
		boolean b=false;
		int i;
		for(i=1;i<inputStr.length();i++) {
			if(inputStr.charAt(i)==inputStr.charAt(i-1)) {
				b=true;
				break;
			}
		}
		if(b)
			inputStr=removeRepeatative(inputStr.substring(0, i-1)+inputStr.substring(i+1, inputStr.length()));
			
	return inputStr;
		
	}

}
