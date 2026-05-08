/*
AIM:
To develop and execute Insertion Sort for large input values and
evaluate the algorithm’s execution time.
*/

import java.util.Scanner;

public class PR03 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Generated array:");
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * 100);
            System.out.print(arr[i] + " ");
        }

        long start = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;

            System.out.println("\nAfter step " + i + ":");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
        }

        long end = System.nanoTime();

        System.out.println("\n\nFinal sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nTime taken: " + (end - start) + " nanoseconds");

        sc.close();
    }
}