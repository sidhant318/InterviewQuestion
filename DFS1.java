package Graph;

import java.util.LinkedList;
import java.util.ListIterator;

public class DFS1 {
	
	private LinkedList<Integer> adj[];
	int vertix;
	
	DFS1(int v){
		this.vertix=v;
		adj=new LinkedList[this.vertix];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		DFS1 g=new DFS1(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(2);
	}

	private void DFS(int start) {
		boolean visited[]=new boolean[this.vertix];
		DFS(start,visited);
	}

	private void DFS(int start, boolean[] visited) {
		visited[start]=true;
		System.out.println(start);
		LinkedList<Integer> listArray=adj[start];
		ListIterator<Integer> iterators=listArray.listIterator();
		while(iterators.hasNext()) {
			int i=iterators.next();
			if(!visited[i]) {
				DFS(i,visited);
			}
		}
	}

	private void addEdge(int source, int des) {
		adj[source].add(des);
	}

}
