package practice;

import java.util.Arrays;

public class ArrayBagTester {
	
	public static void main(String[] args) {

		// For Question 1:
		// For each statement, show the value of numberOfEntries and the contents of the instance data variable "bag"
		// array after the statement executes. (Do not display any trailing nulls in the array.)

		BagInterface<String> animalBag = new ArrayBag<>();

		animalBag.add("ant");										// 1
		animalBag.add("cat");										// 2
		animalBag.add("dog");										// 3
		animalBag.add("cat");										// 4
		animalBag.add("fish");										// 5
		animalBag.add("oxen");										// 6
		animalBag.add("giraffe");									// 7
		System.out.println(animalBag.remove("giraffe"));	// true; 6
		System.out.println(animalBag.remove("ant"));		// true; 5
		System.out.println(animalBag.remove("cat"));		// true; 4
		System.out.println(animalBag.remove("oxen"));		// true; 3
		animalBag.clear();											// 0

		// For Question 3: It could improve method but wouldn't work because bag.length could be different but
		// contents may be the same. More accurate to compare otherBagParam.getCurrentSize() with this.getCurrentSize()

		BagInterface<Integer> numberBag = new ArrayBag<>();

		numberBag.add(1);
		numberBag.add(2);
		numberBag.add(3);

		/*
		if(numberBag instanceof practice.ArrayBag<?>)
			System.out.println( ((practice.ArrayBag<Integer>)numberBag).removeRandom() );
		 */

		BagInterface<Integer> numberBag2 = new ArrayBag<>();
		numberBag2.add(3);
		numberBag2.add(2);
		numberBag2.add(1);
		numberBag2.add(4);

		// For Question 4:

		System.out.println(Arrays.toString(((ArrayBag<Integer>) numberBag).getAllLessThan(3).toArray()));
		// [1, 2]
		System.out.println(Arrays.toString(((ArrayBag<Integer>) numberBag2).getAllLessThan(3).toArray()));
		// [2, 1]


		System.out.println(numberBag.equals(numberBag2));

		BagInterface<String> wordBag = new ArrayBag<>();
		wordBag.add("apple");
		wordBag.add("banana");
		wordBag.add("pear");

		System.out.println(numberBag.equals(wordBag));
		

	}

}
