package Graph;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ConnectedComponetType {
	
	LinkedHashMap<Integer, LinkedList<Integer>> adj;

	public ConnectedComponetType() {
		adj=new LinkedHashMap<>();
	}

	public static void main(String[] args) {
		ConnectedComponetType g=new ConnectedComponetType();
		g.addEdge(3,null);
		g.addEdge(4, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 5);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		g.addEdge(8, 6);
		g.addEdge(7, 6);
		g.addEdge(5, 6);
		g.addEdge(1, 2);
		g.addEdge(2, 1);
		System.out.println(g.count());
	}

	private Integer count() {
		Set<Integer> set=new HashSet<>();
		int count=0;
		for(Map.Entry<Integer, LinkedList<Integer>> g:adj.entrySet()) {
			if(count(g.getKey(),set)==true) {
				count++;
			}
		}
		return count;
	}

	private boolean count(Integer key,Set<Integer> set) {
		if(set.contains(key)) return false;
		set.add(key);
		if(adj.get(key)==null) return true;
		for(Integer i:adj.get(key)) {
			count(i,set);
		}
		return true;
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
