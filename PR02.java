/*
AIM:
To implement Bubble Sort on a sufficiently large dataset and 
measure its execution time to analyze its performance.
*/

import java.util.*;

public class PR02 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[100];
        int n, i, j, temp, check;

        System.out.print("Enter array size: ");
        n = sc.nextInt();

        for (i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        long start = System.nanoTime();

        for (i = 0; i < n - 1; i++) {
            check = 0;

            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    check = 1;
                }
            }

            System.out.println("Array after step " + (i + 1) + ":");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();

            if (check == 0) {
                break;
            }
        }

        long end = System.nanoTime();

        System.out.println("\nFinal sorted array:");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nTime taken to sort the array: " + (end - start) + " nanoseconds");

        sc.close();
    }
}