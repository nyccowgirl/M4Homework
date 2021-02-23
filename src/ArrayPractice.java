import java.util.Arrays;

public class ArrayPractice {

	public static void main(String[] args) {

		// For Question 2:
		// For each statement, show the value of numberOfEntries and the contents of the instance data variable "list"
		// array after the statement executes. (Do not display any trailing nulls in the array.)

		ListInterface<String> animalList = new AList<>();

		animalList.add("ant");														// 1
		animalList.add("cat");														// 2
		animalList.add("dog");														// 3
		animalList.add(2, "bat");								// 4
		animalList.add("elephant");													// 5
		animalList.add("fish");														// 6
		animalList.add("frog");														// 7
		System.out.println(animalList.remove(2));						// bat; 6
		System.out.println(animalList.remove(1));						// ant; 5
		System.out.println(animalList.remove(2));						// dog; 4
		System.out.println(animalList.remove(3));						// fish; 3
		System.out.println(animalList.replace(1, "hamster"));	// cat; 3
//		animalList.clear();															// 0
		System.out.println(Arrays.toString(animalList.toArray()));

		// For Question 5:

		System.out.println(animalList.contains("hamster"));									// true

		System.out.println(((AList<String>) animalList).getPosition("hamster"));	// 1
		System.out.println(((AList<String>) animalList).getPosition("frog"));		// 3
		System.out.println(((AList<String>) animalList).getPosition("fish"));		// -1


		ListInterface<Integer> numberList = new AList<>();

		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		numberList.add(4);

		System.out.println(Arrays.toString(((AList<Integer>) numberList).getAllLessThan(3).toArray()));// [1, 2]

		// For Question 6 - modify the constructor and add methods to not add 1 to the index

		// For Question 7 - Fixed size data structure in the real world may be related to stock inventory and storage
		// capacity available. A resizable one would only be relevant if additional storage units or factory renovation
		// occurred to expand the capacity.

		int[] numbers = {0, 0, 0, 0, 0};

		System.out.println("in main before:\t" + Arrays.toString(numbers));
		changeArrayCorrect(numbers);
		//changeArrayIncorrect1(numbers);
		//changeArrayIncorrect2(numbers);
		System.out.println("in main after:\t" + Arrays.toString(numbers));
	}

	public static void changeArrayCorrect(int[] numberArray) {
		// the formal parameter numberArray and the actual parameter sent in are aliases- they are the same object
		// changes made inside the method affect the object outside the method
		for(int i=0; i<numberArray.length; i++) {
			numberArray[i]++;
		}
	}

	public static void changeArrayIncorrect1(int[] numberArray) {
		for(int num : numberArray) { // cannot use a for-each to update the value of an array
			num++;
		}
	}




	public static void changeArrayIncorrect2(int[] numberArray) {
		int[] numbersModified = new int[numberArray.length];
		for(int i=0; i<numberArray.length; i++) {
			numbersModified[i] = numberArray[i] + 1;
		}
		numberArray = numbersModified; // the formal parameter now points to a new place in memory
		// the alias link is broken- so the numberArray is changed, but the actual parameter is not

		System.out.println("in method:\t" + Arrays.toString(numberArray));
	}

}
