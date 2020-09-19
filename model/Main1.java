package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class Main1 {
	
	static Hashtable<String, Integer>table = new Hashtable<String, Integer>();
	static int cases;
	static int cont;
	static int currentSpecie;
	 
	public static void main(String[] args) {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 
		 try {
			cases = Integer.parseInt(reader.readLine());
			String specie = reader.readLine();
			for (int i = 0; i < cases; i++) {
				cont = 0;
				specie = reader.readLine();
				while (specie != null && !specie.isEmpty()) {
					cont = cont + 1;
							
					if (table.containsKey(specie)) {

						currentSpecie = table.get(specie);
						table.put(specie, currentSpecie + 1);
								
					}else {
						table.put(specie, 1);
					}
							
					specie = reader.readLine();
				}
				show();	
			}
		} catch (IOException e1) {
			System.err.println(e1.getLocalizedMessage());
		}catch (NumberFormatException  e2) {
			System.err.println(e2.getLocalizedMessage());
		}
		 
		 

		
		 
	}
	
	static void show() {
		Vector<String> vc = new Vector<>(table.keySet());
		 Collections.sort(vc);
		 Iterator<String> it = table.keySet().iterator();
		 it = vc.iterator();
		 
		while (it.hasNext()) {
			String element = it.next();
			System.out.printf("%s %.4f\n", element,(table.get(element)*1.0/cont*100));
		}
	}
		 
}
