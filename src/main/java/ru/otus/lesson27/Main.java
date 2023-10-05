package ru.otus.lesson27;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Введите название файла");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.nextLine();
		byte[] buffer = readFile(filename);
		System.out.println("Введите искомую последовательность");
		String sequence = scanner.nextLine();
		System.out.println(countSeq(sequence, new String(buffer, StandardCharsets.UTF_8)));
	}

	public static byte[] readFile(String filename) {
		try (BufferedInputStream bf = new BufferedInputStream(new FileInputStream(filename + ".txt"))) {
			return bf.readAllBytes();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int countSeq(String seq, String buffer) {
		int counter = 0;
		while (buffer.contains(seq)) {
			buffer = buffer.substring(buffer.indexOf(seq) + seq.length());
			counter++;
		}
		return counter;
	}
}