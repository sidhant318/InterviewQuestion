package General;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LRU {
	
	int size;
	Queue<Integer> q;
	HashSet<Integer> h;
	
	LRU(int size){
		this.size=size;
		q=new LinkedList<>();
		h=new HashSet<Integer>();
	}

	public static void main(String[] args) {
		LRU cache=new LRU(4);
		cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(1);
        cache.put(4);
        cache.put(5);
        cache.put(2);
        cache.put(2);
        cache.put(1);
        cache.display();

	}

	private void put(int i) {
		if(!h.contains(i)) {
			if(h.size()==size) {
				int rem=q.remove();
				h.remove(rem);
			}
		}
		else {
			q.remove(i);
		}
		
		q.add(i);
		h.add(i);
		
	}

	private void display() {
		Iterator<Integer> i=q.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

}
