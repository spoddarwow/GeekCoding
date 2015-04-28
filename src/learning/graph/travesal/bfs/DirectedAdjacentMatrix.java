package learning.graph.travesal.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedAdjacentMatrix {

	public static void bfs(int index, int[][] graph, int vertexCount) {
		boolean[] travesalTrack = new boolean[vertexCount];
		Queue<Integer> bfs = new LinkedList<Integer>();
		bfs.add(index);
		travesalTrack[index] = true;
		while (!bfs.isEmpty()) {
			int node = bfs.poll();
			travesalTrack[node] = true;
			System.out.println(node);
			getAllNode(node, bfs, vertexCount, travesalTrack, graph);
		}
	}

	private static void getAllNode(int node, Queue<Integer> bfs,
			int vertexCount, boolean[] travesalTrack, int[][] graph) {
		for (int i = 0; i < vertexCount; i++) {
			if (graph[node][i] == 1 && !travesalTrack[i]) {
				travesalTrack[i] = true;
				bfs.add(i);
			}
		}

	}
}
