package com.rajeshanthari.udemy.practice.ds.stack;

import java.util.stream.Collectors;

public class StackChallenge {
	public static void main(String[] args) {
		System.out.println(checkPalindrome("abccba"));
		System.out.println(checkPalindrome("abBCba"));
		System.out.println(checkPalindrome("I did, did I?"));
	}

	private static boolean checkPalindrome(String string) {
		Character[] arr = string.chars().filter(Character::isAlphabetic).map(Character::toLowerCase)
				.mapToObj(i -> (char) i).collect(Collectors.toList()).toArray(new Character[] {});
		boolean status = true;
		int length = arr.length;
		int halfLength = length / 2;
		for (int j = 0; j < halfLength; j++) {
			if (arr[j] != arr[length - 1 - j]) {
				status = false;
				break;
			}
		}
		return status;
	}

}
