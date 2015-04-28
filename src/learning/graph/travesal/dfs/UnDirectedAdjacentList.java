package learning.graph.travesal.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UnDirectedAdjacentList {

	private ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	private boolean[] travesalTrack = null;
	private Stack<Integer> dfsTrack = new Stack<Integer>();

	public void addEdges(int startIndex, int endIndex) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (startIndex < graph.size() && graph.get(startIndex) != null) {
			list = graph.get(startIndex);
		}
		list.add(endIndex);
		if (startIndex < graph.size()) {
			graph.remove(startIndex);
		} else {

		}
		graph.add(startIndex, list);
	}

	public void dfs(int index) {
		travesalTrack = new boolean[graph.size()];
		dfsTrack.push(index);
		travesalTrack[index] = true;
		System.out.println(index);
		while (!dfsTrack.isEmpty()) {
			int newVale = dfsTrack.peek();
			int i = getNextVertex(newVale);
			if (i == -1) {
				dfsTrack.pop();
			} else {
				System.out.println(i);
				dfsTrack.push(i);
				travesalTrack[i] = true;
			}
		}
	}

	private int getNextVertex(int index) {
		int i = -1;
		ArrayList<Integer> list = this.graph.get(index);
		for (int x = 0; x < list.size(); x++) {
			if (!this.travesalTrack[list.get(x)]) {
				i = list.get(x);
				break;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		UnDirectedAdjacentList graph = new UnDirectedAdjacentList();
		graph.addEdges(0, 1);
		graph.addEdges(1, 0);
		graph.addEdges(0, 2);
		graph.addEdges(2, 0);
		graph.addEdges(1, 3);
		graph.addEdges(3, 1);
		graph.dfs(0);
	}
}
