package Logical_Queestions;

public class ReverseNumber1 {

	public static void main(String[] args) {
		
		int num = 123456;
		int rev=0, rem = 0;
		int temp =num;
		while(temp!=0) {
			rem = temp%10;
			rev = rev*10 + rem;
			temp /=10;
		}
		System.out.println("Original Number : "+num);
		System.out.println("Reverse Number  : "+rev);
	}
}
