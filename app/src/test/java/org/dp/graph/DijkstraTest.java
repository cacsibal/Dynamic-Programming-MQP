package org.dp.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.geeksforgeeks.org/dsa/dijkstras-shortest-path-algorithm-greedy-algo-7/
import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {
    @Test
    void dijkstra() {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        ArrayList<int[]> rol1 = new ArrayList<>();
        rol1.add(new int[]{1,4});
        rol1.add(new int[]{2,8});

        ArrayList<int[]> rol2 = new ArrayList<>();
        rol2.add(new int[]{0,4});
        rol2.add(new int[]{4,6});
        rol2.add(new int[]{2,3});

        ArrayList<int[]> rol3 = new ArrayList<>();
        rol3.add(new int[]{0,8});
        rol3.add(new int[]{3,2});
        rol3.add(new int[]{1,3});

        ArrayList<int[]> rol4 = new ArrayList<>();
        rol4.add(new int[]{2,2});
        rol4.add(new int[]{4,10});

        ArrayList<int[]> rol5 = new ArrayList<>();
        rol5.add(new int[]{1,6});
        rol5.add(new int[]{3,10});

        graph.add(rol1);
        graph.add(rol2);
        graph.add(rol3);
        graph.add(rol4);
        graph.add(rol5);

        int[] path = new int[] {0,4,7,9,10};
        Dijkstra testcase = new Dijkstra(graph, 0);
        ArrayList<Integer> result = testcase.solution();
        int[] expect = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            expect[i] = result.get(i);
        }
        assertArrayEquals(path, expect);

    }
}