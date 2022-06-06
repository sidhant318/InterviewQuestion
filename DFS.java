package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	HashMap<String,LinkedList<String>> hm;
	
	DFS(){
		hm=new HashMap<>();
	}
	
	public static void main(String[] args) {
		DFS g=new DFS();
		g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "C");
        g.addEdge("C", "A");
        g.addEdge("C", "D");
        g.addEdge("D","D");
        g.print("C");

	}
	
	private void print(String str) {
		HashSet<String> h=new HashSet<>();
		Stack<String> list=new Stack<>();
		list.add(str);
		h.add(str);
		while(list.size()>0) {
			String tmp=list.pop();
			System.out.println(tmp);
			LinkedList<String> tmpList=hm.get(tmp);
			for(String t:tmpList) {
				if(!h.contains(t)) {
					h.add(t);
					list.add(t);
				}
			}
		}
	}
	
	private void addEdge(String str1, String str2) {
		if(hm.containsKey(str1)) {
			LinkedList<String> l=hm.get(str1);
			l.add(str2);
		}
		else {
			LinkedList<String> l=new LinkedList<>();
			l.add(str2);
			hm.put(str1,l);
		}
	}

}
