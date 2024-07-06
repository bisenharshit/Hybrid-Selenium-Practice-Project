package Java_Stream_Topic_Practice;

import java.util.Arrays;
import java.util.List;

public class LimitMethod {

	public static void main(String[] args) {
		
		List<String> al = Arrays.asList("Kavita", "Koyal", "Kavya","Harshit", "Hema", "Himani");
		
		//To Find the name which is available first after sorting.
		
		al.stream().sorted().limit(3).forEach(name->System.out.println(name));
		
	}
}
