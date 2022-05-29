package com.rajeshanthari.udemy.practice.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class InputStreamsDemo {
	private static final String FILE_PATH = "C:\\Users\\ranthari\\Downloads\\xanadu.txt";
	private static final String OUTPUT_FILE_PATH = "C:\\Users\\ranthari\\Downloads\\xanadu_wit_Raj.txt";

	public static void main(String[] args) throws IOException {
		// read();
		// readCharSteams();
		// readLines();
		// scanLines();
		readPassword();

	}

	public static char[] readPassword() {
		Console con = System.console();
		if (con == null) {
			System.out.println("No console");
			System.exit(1);
		}
		String name = con.readLine("Enter name");
		System.out.println(name);
		char[] password = con.readPassword("Enter password");
		System.out.println(Arrays.toString(password));
		return password;

	}

	public static void scanLines() throws FileNotFoundException {

		try (Scanner s = new Scanner(new BufferedReader(new FileReader(FILE_PATH)))) {
			s.useDelimiter(",\\s*");
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		}
	}

	public static void readLines() throws IOException {

		BufferedReader input = null;
		PrintWriter output = null;
		try {
			input = new BufferedReader(new FileReader(FILE_PATH));
			output = new PrintWriter(new FileWriter(OUTPUT_FILE_PATH));
			String c;

			while ((c = input.readLine()) != null) {
				System.out.println(c);
				output.println(c);
			}
			output.flush();

		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}

	}

	public static void read() throws IOException {

		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			input = new FileInputStream(FILE_PATH);
			output = new FileOutputStream(OUTPUT_FILE_PATH);
			int c;

			while ((c = input.read()) != -1) {
				System.out.println((char) c);
				output.write(c);
			}
			output.flush();

		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}

	}

	public static void readCharSteams() throws IOException {

		FileReader input = null;
		FileWriter output = null;
		try {
			input = new FileReader(FILE_PATH);
			output = new FileWriter(OUTPUT_FILE_PATH);
			int c;

			while ((c = input.read()) != -1) {
				System.out.println((char) c);
				output.write(c);
			}
			output.flush();

		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}

	}

}
