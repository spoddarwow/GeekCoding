package learning.graph;

import java.util.ArrayList;
import java.util.Stack;

public class EulerianUAL {

	private ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	private int vCount = 0;
	private boolean[] visited = null;

	public EulerianUAL(int vCount) {
		this.vCount = vCount;
		this.visited = new boolean[this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			graph.add(i, new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {
		EulerianUAL object = new EulerianUAL(5);
		object.addEdge(1, 0);
		object.addEdge(0, 2);
		object.addEdge(2, 1);
		object.addEdge(0, 3);
		object.addEdge(3, 4);
		object.isEulerian();
		object = new EulerianUAL(5);
		object.addEdge(1, 0);
		object.addEdge(0, 2);
		object.addEdge(2, 1);
		object.addEdge(0, 3);
		object.addEdge(3, 4);
		object.addEdge(4, 0);
		object.isEulerian();
		object = new EulerianUAL(5);
		object.addEdge(1, 0);
		object.addEdge(0, 2);
		object.addEdge(2, 1);
		object.addEdge(0, 3);
		object.addEdge(3, 4);
		object.addEdge(1, 3);
		object.isEulerian();
		object = new EulerianUAL(3);
		object.addEdge(0, 1);
		object.addEdge(1, 2);
		object.addEdge(2, 0);
		object.isEulerian();
		object = new EulerianUAL(3);
		object.isEulerian();
	}

	private void isEulerian() {
		boolean isEulerian = isActualEulerian();
		if (!isEulerian) {
			System.out.println("This is not an Eulerian Graph.");
		} else {
			int noOfOddVertex = countNoOfVertexWdOddEdge();
			if (noOfOddVertex <= 2 && isEulerian) {

				if (noOfOddVertex == 2) {
					System.out.println("This is a semi Eulerian Graph.");
				} else if (noOfOddVertex == 0) {
					System.out.println("This is an Eulerian Graph.");
				}

			} else {
				System.out.println("This is not a Eulerian Graph.");
			}
		}
	}

	private int countNoOfVertexWdOddEdge() {
		// TODO Auto-generated method stub
		int noOfVertex = 0;
		for (int i = 0; i < this.vCount; i++) {
			if ((this.graph.get(i).size() % 2 > 0)) {
				noOfVertex++;
			}
		}
		return noOfVertex;
	}

	private boolean isActualEulerian() {
		// TODO Auto-generated method stub
		int i = 0;
		for (; i < this.vCount; i++) {
			if (this.graph.get(i).size() > 0) {
				break;
			}
		}
		if (i == this.vCount) {
			return true;
		}
		dfs(i);
		for (int x = 0; x < this.vCount; x++) {
			if (!this.visited[x] && this.graph.get(x).size() > 0) {
				return false;
			}
		}
		return true;
	}

	private void dfs(int i) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(i);
		int[] path = new int[this.vCount];
		boolean isVertexAvail = false;
		while (!stack.isEmpty()) {
			int key = stack.peek();
			if (!this.visited[key]) {
				this.visited[key] = true;
			}

			isVertexAvail = false;
			ArrayList<Integer> list = graph.get(key);
			for (int listContent : list) {
				if (!this.visited[listContent]) {
					stack.push(listContent);
					path[listContent] = key;
					isVertexAvail = true;
					break;
				}
			}
			if (!isVertexAvail) {
				stack.pop();
			}
		}
		System.out.println(path);
	}

	private void addEdge(int i, int j) {
		ArrayList<Integer> list = graph.get(i);
		list.add(j);
		graph.set(i, list);
		list = graph.get(j);
		list.add(i);
		graph.set(j, list);
	}

}
