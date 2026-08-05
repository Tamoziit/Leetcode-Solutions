/**
 * DFS + Searching
 * Time: O(V + E)
 * Space: O(V + E)
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SuspiciousMethods {

    @SuppressWarnings("unchecked")
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];

        // creating adjacency list
        for (int[] inv : invocations) {
            edges[inv[0]].add(inv[1]);
            inDegree[inv[1]]++;
        }

        // Determining whether any normal method can reach a suspicious method
        // After the traversal is complete, the remaining in-degree of each suspicious node represents the number of incoming edges from normal nodes.
        // performing DFS from node k
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : edges[u]) {
                inDegree[v]--; // removing the traversed edge

                // visited from k = suspicious
                if (!suspicious[v]) {
                    queue.offer(v);
                    suspicious[v] = true;
                }
            }
        }

        boolean canRemoveAll = true; // all suspicious methods can be removed
        List<Integer> remaining = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // If any suspicious node has a non-zero in-degree, then there exists a normal method that calls a suspicious method.
            if (suspicious[i] && inDegree[i] > 0) {
                canRemoveAll = false;
                break;
            } else if (!suspicious[i]) {
                remaining.add(i); // normal method
            }
        }

        // building final ans for both cases: all methods are suspicious/some are safe
        if (!canRemoveAll) {
            List<Integer> allNodes = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                allNodes.add(i);
            }

            return allNodes;
        }

        return remaining;
    }
}
