package Stack;

import java.util.Stack;

public class StackMinimumElement {
	Stack<Integer> s=new Stack<>();
	int min=0;
	public static void main(String[] args) {
		StackMinimumElement s=new StackMinimumElement();
		s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();

	}


	private int pop() {
		int x=s.pop();
		int e=x;
		if(x<min) {
			e=min;
			min=2*min-x;
		}
		return x;
		
	}

	private int getMin() {
		return min;
	}

	private void push(int x) {
		if(s.isEmpty()) {
			s.push(x);
			min=x;
		}
		else {
			if(x<min) {
				s.push(2*x-min);
				min=x;
			}
			else {
				s.push(x);
			}
		}
		
		
	}

}
