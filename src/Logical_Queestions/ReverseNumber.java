package Logical_Queestions;

public class ReverseNumber {

	public static void main(String[] args) {
		
		int num = 123456;
		int temp = num;
		int rev = 0, rem = 0;
		while(num!=0) {
			rem = num%10;
			rev = rev*10 + rem;
			num /= 10;
		}
		System.out.println("Number is Reverse : "+rev);
	}
}
