package datastructures.sliding_window;

import java.util.*;

public class FirstNegativeINKSizeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input elements of the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input size of subarray
        int k = sc.nextInt();

        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        while (j < n) {
            // If current subarray size is less than k
            if (j - i + 1 < k) {
                if (arr[j] < 0) {
                    q.add(arr[j]);
                }
                j++;
            } else {
                // Add the negative number to the queue
                if (arr[j] < 0) {
                    q.add(arr[j]);
                }

                // If the queue is empty, push 0, else the front of the queue
                if (q.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(q.peek());
                }

                // Remove the element at the start of the window
                if (arr[i] == q.peek()) {
                    q.poll();
                }
                i++;
                j++;
            }
        }

        // Output the result
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
