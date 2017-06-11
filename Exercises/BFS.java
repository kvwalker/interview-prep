public class BFS {

	public boolean search (int n) {
		if (root.data == n) {
			return true;
		}
		Queue q = new Queue();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.enqueue(root);

		while (!q.isEmpty()) {
			Node curr = q.dequeue();

			if (curr.data == n) {
				return true;
			}

			if (visited.contains(curr.data)) {
				continue;
			}
			visited.add(curr.data);
			
			for (Node child : curr.neighbors) {
				q.enqueue(child);
			}
		}
	}
}