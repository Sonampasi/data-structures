/*Complexities
 * Time complexity for: 
 * insertion : O(1)
 * deletion : hash_fuction(x) + O(load factor(n/table_size))
 * search : hash_fuction(x) + O(load factor(n/table_size))
 */

import java.util.LinkedList;

public class HashTableUsingSeparateChaining {

	LinkedList<Integer> hash_table[];
	int table_size;

	public HashTableUsingSeparateChaining(int size) {
		table_size = size;
		hash_table = new LinkedList[table_size];
	}

	//calculate index using hash function
	public int hash_function(int x) {
		return x % 10;
	}

	//insert data at the index returned by hash function,each index is pointing to a linked list
	public void insert(int val) {
		int index = hash_function(val);
		if (hash_table[index] == null) {
			hash_table[index] = new LinkedList();
		}
		hash_table[index].add(val);
	}

	//search for a value
	public boolean find(int val) {
		int index = hash_function(val);
		if (hash_table[index] != null) {
			return hash_table[index].contains(val);
		}
		return false;
	}
	
	//delete a value 
	public boolean delete(int val){
		int index = hash_function(val);
		return hash_table[index].removeFirstOccurrence(val);	
	}

	//print hash table
	public void print() {
		for (int i = 0; i < table_size; i++) {
			if (hash_table[i] != null) {
				System.out.print("row " + i + ": " + hash_table[i]);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		HashTableUsingSeparateChaining obj = new HashTableUsingSeparateChaining(7);
		obj.insert(10);
		obj.insert(4);
		obj.insert(20);
		obj.insert(13);
		obj.insert(6);
		obj.insert(21);
		obj.insert(5);
		obj.insert(1);
		obj.print();
		System.out.println(obj.find(4));
		System.out.println(obj.find(14));
		obj.delete(20);
		obj.delete(4);
		obj.delete(15);
		obj.print();
	}

}
