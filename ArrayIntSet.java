package algs11;

import stdlib.StdOut;
import java.util.Arrays;


public class ArrayIntSet {
	private int[] data;
	private int size;

	public ArrayIntSet(int capacity) {
		data = new int[capacity];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(int i) {
		for (int index = 0; index < size; index++) {
			if (data[index] == i)
				return true;
		}
		return false;
	}

      // Ignore this equals method. Used for testing.
	public boolean equals(Object otherObject) {
		ArrayIntSet other = (ArrayIntSet) otherObject;
		return this.equals(other);
	}



	/***************************** NEW METHODS ************************************/

	/**
	 * Adds <code>element</code> to this set if it is not already present and
	 * returns <code>true</code>. If <code>element</code> is already present, the
	 * set is unchanged and <code>false</code> is returned.
	 * 
	 * @param element the element to be added
	 * @return <code>true</code> if the element was added and <code>false</code>
	 *         otherwise.
	 */
	public boolean addElement(int element) {
		// Replace the line below with your answer
		
		//return false if the element already exists
		if (contains(element)) {
            return false;
	}
        //increasing the size of the array if it's full
       if (size == data.length) {
    	   
    	   //creating a temporary array and copying the old data to it
             int temp[] = new int[size * 2];
             
             for (int i = 0; i < size; i++) {
                   temp[i] = data[i];
             }

             data = temp;

       }
		//adding an element to index and incrementing the size
		data[size++] = element;

        return true; //it works
        
	}
		

	/**
	 * Removes an element from the set.
	 * 
	 * @param element the element to be removed
	 * @return <code>ture</code> if the element was removed and <code>false</code>
	 *         otherwise.
	 */
	public boolean removeElement(int element) {
		// Replace the line below with your answer
		
		//checking if the element exists
	     for (int index = 0; index < size; index++) {

             if (data[index] == element) {

                  //if it's found it moves the last element to this position
                   data[index] = data[size - 1];

                   // updating the size
                   size--;
                   return true; //it works

             }

       }

       return false; //doesnt work
	}

	/**
	 * Returns true if <code>this</code> and <code>other</code> have the same
	 * elements and false otherwise.
	 * 
	 * @param other the set to compare against for equality
	 * @return true if <code>this</code> and <code>other</code> have the same
	 *         elements and false otherwise.
	 */
	public boolean equals(ArrayIntSet other) {
		// Replace the line below with your answer
        if (size != other.size) {

            return false; //sizes dont match

      }

      //checking if all elements of the set are identical
      for (int index = 0; index < size; index++) {

            if (!other.contains(data[index])) {
                  //finds an element that doesn't exist in the other and returns false
                  return false;

            }

      }

      // equal.

      return true;
	}

	/**
	 * Changes the set so that it is equal the union of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to union with
	 */
	public void union(ArrayIntSet other) {
		//adding all nonduplicate elements of the other set
        for (int index = 0; index < other.size; index++) {
              addElement(other.data[index]);
	}
	}

	/**
	 * Changes the set so that is equal the intersection of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to intersect with
	 */
	public void intersect(ArrayIntSet other) {
		// looping from last to first
        for (int i = size; i >= 0; i--) {
              // if current element is not present on the other set it gets removed
              if (!other.contains(data[i])) {

                    removeElement(data[i]);
	}
}
}
}