// --== CS400 File Header Information ==--
// Name: Taylor Powers
// Email: tmpowers@wisc.edu
// Team: EB
// Role: Test Engineer 1
// TA: Keren Chen
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of the
 * HashTableMap class
 */
public class TestHashTable {
	/*
	 * Tests that the put method accurately adds key-value pairs to the hash table
	 * 
	 * @return True when the size of the HashTableMap is equal to the number of
	 * key-value pairs added to the hash table, and False when it is now
	 */
	public static boolean testPut() {
		HashTableMap<String, String> myMap = new HashTableMap<>(10);
		myMap.put("CA", "Population: 39.51");
		myMap.put("IL", "Population: 12.67");
		myMap.put("WI", "Population: 5.82");
		myMap.put("NY", "Population: 19.45");
		myMap.put("MI", "Population: 9.98");
		if (myMap.size() != 5) {
			return false;
		}
		return true;

	}

	/*
	 * Tests that the get method returns the correct value when passed a key. If
	 * passed a key that does not exist in the hash table, then it tests whether a
	 * NoSuchElementException is caught or not.
	 * 
	 * @return True when the correct value is returned or an exception is caught,
	 * and False if an incorrect value is returned or an exception is not caught.
	 */
	public static boolean testGet() {
		HashTableMap<String, String> myMap = new HashTableMap<>(50);
		myMap.put("CA", "Population: 39.51");
		myMap.put("IL", "Population: 12.67");
		myMap.put("WI", "Population: 5.82");
		myMap.put("NY", "Population: 19.45");
		myMap.put("MI", "Population: 9.98");
		if (myMap.get("IL") != "Population: 12.67") {
			return false;
		}
		try {
			myMap.get("AZ");
			System.out.println("Problem detected. Calling the get() method with an invalid key does"
					+ "not throw a NoSuchElementException.");
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	/*
	 * Tests the remove method by attempting to remove a key and then verifying that
	 * the value returned is the correct value and that the hash table decreases in
	 * size. Also tests whether calling the get method on a key that has previously
	 * been removed correctly throws a NoSuchElementException
	 * 
	 * @return True when the remove method returns the correct value and decreases
	 * the size of the hash table and False when the remove method does not
	 */
	public static boolean testRemove() {
		HashTableMap<String, String> myMap = new HashTableMap<>(50);
		myMap.put("CA", "Population: 39.51");
		myMap.put("IL", "Population: 12.67");
		myMap.put("WI", "Population: 5.82");
		myMap.put("NY", "Population: 19.45");
		myMap.put("MI", "Population: 9.98");
		if (myMap.remove("CA") != "Population: 39.51" && myMap.size() != 4) {
			return false;
		}
		try {
			myMap.get("CA");
			System.out.println("Problem detected. Calling the get() method with an invalid key does"
					+ "not throw a NoSuchElementException.");
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	/*
	 * Tests that the HashTableMap correctly grows and rehashes when the load
	 * capacity reaches or exceeds 80%. This method adds key-value pairs to a hash
	 * table with a capacity of 10 and checks whether the new capacity of the hash
	 * table is 20 after adding the 9th key-value pair.
	 * 
	 * @return True when the hash table correctly doubles and rehashes, and False
	 * otherwise
	 */
	public static boolean testLoadFactor() {
		HashTableMap<String, String> myMap = new HashTableMap<>(5);
		myMap.put("CA", "Population: 39.51");
		myMap.put("IL", "Population: 12.67");
		myMap.put("WI", "Population: 5.82");
		myMap.put("NY", "Population: 19.45");
		myMap.put("MI", "Population: 9.98");
		if (myMap.size() != 5) {
			return false;
		}
		if (myMap.capacity() != 10) {
			return false;
		}
		myMap.put("TX", "Population: 28.99");
		myMap.put("Fl", "Population: 21.47");
		myMap.put("NC", "Population: 10.48");
		if (myMap.capacity() != 20) {
			return false;
		}
		return true;
	}

	/*
	 * Tests that the clear method correctly removes all key-value pairs from the
	 * hash table
	 * 
	 * @return True when the size of the hash table is 0, and False otherwise
	 */
	public static boolean testClear() {
		HashTableMap<String, String> myMap = new HashTableMap<>(10);
		myMap.put("CA", "Population: 39.51");
		myMap.put("IL", "Population: 12.67");
		myMap.put("WI", "Population: 5.82");
		myMap.clear();
		if (myMap.size() != 0) {
			return false;
		}
		return true;
	}

	/*
	 * Tests that the contains method correctly return true or false depending on
	 * whether the key passed into the method is in the hash table or not
	 * 
	 * @return True when the method correctly tests for a key, and False otherwise
	 */
	public static boolean testContains() {
		HashTableMap<String, String> myMap = new HashTableMap<>(10);
		myMap.put("CA", "Population: 39.51");
		myMap.put("IL", "Population: 12.67");
		myMap.put("WI", "Population: 5.82");
		if (myMap.containsKey("CA") != true) {
			return false;
		}
		if (myMap.containsKey("NC") != false) {
			return false;
		}
		return true;
	}

	/**
	 * This method should test the methods defined within this class and display
	 * their outputs
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static void main(String[] args) {
		System.out.println("testPut(): " + testPut());
		System.out.println("testGet(): " + testGet());
		System.out.println("testRemove(): " + testRemove());
		System.out.println("testLoadFactor(): " + testLoadFactor());
		System.out.println("testClear(): " + testClear());
		System.out.println("testContains(): " + testContains());
	}
}
