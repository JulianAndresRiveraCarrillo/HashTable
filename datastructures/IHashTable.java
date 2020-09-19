package datastructures;

public interface IHashTable<K, V> {

	void add(K key, V value);
	
	int hash(K key);
	
	void collision(int position, HashNode<K, V> node);
	
	String show();
}
