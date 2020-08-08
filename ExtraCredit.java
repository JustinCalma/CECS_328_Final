import java.util.Arrays;

public class ExtraCredit {

	public static void main(String[] args) {
		
		// Create an object for the program
		ExtraCredit binary = new ExtraCredit();

		// Create the two example arrays
		int[] a1 = {0, 1, 1, 2, 2, 2, 3, 4, 4};
		int[] a2 = {0, 0, 3, 3, 3, 9, 9, 10, 15};
		
		// Set the key for array 1 to be 2
		int key = 2;
		
		// Find the first and last occurrences of the key from array 1
		int firstOccurrence = binary.findStartIndex(a1, key);
		int lastOccurrence = binary.findEndIndex(a1, key);
		
		// Output to the results to the user
		System.out.println("The first and last occurrence of the key " + key + " from the array " + Arrays.toString(a1) + " is " + firstOccurrence + " & " + lastOccurrence);
		
		// Set the key for array 2 to be 10
		key = 10;
		
		// Find the first and last occurrences of the key from the array 2
		firstOccurrence = binary.findStartIndex(a2, key);
		lastOccurrence = binary.findEndIndex(a2, key);
		
		// Output the results to the user
		System.out.println("The first and last occurrence of the key " + key + " from the array " + Arrays.toString(a2) + " is " + firstOccurrence + " & " + lastOccurrence);
		
	}
	
	// Time Complexity: O(log n) --> Binary Search algorithm
	// Find Start Index Method
	public int findStartIndex(int[] array, int key) {
		
		// Create the variables used 
		int midIdx = 0;
		int lowIdx = 0;
		int highIdx = array.length - 1;
		
		// Set keyIdx to be -1, so if the key does not exist in the array then return -1
		int keyIdx = -1;
		
		// While the right index is greater than the left index, keep looping
		while (highIdx >= lowIdx) {

			// Find the current middle index
			midIdx = (highIdx + lowIdx) / 2;
			
			// Check if the key has been found
			if (key == array[midIdx]) {
				
				// Set the found index to be the middle idex
				keyIdx = midIdx;
				
				// Set the right index to be 1 to the left of the middle to find if the first occurrence
				// is still to the left
				highIdx = midIdx - 1;
				
			// Checks if the value of the key is less than the middle element
			} else if (key < array[midIdx]) {
				
				// Set the right index to be 1 to the left of the middle 
				highIdx = midIdx - 1;
				
			// Else set the left index to be 1 to the right of the middle 
			} else {
				lowIdx = midIdx + 1;
				
			}
		}
		
		// Return the first occurrence of the key or -1 if element is not in array
		return keyIdx;
		
	}
	
	// Time Complexity: O(log n) --> Binary Search algorithm
	// Find End Index Method
	public int findEndIndex(int[] array, int key) {
		
		// Create the variables used 
		int midIdx = 0;
		int lowIdx = 0;
		int highIdx = array.length - 1;
		
		// Set keyIdx to be -1, so if the key does not exist in the array then return -1
		int keyIdx = -1;
		
		// While the right index is greater than the left index, keep looping
		while (highIdx >= lowIdx) {

			// Find the current middle index
			midIdx = (highIdx + lowIdx) / 2;
			
			// Check if the key has been found
			if (key == array[midIdx]) {
				
				// Set the found index to be the middle idex
				keyIdx = midIdx;
				
				// Set the left index to be 1 to the right of the middle 
				lowIdx = midIdx + 1;
				
			// Check if the value of the key is less than the middle element
			} else if (key < array[midIdx]) {
				
				// Set the right index to be 1 to the left of the middle
				highIdx = midIdx - 1;
				
			// Else, set the left index to be 1 to the right of the middle 
			} else {
				lowIdx = midIdx + 1;				
			}
		}
		
		// Return the last occurrence of the key or -1 if element is not in array
		return keyIdx;
		
	}
	
}

// Justin Calma CECS 328 - 14 F 8:00 AM - 12:45 PM