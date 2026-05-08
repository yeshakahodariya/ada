/*
AIM:
Solve 0/1 Knapsack Problem using Dynamic Programming.
*/
 
 import java.util.Scanner;

public class PR10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] v = new int[n + 1];
        int[] w = new int[n + 1];

        System.out.println("Enter values:");
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }

        System.out.println("Enter weights:");
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        int[][] V = new int[n + 1][W + 1];

        // DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if (i == 0 || j == 0) {
                    V[i][j] = 0;
                }
                else if (j < w[i]) {
                    V[i][j] = V[i - 1][j];
                }
                else {
                    V[i][j] = Math.max(V[i - 1][j],
                            V[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println("\nDP Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMaximum profit = " + V[n][W]);

        sc.close();
    }
}
