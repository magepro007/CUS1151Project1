import java.util.Stack;

public class ArrayIntList {
	private int[] elementData;
	private int size;
	private final int DEFAULT_CAPACITY = 20;

	
	public static void main(String args[]) {
		
            /**
             * Figure out best way to implement method demonstrations for Q's 5-8.
             */
            /**
             *	QuestionsFiveToEight demo = new QuestionsFiveToEight();
             * 
             *  class QuestionsFiveToEight{
             *	    private int stack1;
             *      private int stack2;
             * 
             *  	public QuestionsFiveToEight() {
             *  		Stack<Integer> stack1 = new Stack();
             *  		Stack<Integer> stack2 = new Stack();
             *  		stack1.push(1);
	     * 			stack1.push(22);
	     *          	stack1.push(333);
	     *          	stack1.push(4444);
	     *  		stack2.push(1);
	     *  		stack2.push(22);
	     *  		stack2.push(333);
             *                  stack2.push(4444);
	     *          }
	     *	
	     *      public boolean equals(Stack stk1, Stack stk2){ //Question 
	     *		Stack stk3 = new Stack();
	     *		System.out.println(stk1);
	     *		System.out.println(stk2);
	     *		
	     *		return false;
	     *      }
	     *  }
             */
	}

	//ArrayIntList Class
	public ArrayIntList() {
		size = 0;
		elementData = new int[DEFAULT_CAPACITY];
	}

	public ArrayIntList(int capacity) {
		size = 0;
		elementData = new int[capacity];
	}

	public void add(int value) {
		if(size == elementData.length)
			System.out.println("The list is full, cannot add value.");
		else {
			elementData[size] = value;
			size++;
		}
	}

	public void add(int index, int value) { // Check to see if List is full ?
		//check this method * * *
		if(size == elementData.length)
			System.out.println("The list is full, cannot add value.");
		else {
			// performing a shift on elements, from index to size - 1
			// then adding the value at the index
			for(int i = size - 1; i >= index; i--) {
				elementData[i + 1] = elementData[i];
			}
			elementData[index] = value;
			size++;

		}

	}

	public boolean contains(int value) {
		for(int i = 0; i < size; i++) {
			if(elementData[i] == value)
				return true;
		}
		return false;
	}

	public void ensureCapacity(int capacity) { // will ensure that at a 'capacity-#' of elements can be stored
		int[] newAlloc = new int[capacity];
		for(int i = 0; i < size; i++) {
			newAlloc[i] = elementData[i];
		}
		this.elementData = newAlloc; 
		//check This
	}

	public int get(int index) {
		if(index > size - 1)
			return -1;
		return elementData[index];
	}

	public int indexOf(int value) {
		for(int i = 0; i < size; i++) {
			if(elementData.equals(value))
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void remove(int index) {
		for(int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i+1];
		}
		size--;
		//check this
	}

	public void set(int index, int value) { /*TODO: Check for bad index */
		elementData[index] = value;
	}

	public int size() {
		return size;
	}

	public String toString() {
		String str = "[";
		for(int i = 0; i < this.size; i++) {
			if(i != size - 1)
				str += elementData[i] + ", ";
			else
				str += elementData[i];
		}
		str+="]\t\t(size: " + size + ")";
		return str;
		//		return elementData.toString() + "\t(size: " + size + ")";
	}

	//Begin Project Questions...
	public int longestSortedSequence() {
		int longest = 1;
		for(int i = 0; i < this.size() - 1; i++) {
			int current = elementData[i];
			int next = elementData[i+1];
			if(current < next) {
				longest++;
			}
		}
		return longest;
	}

	public boolean isPairWiseSorted() {
		if(size == 1)
			return true;
		for(int i = 0; i < size - 1; i+=2) {
			if(elementData[i] > elementData[i+1]) {
				System.out.println(elementData[i] + "is greater than " + elementData[i+1]);
				return false;
			}
		}
		return true;
	}
}
