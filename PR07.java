/*
AIM:
To implement Minimum Spanning Tree (MST) generation using Prim’s Algorithm based on the Greedy Strategy.
*/

import java.util.*;

public class PR07 {

    static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, i, j, u = 0, v = 0;
        int cost[][] = new int[10][10];
        int visited[] = new int[10];

        int min, total_cost = 0, edges = 1;

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter cost adjacency matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();

                if (cost[i][j] == 0) {
                    cost[i][j] = INF;
                }
            }
        }

        visited[1] = 1;

        System.out.println("\nEdges in minimum spanning tree:");

        while (edges < n) {
            min = INF;

            for (i = 1; i <= n; i++) {
                if (visited[i] == 1) {
                    for (j = 1; j <= n; j++) {
                        if (visited[j] == 0 && cost[i][j] < min) {
                            min = cost[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            System.out.println(u + " -> " + v + " = " + min);
            total_cost += min;
            visited[v] = 1;
            edges++;
        }

        System.out.println("\nTotal cost of MST = " + total_cost);

        sc.close();
    }
}