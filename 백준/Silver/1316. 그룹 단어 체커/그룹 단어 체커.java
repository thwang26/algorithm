import java.util.Scanner;

public class Main{
	
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();
    	int group = 0;
    	int[] alpha = new int[26];
    	String daneo;
    	char before = 0;
    	int groupOk;
    	
    	for(int i = 0 ; i < N ; i++) {
    		groupOk = 1;
    		for(int a = 0 ; a < alpha.length ; a++) {
    			alpha[a] = 0;
    		}//초기화 for
    		daneo = scan.next();//단어 입력받기
    		for(int j = 0 ; j < daneo.length() ; j++) {
    			if(j != 0) before = daneo.charAt(j-1);
    			if(before != daneo.charAt(j) && alpha[daneo.charAt(j)-97] == 1)  {
    				groupOk = 0;
    				break;
    			}//현재단어가 이미 입력된 상태이면서 이전단어와 다를 때
    			alpha[daneo.charAt(j)-97] = 1;
    		}
    		if(groupOk == 1) group++;
    	}//단어반복 for
    	System.out.println(group);
    }
}