
public class ArrayTest {

	public static void main(String[] args) {
		ArrayIntList arr = new ArrayIntList(10);
                
		System.out.println("ArrayIntList class tester application"
                        + "\nCreating and populating Array with 5 random integers.");
                
		for(int i = 0; i < 5; i++) {
                    int rand = (int)(Math.random() * 10) + 1;
                    System.out.println("adding " + rand + "...");
                    arr.add(rand);
                                System.out.println(arr);

		}
		
		
		System.out.println("Adding 999 at index 51");
		arr.add(999,51);
		
		System.out.println("\nExpanding array to hold 15 integers.");
		arr.ensureCapacity(15);
		arr.toString();

		System.out.println(arr);
		System.out.println("Array contains 7 : " + arr.contains(7));
		
		System.out.println("Find indexOf 0: " + arr.get(0));
		
		System.out.println("Array is empty: " + arr.isEmpty());
		
		System.out.println("Removing integer at index 2");
		arr.remove(2);
		System.out.println(arr);
		
		System.out.println("Setting first element to 100.");
		arr.set(0, 100);
		System.out.println(arr);
		
		System.out.println("Testing size method. Size: " + arr.size());
		
		System.out.println("Adding 99 at index 2");
		arr.add(99,2);
                
                System.out.println(arr);
		
                
		//Project Methods
		System.out.println("Longest sorted sequence : " + arr.longestSortedSequence());
		
		ArrayIntList paired = new ArrayIntList(11);
		paired.add(0);
		paired.add(1);
		paired.add(5);
		paired.add(10);
		paired.add(2);
		paired.add(4);
		paired.add(6);
		paired.add(20);
		paired.add(3);
		paired.add(4);
		paired.add(0);
		System.out.println("\nNew array: " + paired);
		System.out.println("Array is pairwise sorted: " + paired.isPairWiseSorted());
                
                ArrayIntList duplicates = new ArrayIntList(10);
                duplicates.add(3);
                duplicates.add(3);
                duplicates.add(1);
                duplicates.add(1);
                duplicates.add(1);
                duplicates.add(1);
                duplicates.add(2);
                duplicates.add(8);
                duplicates.add(8);
                duplicates.add(8);
                System.out.println("\nNew array: " + duplicates);
                System.out.println("Max count for any int in the Array is: " + duplicates.maxCount());
                
                System.out.println("Totaled version of this list..." + duplicates.runningTotal());
	}

}
