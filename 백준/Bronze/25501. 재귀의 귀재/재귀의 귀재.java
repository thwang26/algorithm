import java.util.Scanner;

public class Main{
	public static int count = 0;
	
    public static int recursion(String s, int l, int r){
    	count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int cnt = scan.nextInt();
    	for(int i = 0 ; i < cnt ; i++) {
    		count = 0;
    		System.out.print(isPalindrome(scan.next()) + " ");
    		System.out.println(count);
    	}
    }
}