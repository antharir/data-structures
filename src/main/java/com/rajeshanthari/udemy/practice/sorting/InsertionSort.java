package com.rajeshanthari.udemy.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] nums = new int[] { 25, 35, -15, 7, 55, 1, -22 };
		System.out.println(Arrays.toString(nums));
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void insertionSort(int[] arr) {

		for (int unsortedIndex = 1; unsortedIndex < arr.length; unsortedIndex++) {
			int element = arr[unsortedIndex];
			int index;
			for (index = unsortedIndex; index > 0 && arr[index - 1] > element; index--) {
				arr[index] = arr[index - 1];
			}
			arr[index] = element;

		}
	}
}
