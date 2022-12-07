/**
* @author Ryan Dodd
* <p> Set.java
* <p> Project5
* <p> This class represents set which is essentially a modified ArrayList of Integer objects.
*/

import java.util.ArrayList;
import java.lang.ClassCastException;

/**
 * For this assignment a set is generally defined as a list of values that is
 * sorted and does not contain any duplicate values. More specifically, a set
 * shall contain no pair of elements e1 and e2 such that e1.equals(e2), and at
 * most one null element.
 */
public class Set {
    private ArrayList<Integer> set;

    /**
     * The default Set constructor. Initializes an empty set.
     */
    public Set() {
    	this.set = new ArrayList<Integer>();
    }
    
    /**
     * Constructs a Set of the specified size.
     * @param size (int) - The desired size of the set to begin at.
     */
    public Set(int size) {
    	this.set = new ArrayList<Integer>(size);
    }
    
    /**
     * Constructs a Set of values ranging from the low to the high values.
     * @param low (int) - The start of the values in the set.
     * @param high (int) - The end of the values in the set (inclusive).
     */
    public Set(int low, int high) {
    	this.set = new ArrayList<Integer>(Math.abs(Math.abs(high)-Math.abs(low))); // Abs required to accomodate negative numbers.
    	for (int i = low; i <= high; ++i) {
    		this.set.add(i);
    	}
    }
    
    /**
     * Utilizes selection sort to reorganize the set.
     */
    private void sort() {
    	int size = this.size();
    	
    	for (int i = 0; i < size-1; ++i) {
    		int minIndex = i;
    		for (int j = i+1; j < size; ++j) {
    			if (((Integer)this.get(j)).intValue() < ((Integer)this.get(minIndex)).intValue()) {
    				minIndex = j;
    			}
    		}
    		
    		Integer temp = (Integer)this.get(minIndex);
    		this.set.set(minIndex, (Integer)this.get(i)); // Can directly modify the set without add() or remove() because those will call sort functions and lead to bad things.
    		this.set.set(i, temp);
    	}
    }
    
    /**
     * Since a set must be sorted, a Binary Search can be used to see if elements are in the set.
     * @param o (Integer) - The Integer to search for in the set
     * @param low (int) - The lowest bound to search in.
     * @param high (int) - The highest bound to search in.
     * @return (int) The index if the element is found. -1 otherwise.
     */
    private int BinarySearch(Integer o, int low, int high) {
    	if (low >= high)
    		return -1;
    	
    	int midPoint = (low + high)/2;
    	Integer integerAtIndex = (Integer) this.get(midPoint);
    	
    	if (integerAtIndex.intValue() == o.intValue())
    		return midPoint;
    	
    	if (o.intValue() < integerAtIndex.intValue()) {
    		return BinarySearch(o, midPoint + 1, high);
    	} else {
    		return BinarySearch(o, low, midPoint - 1);
    	}
    }
    
    /**
     * Returns the amount of values in the set.
     * @return (int) - The size of the set.
     */
    public int size() {
    	return this.set.size();
    }
	
    /**
     * Fetches an Integer Value at the provided index of the set.
     * @param index (int) - The index to fetch the Integer value at.
     * @return (Object) - The Integer value in the set at that index.
     */
    public Object get(int index) throws IndexOutOfBoundsException { // Will only throw if the index does not exist in the desired set.
    	if (index < 0)
    		throw new IndexOutOfBoundsException("Cannot have a negative index!"); // Negative index's cannot be returned.
    	
        return this.set.get(index);
    }

    /**
     * Attempts to add an Integer to the set, provided it is not already in it.
     * @param o (Integer) - The Integer to add
     * @return (boolean) True if the integer was added to the set. False otherwise.
     */
    public boolean add(Integer o) {
    	if (o == null)
    		return false;
    	
    	if (BinarySearch(o, 0, this.size()) == -1) {
    		this.set.add(o);
    		this.sort();
    		return true;
    	}
    	return false;
    }
    
    /**
     * Adds an Array of Integers to the set.
     * @param s (Integer[]) - The Array of Integers to add
     * @return (int) - How many Integers had been successfully added to the set.
     */
    public int add(Integer[] s) {
    	int successfullyAdded = 0;
    	for (Integer o: s) {
    		if (this.add(o))
    			successfullyAdded++;
    	}
    	
    	return successfullyAdded;
    }
    
    /**
     * Removes an Integer from the list and returns it.
     * @param o (Integer) - The integer to remove from the list.
     * @return (Integer) The integer that has been removed from the list, or null if it is not in the list.
     */
    public Integer remove(Integer o) {
    	if (o == null)
    		return null;
    	
    	int binaryIndex = BinarySearch(o, 0, this.size());
    	if (binaryIndex != -1) {
    		return this.set.remove(binaryIndex); // No need to resort. The list is already sorted and removal will not effect that.
    	}
    	return null;
    }
    
    public int remove(Set s) {
    	int successfullyRemoved = 0;
    	
    	while (s.size() > 0) {
    		if (this.remove((Integer)s.get(0)) != null)
    			successfullyRemoved++;
    	}
    	
    	return successfullyRemoved;
    }
    
    /**
     * Essentially a roundabout way to call a binary search function and see if the Integer exists within the set.
     * @param o (Integer) - The Integer to look for in the set.
     * @return (boolean) - If the Integer is in the set.
     */
    public boolean contains(Integer o) {
    	return this.BinarySearch(o, 0, this.size()) != -1;
    }
    
    /**
     * Makes the set hold no values.
     */
    public void clear() {
    	this.set = new ArrayList<Integer>();
    }
    
    /**
     * Checks if the set holds any values
     * @return (boolean) - True if the set holds 0 values. False otherwise.
     */
    public boolean isEmpty() {
    	return this.size() == 0;
    }
    
    /**
     * Constructs and returns a new Set object that contains the objects in either this set or the input set s.
     * @param s (Set) - The set to union with this set.
     * @return (Set) - A new Set object containing values from this set or the other set.
     */
    public Set union(Set s) {
    	Set newSet = new Set();
    	for (Integer a: this.set) {
    		if (!s.contains(a))
    			newSet.add(a);
    	}
    	for (int i = 0; i < s.size(); ++i) {
    		if (!this.contains((Integer)s.get(i)))
    			newSet.add((Integer)s.get(i)); // Will not add if it's already in the table thanks to add implementation.
    	}
    	
    	return newSet;
    }

    /**
     * Constructs and returns a new Set opbject that contains the objects in both this set and the input set s.
     * @param s (Set) - The set to intersect with this set.
     * @return (Set) - A new Set object containing values from both sets.
     */
    public Set intersection(Set s) {
    	Set newSet = new Set();
    	for (Integer a: this.set) {
    		if (s.contains(a))
    			newSet.add(a);
    	}
    	for (int i = 0; i < s.size(); ++i) {
    		if (this.contains((Integer)s.get(i)))
    			newSet.add((Integer)s.get(i)); // Will not add if it's already in the table thanks to add implementation.
    	}
    	
    	return newSet;
    }

    /**
     * Determines if this set is a superset of s
     * @param s (Set) - A set of Integers
     * @return (boolean) This method returns true if all elements of s are contained in this set.
     */
    public boolean subset(Set s) {
    	for (int i = 0; i < s.size(); ++i) {
    		if (!this.contains((Integer)s.get(i)))
    			return false;
    	}
    	
    	return true;
    }

    /**
     * Determines if this set is a subset of s
     * @param s (Set) - A set of Integers
     * @return (boolean) This method returns true if all elements of this are contained in s.
     */
    public boolean superset(Set s) {
    	for (int i = 0; i < this.size(); ++i) {
    		if (!s.contains((Integer)this.get(i)))
    			return false;
    	}
    	
    	return true;
    }

    public String toString() {
        String ret_string = "";

        for (int i = 0; i < this.set.size(); i++)
        {
        	Integer x = this.set.get(i) ;
        	String xStr = x == null ? "null" : x.toString() ;
            ret_string += xStr + (i != this.set.size() - 1 ? " " : "");
        }

        return ret_string;
    }

    public boolean equals(Object o) throws ClassCastException {
        if (!(o instanceof Set))
        {
            throw new ClassCastException();
        }

        Set s = (Set) (o);

        for (int i = 0; i < this.set.size(); i++)
        {
            if (!s.contains(this.set.get(i)))
            {
                return false;
            }
        }

        for (int i = 0; i < s.size(); i++)
        {
            if (!this.set.contains(s.get(i)))
            {
                return false;
            }
        }

        return true;
    }
}
