package Java_Stream_Topic_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterMethod {

	public static void main(String[] args) {
		
		//By One way without creating the collection explicitly so directly we create stream. 
		Stream.of("Hello", "Mohan", "Harshit", "Rohan", "Ayush", "Chhaya", "Kavya", "Bhagyashree").filter(s->s.length()>5).forEach(s->System.out.println(s));
		
		System.out.println();
		
		//By creating the collection and perform stream operation like given below-
		List<String> al = new ArrayList<String>();
		al.add("Hello");
		al.add("Mohan");
		al.add("Harshit");
		al.add("Rohan");
		al.add("Ayush");
		al.add("Chhaya");
		al.add("Kavya");
		al.add("Bhagyashree");
		
		al.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		
	}
}
