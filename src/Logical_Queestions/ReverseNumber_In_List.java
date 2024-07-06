package Logical_Queestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReverseNumber_In_List {
    
	public static void main(String[] args) {
		int temp = 0;
		List<Integer> al = Arrays.asList(1,2,3,4,5,6,7,8);
		for(int al1 :al) {
//			System.out.print(al1);
			temp= temp*10 +al1;
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("*****Normal**Way*******");
		System.out.println("Original Number : "+temp);
		int rev =0, rem=0;
		while(temp!=0) {
			rem = temp%10;
			rev = rev*10+rem;
			temp /= 10;
		}
		System.out.println("Reverse Number  : "+rev);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******JDK8**Way********");
		
		al.forEach(list->{System.out.println(list);
			});
		
		al.stream().collect(Collectors.toList());
		
	}
}

class Test{
	
}

