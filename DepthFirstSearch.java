import java.util.ArrayList;
import java.util.Scanner;

public class DepthFirstSearch {

    static void dfs(
            ArrayList<ArrayList<Integer>> graph,
            boolean[] visited,
            int vertex) {

        visited[vertex] = true;

        System.out.print(vertex + " ");

        for (int neighbor : graph.get(vertex)) {

            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges:");

        for (int i = 0; i < edges; i++) {

            int source = sc.nextInt();
            int destination = sc.nextInt();

            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        boolean[] visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");

        dfs(graph, visited, start);

        sc.close();
    }
}
