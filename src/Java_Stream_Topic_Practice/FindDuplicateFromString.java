package Java_Stream_Topic_Practice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateFromString {

	public static void main(String[] args) {

		String al = "harshitbisen";
		//Logic by using jdk8 
		Map<String, Long> data = Arrays.stream(al.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(data);
		
		//Logic by using normal
		int[] arr = new int[256];
		for(int i=0; i<al.length(); i++) {
			arr[al.charAt(i)] = arr[al.charAt(i)] + 1;
		}
		for(int i=0; i<al.length();i++) {
			System.out.print(al.charAt(i)+"="+arr[al.charAt(i)]+", ");
		}
	}
}
