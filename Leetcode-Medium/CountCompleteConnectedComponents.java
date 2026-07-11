/**
 * DFS + Connected Component
 * Time: O(V + E)
 * Space: O(V + E) for Adjacency List
 */
import java.util.ArrayList;
import java.util.List;

public class CountCompleteConnectedComponents {

    private List<List<Integer>> adj; // adjacency list
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {
        // creating adj. list
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];

            // undirected graph
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        visited = new boolean[n];
        int res = 0; // CCC. count

        for (int v = 0; v < n; v++) {
            if (visited[v]) {
                continue;
            }

            // no. of nodes in connected components
            List<Integer> component = new ArrayList<>();

            dfs(v, component); // running DFS to store all nodes of a connected component in `component` list

            boolean isComplete = true;
            for (int node : component) {
                // if there a 'k' no. of nodes in connected complete
                // for the component to be complete, each node of the component should be connected with:
                // component.size() - 1 = k - 1 node -> if not, the CC is not complete
                if (component.size() - 1 != adj.get(node).size()) {
                    isComplete = false;
                    break;
                }
            }

            if (isComplete) {
                res++;
            }
        }

        return res;
    }

    private void dfs(int v, List<Integer> component) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        component.add(v); // adding node to the component list of this CC

        for (int neighbour : adj.get(v)) { // recursively running DFS over all neighbours of curr. node
            dfs(neighbour, component);
        }
    }
}
