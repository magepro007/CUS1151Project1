
public class ArrayTest {

	public static void main(String[] args) {
		ArrayIntList arr = new ArrayIntList(5);
		
		for(int i = 0; i < 5; i++) {
			arr.add((int)(Math.random() * 10) + 1);
		}
		System.out.println("ArrayIntList class tester application.\nPopulated Array with 5 random integers.");
		System.out.println(arr);
		
		System.out.println("Adding 99 at index 2");
		arr.add(2, 99);
		
		System.out.println("Expanding array to hold 6 integers.");
		arr.ensureCapacity(6);
		System.out.println("Adding the 6th integer, 0.");
		arr.add(0);
		arr.toString();

		System.out.println(arr);
		System.out.println("Array contains 7 : " + arr.contains(7));
		
		System.out.println("index 0: " + arr.get(0));
		
		System.out.println("Array is empty: " + arr.isEmpty());
		
		System.out.println("Removing integer at index 2");
		arr.remove(2);
		System.out.println(arr);
		
		System.out.println("Setting first element to 100.");
		arr.set(0, 100);
		System.out.println(arr);
		
		System.out.println("Testing size method. Size: " + arr.size());
		
		System.out.println("Adding 99 at index 2");
		arr.add(2, 99);
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
		System.out.println(paired);
		System.out.println("Array is pairwise sorted: " + paired.isPairWiseSorted());
	}

}
