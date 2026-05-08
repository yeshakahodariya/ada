/*
AIM:
Solve Shortest Common Super Sequence (SCS) using Dynamic Programming.
*/

import java.util.*;

public class PR13 {

    static final int MAX = 100;

    // Function to compute SCS DP table
    public static void computeSCS(String X, String Y, int[][] dp) {
        int m = X.length();
        int n = Y.length();

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(a, b);
                }
            }
        }
    }

    // Function to build SCS string
    public static void buildSCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();

        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] <= dp[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            } 
            else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        // reverse and print
        System.out.print("\nSCS Sequence: ");
        System.out.println(scs.reverse().toString());
    }

    // Function to print DP table
    public static void printTable(int[][] dp, int m, int n) {
        System.out.println("\nSCS DP Table:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        int[][] dp = new int[MAX][MAX];

        computeSCS(X, Y, dp);

        int m = X.length();
        int n = Y.length();

        printTable(dp, m, n);

        buildSCS(X, Y, dp);

        System.out.println("Length of SCS: " + dp[m][n]);
    }
}
