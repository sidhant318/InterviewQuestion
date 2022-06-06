package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS {
	
	HashMap<String,LinkedList<String>> hm;
	
	BFS(){
		hm=new HashMap<>();
	}

	public static void main(String[] args) {
		BFS g=new BFS();
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
		LinkedList<String> list=new LinkedList<>();
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
