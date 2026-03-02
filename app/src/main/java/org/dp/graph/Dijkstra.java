package org.dp.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * Name: Dijkstra's Algorithm
 * Description:
 * Given a weighted undirected graph and a source vertex src.
 * We need to find the shortest path distances from the source vertex
 * to all other vertices in the graph.
 */
public class Dijkstra {
    ArrayList<ArrayList<int[]>> adj;
    int src;

    public Dijkstra(ArrayList<ArrayList<int[]>> adj, int src) {
        this.adj = adj;
        this.src = src;
    }

    public ArrayList<Integer> helper_bottomup() {
        int V = adj.size();

        // Min-heap (priority queue) storing pairs of (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Distance array: stores shortest distance from source
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance from source to itself is 0
        dist[src] = 0;
        pq.offer(new int[]{0, src});

        // Process the queue until all reachable vertices are finalized
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];

            // If this distance is not the latest shortest one, skip it
            if (d > dist[u])
                continue;

            // Explore all adjacent vertices
            for (int[] p : adj.get(u)) {
                int v = p[0];
                int w = p[1];

                // If we found a shorter path to v through u, update it
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist)
            result.add(d);

        // Return the final shortest distances from the source
        return result;
    }

    public ArrayList<Integer> solution_topdown() {
        return helper_bottomup();
    }

    public ArrayList<Integer> solution(){
        return solution_topdown();
    }

}
