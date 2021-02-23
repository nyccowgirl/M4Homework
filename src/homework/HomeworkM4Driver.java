package homework;

import java.util.*;

public class HomeworkM4Driver {

	public static void main(String[] args) {

		System.out.println("************************************TESTING removeAll(T) in ArrayBag************************************");
		System.out.println("Note: the expected and actual bag contents do not have to have the same order- only the same contents.");
		// parameter 1: the contents to add to an originally empty bag
		// parameter 2: the element to remove
		// parameter 3: a description of the test
		testArrayBagRemoveAll(new Integer[] {}, 1, 							"removing from empty bag");
		testArrayBagRemoveAll(new Integer[] {1, 7, 2, 1, 3, 1, 1, 7, 1}, 1, "remove value appears multiple times");
		testArrayBagRemoveAll(new Integer[] {7, 2, 4, 3, 7}, 7, 			"remove value appears multiple times, first and last values added");
		testArrayBagRemoveAll(new Integer[] {2, 4, 3, 1, 5, 6}, 8, 			"remove value is not in the bag");
		testArrayBagRemoveAll(new Integer[] {3, 3, 3, 3}, 3,				"remove value is the only value in the bag");
		testArrayBagRemoveAll(new String[] {"a", "b", "a"}, new String("a"),"test with Strings");

		System.out.println("\nTesting efficiency: The elapsed time should be probably < 100.");
		System.out.println("If the elapsed time is much higher than that, you might revisit your code to see if you have a nested loop.");	
		ArrayBag<Integer> bigBag = new ArrayBag<Integer>(ArrayBag.MAX_CAPACITY);
		for(int i=0; i<ArrayBag.MAX_CAPACITY/2; i++) {
			bigBag.add(99);
		}
		for(int i=0; i<ArrayBag.MAX_CAPACITY/2; i++) {
			bigBag.add(43);
		}	
		long startTimeBag = System.currentTimeMillis();
		bigBag.removeAll(99);
		long stopTimeBag = System.currentTimeMillis();
		System.out.println("Elapsed time = " + (stopTimeBag - startTimeBag));

		
		System.out.println("\n************************************TESTING trimToSize() in ResizableArrayBag************************************");
		ResizableArrayBag<Integer> resizableBag = new ResizableArrayBag<Integer>(20);
		for(int i=0; i<100; i++) {
			resizableBag.add(1);
		}
		// parameter 1: the resizableArrayBag
		// parameter 2: the expected size of the bag (resizableBag.getCurrentSize())
		// parameter 3: the expected length of the bag array (resizableBag.bag.length)
		// parameter 4: a description of the test
		testTrimToSizeResults(resizableBag, 100, 160, "bag with 100 elements; initial array length of 20 doubled three times during the additions for a length of 160");

		System.out.println("\nInvoking trimToSize...");
		resizableBag.trimToSize();
		testTrimToSizeResults(resizableBag, 100, 100, "bag with 100 elements, trimmed to size");

		System.out.println("\nAdding an element...");
		resizableBag.add(43);
		testTrimToSizeResults(resizableBag, 101, 200, "bag with 101 elements; previous array length of 100 doubled during the addition of one item");

		System.out.println("\nInvoking trimToSize...");
		resizableBag.trimToSize();
		testTrimToSizeResults(resizableBag, 101, 101, "bag with 101 elements, trimmed to size");

		ResizableArrayBag<Integer> resizableBagForEmptyTest = new ResizableArrayBag<Integer>(10);
		System.out.println("\nInvoking trimToSize on an empty bag and then using the bag: make sure the code doesn't crash!");
		resizableBagForEmptyTest.trimToSize();
		resizableBagForEmptyTest.add(1);
		resizableBagForEmptyTest.add(2);
		resizableBagForEmptyTest.add(3);


		System.out.println("\n************************************TESTING removeAll(T) in AList************************************");
		// parameter 1: the contents to add to an originally empty list
		// parameter 2: the element to remove
		// parameter 3: a description of the test
		testAListRemoveAll(new Integer[] {}, 1, 					  "removing from empty list");
		testAListRemoveAll(new Integer[] {1, 2, 1, 1, 4, 3, 7, 1}, 1, "remove value appears multiple times");
		testAListRemoveAll(new Integer[] {7, 2, 4, 3, 7}, 7, 		  "remove value appears multiple times, first and last values added");
		testAListRemoveAll(new Integer[] {7, 2, 4, 3, 7}, 8, 		  "remove value is not in the list");
		testAListRemoveAll(new Integer[] {3, 3, 3, 3}, 3, 		 	  "remove value is the only value in the list");
		testAListRemoveAll(new String[] {"a", "b", "a"}, new String("a"), "test with Strings");


		System.out.println("\n************************************TESTING equals method in AList************************************");
		// parameter 1: the list that will invoke the equals method
		// parameter 2: the list passed in as a parameter to the equals method
		// parameter 3: the expected result (true if the lists are equivalent, false otherwise)
		// parameter 4: a description of the test
		testEquivalentLists(new String[] {}, new String[] {}, true, "two empty lists");
		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {"a", "b", "c", "d"}, true, "equivalent lists");
		testEquivalentLists(new String[] {"a", "b", "c", "d", "a"}, new String[] {"a", "b", "c", "d", new String("a")}, true, "equivalent lists");
		testEquivalentLists(new Integer[] {1, 2, 3}, new Integer[] {1, 2, 3}, true, "equivalent lists");

		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {}, 				  false, "empty parameter, non-empty invoking object");
		testEquivalentLists(new String[] {}, 				   new String[] {"a", "b", "c", "d"}, false, "empty invoking object, non-empty parameter");
		testEquivalentLists(new String[] {"a", "b", "c"}, 	   new String[] {"a", "b", "c", "d"}, false, "different lengths, invoking shorter");
		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {"a", "b", "c"}, 	  false, "different lengths, invoking longer");
		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {"e", "f", "g", "h"}, false, "same lengths, different elements");
		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {"a", "b", "c", "e"}, false, "same lengths, different last element");
		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {"e", "b", "c", "d"}, false, "same lengths, different first element");
		testEquivalentLists(new String[] {"a", "b", "c", "d"}, new String[] {"b", "d", "a", "c"}, false, "same lengths, same elements, different order of elements");


		System.out.println("\n************************************TESTING EXTRA CREDIT AList implementing Comparable************************************");
		// parameter 1: the list that will invoke the compareTo method (List A)
		// parameter 2: the list passed in as a parameter to the compareTo method (List B)
		// parameter 3: the expected result (negative if list A < list B, positive if list A > list B, zero otherwise)
		// parameter 4: a description of the test
		testComparable(new Integer[] {}, 			 new Integer[] {}, 			   ResultRange.ZERO, "List A and B are empty");
		testComparable(new Integer[] {1}, 			 new Integer[] {}, 			   ResultRange.POSITIVE, "List A has more elements");
		testComparable(new Integer[] {}, 			 new Integer[] {1}, 		   ResultRange.NEGATIVE, "List A has fewer elements");
		testComparable(new Integer[] {1}, 	 		 new Integer[] {1, 2}, 		   ResultRange.NEGATIVE, "List A has fewer elements");
		testComparable(new Integer[] {1, 2}, 	 	 new Integer[] {1, 2}, 		   ResultRange.ZERO, "List A and List B are the same size and have the same elements");
		testComparable(new Integer[] {1, 2, 3}, 	 new Integer[] {1, 2, 4}, 	   ResultRange.NEGATIVE, "the lists are the same size; for the first non-matching element, the List A element is smaller)");
		testComparable(new Integer[] {1, 2, 3}, 	 new Integer[] {1, 2, 3}, 	   ResultRange.ZERO, "List A and List B are the same size and have the same elements");
		testComparable(new Integer[] {1, 2, 3, 4}, 	 new Integer[] {1, 2, 3, 2},   ResultRange.POSITIVE, "the lists are the same size; for the first non-matching element, the List A element is bigger");
		testComparable(new String[] {"a", "b", "c"}, new String[] {"a", "d", "a"}, ResultRange.NEGATIVE, "the lists are the same size; for the first non-matching element, the List A element is smaller");
	}
	
	
	/*
	 * The methods below are designed to help support the tests cases run from main. You don't
	 * need to use, modify, or understand these methods. You can safely ignore them. :) 
	 * 
	 * Also, you can ignore the use of generics in the tester methods. These methods use
	 * generics at a level beyond which we use in our class. I only use them here to make this a robust 
	 * and useful testing file. You are NOT required to understand the use of generics in this way.
	 */

	public static <T extends Comparable<? super T>> void testArrayBagRemoveAll(T[] valuesToAdd, T removeValue, String testDescription) {
		int numRemovedExpected = 0;
		ArrayBag<T> bag = new ArrayBag<T>();
		ArrayBag<T> correctBag = new ArrayBag<T>();
		for(T value : valuesToAdd) {
			bag.add(value);
			if(!value.equals(removeValue)) {
				correctBag.add(value);
			} else {
				numRemovedExpected++;
			}
		}
		int originalSize = bag.getCurrentSize();
		int numRemovedActual = bag.removeAll(removeValue);
		Object[] bagContentsAfter = bag.toArray();
		Object[] correctBagContentsAfter = correctBag.toArray();

		System.out.println("\nBag before removing " + removeValue + "\t" + Arrays.toString(valuesToAdd) + "\tSize=" + originalSize);
		System.out.println("Expected bag after:\t" + Arrays.toString(correctBagContentsAfter) + "\tSize=" + correctBag.getCurrentSize());
		System.out.println("Actual bag after:\t" + Arrays.toString(bagContentsAfter) + "\tSize=" + bag.getCurrentSize());
		System.out.println("Expected return value = " + numRemovedExpected);
		System.out.println("Actual return value   = " + numRemovedActual);

		if(bag.getCurrentSize()!=correctBag.getCurrentSize()) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Updated bag is the incorrect size.");
		}
		if(numRemovedExpected!=numRemovedActual) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Incorrect return value.");
		}
		boolean match = true;
		while(!correctBag.isEmpty()) {
			boolean removed = bag.remove(correctBag.remove());
			if(!removed) {
				match = false;
			}
		}
		if(!bag.isEmpty()) {
			match = false;
		}
		if(!match) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Updated bag does not have the expected contents.");		
		}
	}

	public static void testTrimToSizeResults(ResizableArrayBag<Integer> bag, int expectedBagSize, int expectedArrayLength, String testDescription) {
		int actualBagSize = bag.getCurrentSize();
		int actualArrayLength = ( (Object[]) bag.bag).length;


		System.out.println("Expected bag size:\t" + expectedBagSize);
		System.out.println("Actual bag size:  \t" + actualBagSize);
		System.out.println("Expected bag array length: " + expectedArrayLength);
		System.out.println("Expected bag array length: " + actualArrayLength);

		if(actualBagSize!=expectedBagSize) {
			System.out.println("*****Test failed with incorrect bag size for test: " + testDescription);
		}

		if(actualArrayLength!=expectedArrayLength) {
			System.out.println("*****Test failed with incorrect array length for test: " + testDescription);
		}
	}

	public static  <T extends Comparable<? super T>> void testAListRemoveAll(T[] valuesToAdd, T removeValue, String testDescription) {
		AList<T> list = new AList<T>();
		AList<T> correctList = new AList<T>();
		int numRemovedExpected = 0;
		for(T value : valuesToAdd) {
			list.add(value);
			if(!value.equals(removeValue)) {
				correctList.add(value);
			} else {
				numRemovedExpected++;
			}
		}
		int originalSize = list.getLength();
		int numRemovedActual = list.removeAll(removeValue);

		Object[] listContentsAfter = list.toArray();
		Object[] correctListContentsAfter = correctList.toArray();

		System.out.println("\nList before removing " + removeValue + "\t" + Arrays.toString(valuesToAdd) + "\tSize=" + originalSize);
		System.out.println("Expected list after:\t" + Arrays.toString(correctListContentsAfter) + "\tSize=" + correctList.getLength());
		System.out.println("Actual list after:\t" + Arrays.toString(listContentsAfter) + "\tSize=" + list.getLength());
		System.out.println("Expected return value = " + numRemovedExpected);
		System.out.println("Actual return value   = " + numRemovedActual);

		if(list.getLength()!=correctList.getLength()) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Updated list is the incorrect size.");
		}
		if(numRemovedExpected!=numRemovedActual) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Incorrect return value.");
		}

		boolean match = true;
		if(correctList.getLength()!=list.getLength()) {
			match = false;
		} else {
			for(int i=1; i<=list.getLength() && match; i++) {
				if(!list.getEntry(i).equals(correctList.getEntry(i))) {
					match = false;
				}
			}
		}
		if(!match) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Updated list does not have the expected contents.");
		}
	}

	public static <T extends Comparable<? super T>> void testEquivalentLists(T[] listAContents, T[] listBContents, boolean expectedResult, String testDescription) {
		AList<T> listA = new AList<T>(100);
		for(T element : listAContents) {
			listA.add(element);
		}
		AList<T> listB = new AList<T>();
		for(T element : listBContents) {
			listB.add(element);
		}
		boolean actualResult = listA.equals(listB);

		System.out.println("\nInvoking list:  " + Arrays.toString(listA.toArray()) + "\nParameter list: " + Arrays.toString(listB.toArray()));
		System.out.println("Expected result = " + expectedResult);
		System.out.println("Actual result =   " + actualResult);

		if(actualResult!=expectedResult) {
			System.out.println("*****Test failed for: " + testDescription);
		}
	}

	public static enum ResultRange {
		POSITIVE("invoking List A > parameter List B"), NEGATIVE("invoking List A < parameter List B"), ZERO("the two lists are \"equal\"");

		private String text;
		private ResultRange(String text) {
			this.text = text;
		}
		public String toString() {
			return this.text;
		}
	}
	public static <T extends Comparable<? super T>> void testComparable(T[] listAContents, T[] listBContents, ResultRange expectedResultRange, String testDescription) {
		AList<T> listA = new AList<T>(100);
		for(T element : listAContents) {
			listA.add(element);
		}
		AList<T> listB = new AList<T>();
		for(T element : listBContents) {
			listB.add(element);
		}
		int result = listA.compareTo(listB);
		ResultRange resultRange;
		if(result<0) {
			resultRange = ResultRange.NEGATIVE;
		} else if(result>0) {
			resultRange = ResultRange.POSITIVE;
		} else {
			resultRange = ResultRange.ZERO;
		}
		System.out.println("\nInvoking List A:  " + Arrays.toString(listA.toArray()) + "\nParameter List B: " + Arrays.toString(listB.toArray()));
		System.out.println("Expected result = " + expectedResultRange);
		System.out.println("Actual result =   " + resultRange);

		if(resultRange!=expectedResultRange) {
			System.out.println("*****Test failed for: " + testDescription);
		}
	}

}
