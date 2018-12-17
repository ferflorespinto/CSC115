// Name: Jorge Fernando Flores Pinto
// ID: V00880059
// BSTMap.java
//
// Further comments for each method can be found in the Map interface.

import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
	private BinarySearchTree<K, V> st;

	public BSTMap () {
		st = new BinarySearchTree<K, V>();
	}

	public boolean containsKey(K key) {
		boolean keyFound = true;
		try {
			V val = st.find(key);
		}
		catch (KeyNotFoundException e) {
			keyFound = false;
		}
		return keyFound;
	}

	public V get (K key) throws KeyNotFoundException {
		return st.find(key);
	}

	public List<Entry<K,V> >	entryList() {
		return st.entryList();
	}

	public void put (K key, V value) {
		st.insert(key, value);
	}

	public int size() {
		return st.size();
	}

	public void clear() {
		st.clear();
	}

	public int getGetLoopCount() {
		return st.getFindLoopCount();
	}

	public int getPutLoopCount() {
		return st.getInsertLoopCount();
	}

	public void resetGetLoops() {
		st.resetFindLoops();
	}

	public void resetPutLoops() {
		st.resetInsertLoops();
	}
}
