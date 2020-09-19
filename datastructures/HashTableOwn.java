package datastructures;

import java.util.Arrays;

public class HashTableOwn<K ,V> implements IHashTable<K, V> {
	
	public final static int  SIZE = 30;
	
	int doubleHash = 1;
	
	private HashNode<K, V> first;
	
	private final Object[] array; 
	
	public HashTableOwn() {
		array = new Object[SIZE];
	}
	
	public HashNode<K, V> getFirst(){
		return first;
	}

	public void setFirst(HashNode<K, V> newNode) {
		first = newNode;
	}
	
	@Override
	public void add(K key, V value) {
		int pos = hash(key);
		HashNode<K, V> node = new HashNode<>(key, value);
		
		if (array[pos] == null) {
			if (first == null) {
				first = node;
			}else {
				setFirst(node);
			}
			array[pos] = first;
		}else {
			@SuppressWarnings("unchecked")
			HashNode<K, V> temp = ((HashNode<K, V>) array[pos]);
			if (key.equals(temp.getKey())) {
				collision(pos, node);
			}else {
				pos = (pos*(pos + doubleHash)) % SIZE;
				
				if (array[pos] == null) {
					if (first == null) {
						first = node;
					}else {
						setFirst(node);
					}
					array[pos] = first;
					doubleHash = doubleHash + 1;
				}			
			}
		}
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public String show() {
		Arrays.sort(array);
		int current = 0;
		int cont = 0;
		String msg = "";
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				cont = cont + 1;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				HashNode<K, V> temp = (HashNode<K, V>) array[i];
				
				while (temp.getNext() != null) {
					current = current + 1;
					temp = temp.getNext();
				}
				double aux = current * 1.0 / cont * 100;
				temp.setPercentage(aux);
				
				msg += ((HashNode<K, V>) array[i]).getValue() + " " + ((HashNode<K, V>) array[i]).getPercentage(); 
			}
		}
		
		return msg;
	}	
		

	@Override
	public void collision(int position, HashNode<K, V> node) {
		@SuppressWarnings("unchecked")
		HashNode<K, V> temp = (HashNode<K, V>) array[position];
		temp.addNode(node);
	}

	@Override
	public int hash(K key) {
		int pos = 0;
		
		pos = Math.abs(key.hashCode() % SIZE);
		
		return pos;
	}

	
}
