package General;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


class LNode{
	int key;
	int value;
	LNode prev;
	LNode next;
	LNode(int key,int value){
		this.key=key;
		this.value=value;
		prev=next=null;
	}
}
public class LRUCache {
	private HashMap<Integer, LNode> hm;
	private int capacity,count;
	private LNode head;
	LRUCache(int capacity){
		this.capacity=capacity;
		 hm=new HashMap<Integer, LNode>();
		count=0;
		head=null;
	}
	public static void main(String[] arg) {
		LRUCache cache=new LRUCache(4);
		cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(1,1);
        cache.put(4,4);
        cache.put(5,5);
        cache.put(2,2);
        cache.put(2,2);
        cache.put(1,1);
		
		//u.get(3);
		cache.print();
	}
//	private int get(int key) {
//		if(hm.get(key)!=null) {
//			LNode node=hm.get(key);
//			deleteNode(node);
//			addToHead(node);
//			return node.value;
//		}
//		else {
//			System.out.println("Data is not there");
//			return -1;
//		}
//	}
	private void print() {
		LNode tmp=head;
		while(tmp!=null) {
			System.out.println(tmp.key);
			tmp=tmp.next;
		}
		
	}
	private void put(int key, int value) {
		//System.out.println("Going to set key "+key+" value : "+value);
		if(hm.get(key)!=null) {
			LNode node=hm.get(key);
			node.value=value;
			deleteNode(node);
			addToHead(node);
		}
		else {
			LNode node=new LNode(key, value);
			hm.put(key, node);
			if(count<capacity) {
				count++;
				addToHead(node);
			}
			else {
				LNode tmp=head;
				while(tmp.next!=null) {
					tmp=tmp.next;
				}
				hm.remove(tmp.key);
				deleteNode(tmp);
				addToHead(node);
			}
		}
	}
	private void addToHead(LNode n) {
		n.next=head;
		n.prev=null;
		if(head!=null)
			head.prev=n;
		head=n;
	}
	private void deleteNode(LNode node) {
		if(head==node)
			head=node.next;
		if (node.next != null) {
			node.next.prev = node.prev;
        }
        if (node.prev != null) {
        	node.prev.next = node.next;
        }
		
	}
	
}
