/*
AIM:
To solve the Minimum Spanning Tree (MST) problem using Kruskal’s Algorithm by applying the Greedy Strategy.
*/

import java.util.Scanner;

public class PR08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, i, j;
        int[][] cost = new int[10][10];
        int[] mask = new int[10];

        int min, u = 0, v = 0;
        int total = 0, count = 0;

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter cost adjacency matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 99;
            }
        }

        for (i = 1; i <= n; i++)
            mask[i] = i;
        System.out.println("\nEdges in Minimum Spanning Tree:");

        while (count < n - 1) {
            min = 99;

            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            if (mask[u] != mask[v]) {
                System.out.println(u + " - " + v + " cost = " + min);
                total += min;

                int old = mask[v];
                int newVal = mask[u];

                for (i = 1; i <= n; i++) {
                    if (mask[i] == old)
                        mask[i] = newVal;
                }
                count++;
            }
            cost[u][v] = cost[v][u] = 99;
        }
        System.out.println("\nTotal cost = " + total);
        sc.close();
    }
}
