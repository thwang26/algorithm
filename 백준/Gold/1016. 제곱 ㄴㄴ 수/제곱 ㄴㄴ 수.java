import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        long min = scan.nextLong();
        long max = scan.nextLong();
        long ans = max - min + 1; //살펴봐야 하는 숫자의 개수
        boolean[] arr = new boolean[(int)ans]; //숫자의 개수만큼을 확인 할 배열 생성
        long i = 2; //처음 제곱수는 2*2 이므로 2로 초기화

        while(i*i <= max){ //제곱수가 max이하일 때 까지만 진행
            long num = min / (i*i);
            if(min % (i*i) != 0) num += 1;

            while(num * (i*i) <= max){
                if(arr[(int)(num * (i*i) - min)] == false){
                    arr[(int)(num * (i*i) - min)] = true;
                    ans--;
                }
                num++;
            }
            i++;
        }
        System.out.println(ans);
    }
}