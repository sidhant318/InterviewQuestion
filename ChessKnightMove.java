package Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Node {
	int x, y, distance;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

}

class Result {
	public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
		
		
		int row[]= {-2,-2,2,2,-1,-1,1,1};
		int col[]= {-1,1,-1,1,-2,2,-2,2};
		
		Node src = new Node(startRow, startCol);
		Set<Node> visited = new HashSet<>();
		Queue<Node> q = new ArrayDeque<>();
		q.add(src);
		while (!q.isEmpty()) {
			Node val = q.poll();
			int x = val.x;
			int y = val.y;
			int distance = val.distance;

			if (x == endRow && y == endCol) {
				return distance;
			}

			if (!visited.contains(val)) {
				visited.add(val);
				for (int i = 0; i < row.length; i++) {
					int x1 = x + row[i];
					int y1 = y + col[i];
					if (isValid(x1, y1, n)) {
						q.add(new Node(x1, y1, distance + 1));
					}
				}
			}
		}
		return -1;
	}

	private static boolean isValid(int x, int y, int n) {
		return (x >= 0 && x < n) && (y >= 0 && y < n);
	}
}

public class ChessKnightMove {

	public static void main(String[] args) {
		Result result = new Result();
		int val = result.minMoves(9, 4, 4, 4, 8);
		System.out.println(val);
	}

}
