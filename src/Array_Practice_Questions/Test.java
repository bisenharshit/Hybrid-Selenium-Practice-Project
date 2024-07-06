package Array_Practice_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	    public static void main(String[] args) {
	        // To find the missing element from an array
	        int[] arr = {1, 2, 5, 4, 1, 6};
	        Set<Integer> set = new HashSet<>();
	        
	        // Step 1: Copy elements to set to remove duplicates
	        for (int i = 0; i < arr.length; i++) {
	            set.add(arr[i]);
	        }
	        
	        // Step 2: Convert set back to list and sort
	        List<Integer> al = new ArrayList<>(set);
	        Collections.sort(al);
	        System.out.println(al);
	        // Step 3: Update arr with sorted unique elements
	        int[] arr1 = new int[5];
	        for (int i = 0; i < al.size(); i++) {
	            arr1[i] = al.get(i);
	        }
	        
	        // Step 4: Find the missing element
	        int n = arr1.length + 1;
	        int sum = (n * (n + 1)) / 2;
	        
	        for (int i = 0; i < arr1.length; i++) {
	            sum = sum - arr1[i];
	        }
	        
	        // Output the missing element
	        System.out.println("Missing Array Element Is : " + sum);
	    }
	
}
