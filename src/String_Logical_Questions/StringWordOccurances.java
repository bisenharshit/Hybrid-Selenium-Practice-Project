package String_Logical_Questions;

import java.util.HashMap;
import java.util.Map;

public class StringWordOccurances {

	public static void main(String[] args) {
		
		String str = "Start the Appium server. Open Appium Inspector and connect it to the Appium server. Select the mobile device or emulator that you want to inspect. Appium Inspector displays the screen of the mobile device or emulator";
		String str1 = str.replace(".", "");
	    String[] strarry = str1.split(" ");
	    Map<String, Integer> map = new HashMap<>();
	    for (String word :strarry) {
	    	map.put(word, map.getOrDefault(word, 0)+1);
			}
		    System.out.println(map.size());
			map.forEach((k,v)->System.out.println(" :: "+k+" : "+v+" : "));
	}
}
