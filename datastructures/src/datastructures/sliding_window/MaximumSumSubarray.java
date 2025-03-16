package datastructures.sliding_window;

import java.util.Scanner;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of elements
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Input size of the subarray
        int k = sc.nextInt();
        
        // Sliding window logic to find the maximum sum of subarrays of size k
        int i = 0, j = 0, sum = 0, ans = Integer.MIN_VALUE;
        
        while (j < n) {
            if (j - i + 1 < k) {
                sum += arr[j];
                j++;
            } else if (j - i + 1 == k) {
                sum += arr[j];
                ans = Math.max(ans, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        
        // Output the result
        System.out.println(ans);
    }
}
