/*
AIM:
Solve Matrix Chain Multiplication using Dynamic
Programming.
*/
import java.util.Scanner;

public class PR11 {

    
    static void printSequence(int i, int j, int[][] s) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printSequence(i, s[i][j], s);
            printSequence(s[i][j] + 1, j, s);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions (p0 to p" + n + "):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

       
        for (int d = 1; d < n; d++) {
            for (int i = 1; i <= n - d; i++) {
                int j = i + d;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] +
                            p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

       
        System.out.println("\nCost Matrix (m):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    System.out.print("0\t");
                else
                    System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }

        
        System.out.println("\nSplit Matrix (s):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j)
                    System.out.print("0\t");
                else
                    System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nMinimum number of multiplications: " + m[1][n]);

        System.out.print("Optimal sequence: ");
        printSequence(1, n, s);
        System.out.println();

        sc.close();
    }
}
