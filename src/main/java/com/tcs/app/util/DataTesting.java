package com.tcs.app.util;

public class DataTesting {
	
	// Sliding window: Find max sum of subarray of size k
    public static int maxSumSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) return 0;
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 4, 5, 2};
        int k = 3;
        int result = maxSumSlidingWindow(arr, k);
        System.out.println("Max sum of subarray of size " + k + " is: " + result);
    }

}