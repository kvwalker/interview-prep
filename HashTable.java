import java.util.*;

public class HashTable {

	LinkedList<LinkedList<HashNode>> table;
	int numBuckets;

	public HashTable (int b) {
		table = new LinkedList<LinkedList<HashNode>>();
		numBuckets = b;
		for (int i = 0; i < b; i++) {
			table.add(new LinkedList<HashNode>());
		}
	}

	public void put (String key, Object value) {
		// make a new HashNode to hold this data
		HashNode hn = new HashNode(key, value);
		// get the hashcode of the key to insert into the proper place
		int index = hashCode(key) % numBuckets;		
		table.get(index).add(hn);
		return;
	}

	public Object get (String searchKey) { // what if there's more than one? right now we're just returning first
		// get the hashcode of the searchKey so we know where to look
		int index = hashCode(searchKey) % numBuckets;
		// now iterate over the linkedlist stored at the searchKey index until we find our given searchKey
		for (int i = 0; i < table.get(index).size(); i++) {
			HashNode curr = table.get(index).get(i);
			// if the node's key equals the key we're searching for, return the value at that key
			if (curr.key.equals(searchKey)) {
				return curr.value;
			}
		}
		return null;
	}

	public void remove (String searchKey) {
		// get the hashcode of the searchKey 
		int index = hashCode(searchKey) % numBuckets;
		// iterate over linkedlist stored at index to find the searchKey
		for (int i = 0; i < table.get(index).size(); i++) {
			HashNode curr = table.get(index).get(i);
			if (curr.key.equals(searchKey)) {
				// we found the one to remove
				table.get(index).remove(curr);
			}
		}
	}

	public int hashCode (String s) {
		// what is a good hashing function?
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Integer.valueOf(s.charAt(i));
		}
		return sum;
	}

	public String toString () {
		for (int i = 0; i < table.size(); i++) {
			System.out.println(i + ": " + table.get(i).toString());
		}
		return " ";
	}

	public static void main (String[] args) {
		HashTable ht = new HashTable(5);
		ht.put("Suzy", (Integer) 1);
		ht.toString();
		ht.put("Butts", (Integer) 2);
		ht.toString();
		ht.put("Jones", (Integer) 3);
		ht.toString();
		ht.put("Suzi", (Integer) 4);
		ht.toString();
		System.out.println("remove");
		ht.remove("Butts");
		ht.toString();
	}

}

class HashNode {
	String key;
	Object value;

	public HashNode (String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public String toString () {
		return this.key + this.value.toString();
	}
}