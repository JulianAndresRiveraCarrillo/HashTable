package datastructures;

public class HashNode<K, V> {

	private K key;
	private V value;
	
	private double percentage;
	
	private HashNode<K, V> next;
	
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
		percentage = 0;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double aux) {
		percentage = aux;
	}
	
	public HashNode<K, V> getNext(){
		return next;
	}
	
	public void addNode(HashNode<K, V> node) {
		
		if (getNext() == null) {
			next = node;
		}else {
			next.addNode(node);
		}
	}
}
