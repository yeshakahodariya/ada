/*
AIM:
To solve Longest Common Subsequence (LCS) using Dynamic Programming.
*/

import java.util.Scanner;

public class PR12 {

    static final int MAX = 100;

    static void printLCS(int[][] b, char[] x, int i, int j)
    {
        if(i==0 || j==0)
            return;

        if(b[i][j]==1)
        {
            printLCS(b,x,i-1,j-1);
            System.out.print(x[i-1]);
        }
        else if(b[i][j]==2)
            printLCS(b,x,i-1,j);
        else
            printLCS(b,x,i,j-1);
    }

    static void printLCSTable(int[][] c, int[][] b, char[] x, char[] y, int m, int n)
    {
        System.out.println("\nLCS Table (D=diagonal, U=up, L=left):\n");

        System.out.print("   ");
        for(int j=0;j<=n;j++)
        {
            if(j==0)
                System.out.print("- ");
            else
                System.out.print(y[j-1]+" ");
        }
        System.out.println();

        for(int i=0;i<=m;i++)
        {
            if(i==0)
                System.out.print("- ");
            else
                System.out.print(x[i-1]+" ");

            for(int j=0;j<=n;j++)
            {
                char arrow;

                if(i==0 || j==0)
                    arrow='-';
                else if(b[i][j]==1)
                    arrow='D';
                else if(b[i][j]==2)
                    arrow='U';
                else
                    arrow='L';

                System.out.print(c[i][j]+""+arrow+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String xs, ys;

        System.out.print("Enter first string: ");
        xs = sc.next();

        System.out.print("Enter second string: ");
        ys = sc.next();

        char[] x = xs.toCharArray();
        char[] y = ys.toCharArray();

        int m = x.length;
        int n = y.length;

        int[][] c = new int[MAX][MAX];
        int[][] b = new int[MAX][MAX];

        for(int i=0;i<=m;i++)
            c[i][0]=0;

        for(int j=0;j<=n;j++)
            c[0][j]=0;

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(x[i-1]==y[j-1])
                {
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]=1;
                }
                else if(c[i-1][j]>=c[i][j-1])
                {
                    c[i][j]=c[i-1][j];
                    b[i][j]=2;
                }
                else
                {
                    c[i][j]=c[i][j-1];
                    b[i][j]=3;
                }
            }
        }

        System.out.println("\nLength of LCS: "+c[m][n]);
        System.out.print("Longest Common Subsequence: ");
        printLCS(b,x,m,n);
        System.out.println();

        printLCSTable(c,b,x,y,m,n);

        sc.close();
    }
}