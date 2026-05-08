/*
AIM:
To implement Selection Sort on a sufficiently large dataset and
measure its execution time to analyze its performance.
*/

import java.util.*;

public class PR01 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.println("Array after pass " + (i + 1) + ":");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }

        long end = System.nanoTime();

        System.out.println("\nFinal sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nTime taken: " + (end - start) + " nanoseconds");

        sc.close();
    }
}