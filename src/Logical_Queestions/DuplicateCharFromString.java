package Logical_Queestions;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateCharFromString {

	public static void main(String[] args) {
		
		String str = "hellookkeollop";
		int[] arr = new int[256];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)] = arr[str.charAt(i)]+1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			if(arr[str.charAt(i)] > 1) {
				System.out.println();
			System.out.println("!!Duplicate character!! "+str.charAt(i)+" -- "+arr[str.charAt(i)]);
			}else {
				System.out.println();
			System.out.println("!!Unique character!! "+str.charAt(i)+" -- "+arr[str.charAt(i)]);
			}
			
		}
	}
}
