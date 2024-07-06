package Java_Stream_Topic_Practice;

import java.util.ArrayList;
import java.util.List;

public class MapMethod {

	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<>();
		al.add(5);
		al.add(14);
		al.add(2);
		al.add(3);
		
		//To Find the square of number in list which is divisible by 2
		
		al.stream().filter(num->num%2==0).map(num->num*num).forEach(num->System.out.println(num));
	}
}
