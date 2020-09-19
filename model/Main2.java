package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.HashTableOwn;

public class Main2 {
	
	static HashTableOwn<String, String> table = new HashTableOwn<String, String>();

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int cases = Integer.parseInt(reader.readLine());
			String line = reader.readLine();
			
			for (int i = 0; i < cases; i++) {
				line = reader.readLine();
				
				while (line != null && !line.isEmpty()) {
					table.add(line, line);
				}
				
				table.show();
			}
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (NumberFormatException e2) {
			System.err.println(e2.getLocalizedMessage());
		}
	}
}
