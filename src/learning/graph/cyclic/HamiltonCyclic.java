package learning.graph.cyclic;

import java.util.ArrayList;
import java.util.Stack;

public class HamiltonCyclic {

	private ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	private int vCount;

	public HamiltonCyclic(int vCount) {
		this.vCount = vCount;
		for (int i = 0; i < vCount; i++) {
			graph.add(i, new ArrayList<Integer>());
		}
	}

	public void isHamiltonCyclic() {
		boolean[] isVisited = new boolean[this.vCount];
		boolean isHC = false;
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		while (!isHC && !s.isEmpty()) {
			int key = s.peek();
			boolean toBPopped = true;
			isVisited[key] = true;
			ArrayList<Integer> edges = graph.get(key);
			for (Integer i : edges) {
				if (!isVisited[i]) {
					s.push(i);
					toBPopped = false;
					break;
				} else if (i == 0 && s.size() == vCount) {
					isHC = true;
					break;
				}
			}
			if (toBPopped) {
				isVisited[s.pop()] = false;
			}
		}
		System.out.println("isHC : " + isHC);
		System.out.println("Stack : " + s);
	}

	private void addEdge(int src, int end) {
		ArrayList<Integer> gList = graph.get(src);
		gList.add(end);
		graph.set(src, gList);
		gList = graph.get(end);
		gList.add(src);
		graph.set(end, gList);

	}

	public static void main(String[] args) {
		HamiltonCyclic cyclicGraph = new HamiltonCyclic(5);
		cyclicGraph.addEdge(0, 1);
		cyclicGraph.addEdge(0, 3);
		cyclicGraph.addEdge(1, 3);
		cyclicGraph.addEdge(1, 4);
		cyclicGraph.addEdge(1, 2);
		cyclicGraph.addEdge(2, 4);
		cyclicGraph.addEdge(3, 4);
		cyclicGraph.isHamiltonCyclic();
	}

}
