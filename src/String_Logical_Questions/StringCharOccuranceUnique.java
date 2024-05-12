package String_Logical_Questions;

import java.util.HashMap;

public class StringCharOccuranceUnique {

	public static void main(String[] args) {

		String str = "india";
		// By using HashMap
		int[] arr = new int[256];
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)] = arr[str.charAt(i)] + 1;
			map.put(str.charAt(i), arr[str.charAt(i)]);
		}

		System.out.println("Using For Each loop simple");
		for (Character ch : map.keySet()) {
			Integer in = map.get(ch);
			System.out.println(ch + " : --> " + in);
		}

		System.out.println("By using jdk8 for Each using stream API");
		map.forEach((k, v) -> System.out.println(k + " : --> " + v));
	}
}


class StringCharOccuranceUnique1 {

	public static void main(String[] args) {

		String str = "india";
		// By without using HashMap
		int[] arr = new int[256];
		

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)] = arr[str.charAt(i)] + 1;
			
		}

		
		for (int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i) + " : --> " + arr[str.charAt(i)]);
		}

	}
}
