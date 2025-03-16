package datastructures.sliding_window;

import java.util.Scanner;

public class CountOccurencesOfAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Reading input strings
        String s = scanner.next();
        String p = scanner.next();
        
        // Initialize the frequency array for string p
        int[] arr = new int[26];
        int count = 0;
        
        // Frequency array for checking substrings
        int[] check = new int[26];
        
        // Store the frequency of characters in string p
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }
        
        int i = 0, j = 0;
        int n = p.length();
        int m = s.length();
        
        // Sliding window logic
        while (j < m) {
            if (j - i + 1 < n) {
                check[s.charAt(j) - 'a']++;
                j++;
            } else {
                check[s.charAt(j) - 'a']++;
                int k;
                for (k = 0; k < 26; k++) {
                    if (arr[k] != check[k]) {
                        break;
                    }
                }
                
                // If all character frequencies match, count the occurrence
                if (k == 26) {
                    count++;
                }
                
                // Slide the window
                check[s.charAt(i) - 'a']--;
                j++;
                i++;
            }
        }
        
        // Output the result
        System.out.println(count);
        
        scanner.close();
    }
}
