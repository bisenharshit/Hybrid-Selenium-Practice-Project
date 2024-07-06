package Java_Stream_Topic_Practice;

import java.util.Arrays;
import java.util.List;

public class SortedMethod {

	public static void main(String[] args) {
		
		List<Integer> al = Arrays.asList(5,2,1,9,8,7,3,4,6);
		
		//To sort an array list in ascending order (1,2,3,4,5,6,7,8,9)
		
		al.stream().sorted().forEach(num-> System.out.print(num+" "));
	}
}
