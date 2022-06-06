package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DJ {
	
	class Edge{
		int source;
		int destination;
		int weight;
		
		public Edge(int source,int destination,int weight) {
			this.source=source;
			this.destination=destination;
			this.weight=weight;
		}
	}
	
	int vertix;
	HashMap<Integer, LinkedList<Edge>> hm;
	
	DJ(int vertix){
		this.vertix=vertix;
		hm=new HashMap<>();
	}

	public static void main(String[] args) {
		DJ d=new DJ(7);
		d.addEdge(0,1,2);
		d.addEdge(0,2,6);
		d.addEdge(1,3,5);
		d.addEdge(2,3,8);
		d.addEdge(3,5,15);
		d.addEdge(3,4,10);
		d.addEdge(5,4,1);
		d.addEdge(5,6,6);
		d.addEdge(4,6,2);
		d.printDijkstra(0);

	}

	
	
	
	private void printDijkstra(int src) {
		PriorityQueue<Pair> p=new PriorityQueue<>();
		p.add(new Pair(src, src+"", 0));
		HashSet<Integer> h=new HashSet<Integer>();
		h.add(src);
		while(p.size()>0) {
			Pair tmp=p.remove();
			System.out.println(tmp.v+" via "+tmp.vsf+" @ "+tmp.wt);
			LinkedList<Edge> list=hm.get(tmp.v);
			for(Edge e:list) {
				if(!h.contains(e.destination)) {
					h.add(e.destination);
					p.add(new Pair(e.destination,tmp.vsf+e.destination,tmp.wt+e.weight));
				}
			}
		}
	}

	private void addEdge(int i, int j, int k) {
		if(hm.containsKey(i)){
			LinkedList<Edge> list=hm.get(i);
			list.add(new Edge(i, j, k));
		}
		else {
			LinkedList<Edge> list=new LinkedList<DJ.Edge>();
			list.add(new Edge(i, j, k));
			hm.put(i, list);
		}
		if(hm.containsKey(j)){
			LinkedList<Edge> list=hm.get(j);
			list.add(new Edge(j, i, k));
		}
		else {
			LinkedList<Edge> list=new LinkedList<DJ.Edge>();
			list.add(new Edge(j, i, k));
			hm.put(j, list);
		}
	}
	
	class Pair implements Comparable<Pair>{
		int v;
		String vsf;
		int wt;
		
		Pair(int v,String vsf,int wt){
			this.v=v;
			this.vsf=vsf;
			this.wt=wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt-o.wt;
		}
		
	}

}
