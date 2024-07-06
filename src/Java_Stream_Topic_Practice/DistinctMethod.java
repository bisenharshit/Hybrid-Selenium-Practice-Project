package Java_Stream_Topic_Practice;

import java.util.Arrays;
import java.util.List;

public class DistinctMethod {

	public static void main(String[] args) {
		
		List<Integer> al = Arrays.asList(2,2,3,5,6,5,7,9,8,7);
		
		//To find the unique elements from an array list
		al.stream().distinct().forEach(num->System.out.println(num));
	}
	
}
