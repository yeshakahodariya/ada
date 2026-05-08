/*
AIM:
Implement Linear Search and Binary Search.
*/

import java.util.*;

public class PR06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements (unsorted)
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // -------- LINEAR SEARCH --------
        int pos1 = -1;

        for(int i = 0; i < n; i++) {
            if(arr[i] == key) {
                pos1 = i;
                break;
            }
        }

        if(pos1 != -1)
            System.out.println("Linear Search: Found at position " + pos1);
        else
            System.out.println("Linear Search: Not Found");

        // -------- SORT ARRAY --------
        Arrays.sort(arr);

        System.out.println("\nSorted Array:");
        for(int x : arr) {
            System.out.print(x + " ");
        }

        // -------- BINARY SEARCH --------
        int low = 0, high = n - 1;
        int pos2 = -1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == key) {
                pos2 = mid;
                break;
            } 
            else if(arr[mid] < key) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        if(pos2 != -1)
            System.out.println("\nBinary Search: Found at position " + pos2);
        else
            System.out.println("\nBinary Search: Not Found");

        sc.close();
    }
}