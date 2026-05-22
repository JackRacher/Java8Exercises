package examples;

public class XPatternProgram {
	
	public static void main(String[] args) {
		int n = 5;
		char ch = 'A';
		for (int i = n; i >= 1; i--) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(" "+ch);
			}
			System.out.println();
			ch++;
		}
		ch = (char) (ch - 2);
		for (int i = 2; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" "+ch);
			}
			System.out.println();
			ch--;
		}
		for(int i = 1; i <= 5; i++) {
			for(int k = 4; k >= i; k--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		/**
		 * palindrom program
		 */
		n = 121;
		int org = n;
		int rev = 0;
		while(n > 0) {
			int rem = n % 10;
			rev = rev * 10 + rem;
			n = n/10;
		}
		System.out.println(org == rev?"palindrome":"not palindrome");
		System.out.println(n);
		String original = String.valueOf(n);
		String revers = new StringBuilder(original).reverse().toString();
		System.out.println(original.equals(revers)?"palindrome":"not palindrome");
			
		
		
	}
}
