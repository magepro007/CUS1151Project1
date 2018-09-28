          /**
           * ArrayIntList class - Project 1
           * Professor. Keshtkar
           * @author Kurtis Bassmann
           */
public class ArrayIntList {
    
	private int[] elementData;
	private int size;
	private final int DEFAULT_CAPACITY = 20;

        /**
         * Default Constructor: Allocates space for int array, elementData, for 20 positions in memory.
         * Size is set to 0, since no elements have been added to the list.
         */
	public ArrayIntList() {
		size = 0;
		elementData = new int[DEFAULT_CAPACITY];
	}
        
        /**
         * Parameterized Constructor: Allocates the specified amount of memory positions for the array, elementData.
         * Size is set to 0, since no elements have been added to the list.
         * @param capacity the amount of memory to allocate for the ArrayIntList's inner array
         */
	public ArrayIntList(int capacity) {
		size = 0;
		elementData = new int[capacity];
	}

        /**
         * Adds the integer argument, value, to the end of the list.
         * If the list is full, an error message is printed in the console.
         * @param value the integer value to add to the end of the list
         */
	public void add(int value) {
		if(size == elementData.length)
			System.err.println("The list is full, cannot add value.");
		else {
			elementData[size] = value;
			size++;
		}
	}

        /**
         * Adds the integer argument, value, to the index specified by integer argument, index.
         * All elements in the array are shifted to their next respective position in the array, to allow space for the new value.
         * If the list is full, or the index is out of bounds of the list, an error message is printed in the console.
         * @param index the position in elementData to add the new integer to.
         * @param value the new value to add into the list
         */
	public void add(int value, int index) {
                if(index >= elementData.length)
                    System.err.println("This index is out of range. Cannot add " + value + " to the list at index " + index + "...");
                else if(size == elementData.length)
			System.err.println("The list is full, cannot add value.");
		else {
			for(int i = size - 1; i >= index; i--) {
				elementData[i + 1] = elementData[i];
			}
			elementData[index] = value;
			size++;
		}
	}

        /**
         * Addresses whether or not the argument, value, is contained in the list.
         * @param value the value being searched for in elementData
         * @return returns true if the element is found, returns false otherwise
         */
	public boolean contains(int value) {
		for(int i = 0; i < elementData.length; i++) {
			if(elementData[i] == value)
				return true;
		}
		return false;
	}

        /**
         * Ensures that the specified integer number of elements can be stored in the list's array.
         * This is accomplished by creating a new array of this capacity, and then copying the elements from the current list, into the new list.
         * The new list is then referenced by the instance variable, elementData.
         * @param capacity the capacity of elements the list shall be modified to ensure
         */
	public void ensureCapacity(int capacity) {
		int[] newAlloc = new int[capacity];
		for(int i = 0; i < elementData.length; i++) {
			newAlloc[i] = elementData[i];
		}
		this.elementData = newAlloc; 
	}

        /**
         * Accesses an integer at the position specified by argument, index.
         * @param index the position to access
         * @return the integer value accessed
         */
	public int get(int index) {
		if(index > size - 1)
			return -1;
		return elementData[index];
	}

        /**
         * Finds the index, of the first occurrence, of the value specified.
         * @param value the integer value to search for
         * @return the specified value's position in the list
         */
	public int indexOf(int value) {
		for(int i = 0; i < elementData.length; i++) {
			if(elementData.equals(value))
				return i;
		}
		return -1;
	}

        /**
         * Determines whether or not the list is empty.
         * @return returns true if the list's size is 0, and false if size is non-zero.
         */
	public boolean isEmpty() {
		return size == 0;
	}

        /**
         * Removes the value at the specified index from the list, and shifts all elements after index to their respective indeces one less than their current.
         * @param index the index of the value to remove from the list
         */
	public void remove(int index) {
		for(int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i+1];
		}
		size--;
		//check this
	}

        /**
         * Sets the value at the index specified to the value specified.
         * @param index the index to modify
         * @param value the value to store at the specified index of the list
         */
	public void set(int index, int value) {
            if(index < 0 || index >= elementData.length)
                System.err.println("The specified index is out of bounds");
            elementData[index] = value;
	}

        /**
         * Determines the size of the list
         * @return the size of the elements stored in the list
         */
	public int size() {
		return size;
	}

        /**
         * Creates a String representation of all of the elements added to, and stored in the list.
         * The size of the list is also included in this representation.
         * @return a String containing the state of the list
         */
	public String toString() {
		String str = "[";
		for(int i = 0; i < elementData.length; i++) {
				str += elementData[i] + ", ";
		}
		str+="]\t\t(size: " + size + ")";
		return str;
	}
        
	// Questions 1 - 4 ...
        
        /**
         * Determines at how many locations the most frequently occurring integer in the list has been stored.
         * @return the number of occurrences of the most frequently occurring integer in the list
         */
        public int maxCount() {
            int maxCount = 1; int count = 1;
            
            for(int i = 0; i < elementData.length - 1; i++) {
                if(elementData[i] == elementData[i+1])
                    count++;
                else
                    count = 1;
                if(count > maxCount)
                    maxCount = count;
            }
            return maxCount; 
        }
        
        /**
         * Determines the length of the longest sorted sequence of integers stored in the list.
         * @return the length of the longest sorted sequence
         */
	public int longestSortedSequence() {
		int longest = 1;
		for(int i = 0; i < elementData.length - 1; i++) {
			int current = elementData[i];
			int next = elementData[i+1];
			if(current < next) {
				longest++;
			}
		}
		return longest;
	}

        /**
         * Creates a new list which stores the running total of the list at each index, i.
         * The value at any position, i, in the new list is equal to the sum of the values in this list from positions 0 to i, inclusive.
         * @return a new list which contains the running total of the list at each index.
         */
        public ArrayIntList runningTotal() {
            int length = elementData.length;
            ArrayIntList sumList = new ArrayIntList(length);
            
            int total = 0;
            for(int i = 0; i < length; i++) {
                total+=elementData[i];
                sumList.add(total);
            }
            return sumList;
        }

        /**
         * Determines if the list is pairwise sorted.
         * A list is considered pairwise sorted if each successive pair of numbers is in sorted (non-decreasing) order.
         * @return returns true if the list is pairwise sorted, or false otherwise
         */
	public boolean isPairWiseSorted() {
		if(size == 1)
			return true;
		for(int i = 0; i < elementData.length - 1; i+=2) {
			if(elementData[i] > elementData[i+1]) {
				System.out.println(elementData[i] + "is greater than " + elementData[i+1]);
				return false;
			}
		}
		return true;
	}
}
