package com.rajeshanthari.udemy.practice.sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] nums = new int[] { 25, 35, -15, 7, 55, 1, -22 };
		System.out.println(Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void bubbleSort(int[] arr) {

		for (int unsortedIndex = arr.length - 1; unsortedIndex > 0; unsortedIndex--) {
			for (int j = 0; j < unsortedIndex; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int from, int to) {
		if (from == to) {
			return;
		}
		int temp = arr[to];
		arr[to] = arr[from];
		arr[from] = temp;
	}
}
