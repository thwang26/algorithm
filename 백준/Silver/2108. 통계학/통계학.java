import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int value;
        int sum = 0;
        int[] arr1 = new int[n];
        int[] arr2 = new int[8001];

        int avg = 0; //평균
        int median = 0; //중앙값
        int mode = 0; //최빈값
        int count = 0; //최빈값의 카운트수
        int span = 0; //범위
        int second = 0;

        for(int i = 0 ; i < n ; i++){
            value = scan.nextInt();
            sum += value;
            arr1[i] = value;
            arr2[value+4000]++;
        }
        Arrays.sort(arr1);
        
        for(int i = 0 ; i < arr2.length ; i++){
            if(count < arr2[i]){
                mode = i;
                count = arr2[i];
            }
        }
        for(int i = 0 ; i < arr2.length ; i++){
            if(count == arr2[i]){
                second++;
            }
            if(second==2) {
                mode = i;
                break;
            }
        }

        avg = (int)Math.round((double)sum/n);
        median = arr1[n/2];

        if(n==1) span = 0;//범위
        else span = arr1[n-1] - arr1[0];

        System.out.println(avg);
        System.out.println(median);
        System.out.println(mode-4000);
        System.out.println(span);
    }
}