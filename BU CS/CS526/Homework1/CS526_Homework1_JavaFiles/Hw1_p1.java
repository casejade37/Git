/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
import java.util.Arrays;

public class Hw1_p1 {

	/**
	 * find method is used to find if an integer is in an array.
	 * Input:
	 * @param a: an integer array.
	 * @param x: an integer to be found.
	 * Output:
	 * void returns nothing. Only print relevant messages on the screen.
	 */
	public static void find(int[] a, int x) {
		// implement this method
//		initialize a boolean param to false as a flag
		boolean found = false;
//		use a for loop for iteration
		for (int i = 0; i < a.length; i++) {
//			for every iteration, check if x equals to the integer in the array.
			if (a[i] == x) {
//				if integer is found, print its index and run the next iteration.
				System.out.println(x + " is in a[" + i + "]");
//				whenever there is a match, update the flag to true.
				found = true;
			}
		}
//		if the flag is false after iteration, it means the x is not found in the array, print a message.
		if (found == false) {
			System.out.println(x + " does not exist");
		}
	}
	/**
	 * isPrefix method is used to determine if a string is the prefix of another one.
	 * Input:
	 * @param s1: first string assumed to be the shorter one, is yet to be determined if it is the prefix of s2.
	 * @param s2: second string assumed to be the longer one.
	 * Output:
	 * @return: true if s1 is the prefix of s2; otherwise false.
	 */
	public static boolean isPrefix(String s1, String s2) {
		// implement this method
//		use a for loop to iterate all of s1's character.
		for (int i = 0; i < s1.length(); i++) {
//			if any character in s1 doesn't match s2 at the same position, s1 is not the prefix of s2.
			if (s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}
//		s1 is the prefix of s2 if all its characters match the ones in s2 at the same positions.
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {5, 3, 5, 6, 1, 2, 12, 5, 6, 1};
		
		find(a, 5);
		find(a, 10);
		System.out.println();
		
		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";
		
		if (isPrefix(s1,s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}
		
		if (isPrefix(s1,s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
	}
}
