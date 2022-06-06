package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LargestNodeInGraph {
	
	LinkedHashMap<Integer, LinkedList<Integer>> adj;
	
	public LargestNodeInGraph() {
		adj=new LinkedHashMap<Integer, LinkedList<Integer>>();
	}

	public static void main(String[] args) {
		LargestNodeInGraph g=new LargestNodeInGraph();
		g.addEdge(0,8);
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(1, 0);
		g.addEdge(5, 0);
		g.addEdge(5, 8);
		g.addEdge(8, 0);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 3);
		g.addEdge(4, 2);
System.out.println(g.countLarge());
	}

	private Integer countLarge() {
		Set<Integer> set=new HashSet<>();
		int longest=0;
		for(Map.Entry<Integer, LinkedList<Integer>> hm:adj.entrySet()) {
			int size=countLarge(hm.getKey(),set);
			if(size>longest) {
				longest=size;
			}
		}
		return longest;
	}

	private Integer countLarge(Integer key,Set<Integer> set) {
		if(set.contains(key)) return 0;
		set.add(key);
		int size=1;
		for(Integer i:adj.get(key)) {
			size+=countLarge(i,set);
		}
		return size;
	}

	private void addEdge(Integer i, Integer j) {
		if(adj.containsKey(i)) {
			LinkedList<Integer> tmp=adj.get(i);
			tmp.add(j);
		}
		else {
			LinkedList<Integer> tmp=new LinkedList<>();
			tmp.add(j);
			adj.put(i, tmp);
		}
	}

}
