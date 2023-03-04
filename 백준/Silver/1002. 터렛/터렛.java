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
        
        int t = scan.nextInt();

        while(t != 0){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int r1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int r2 = scan.nextInt();
            int ans = -2;

            if(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) == 0 && r1 == r2) ans = -1;
            //원이 일치
            else if(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) == Math.pow(r1 + r2, 2)) ans = 1;
            //외접
            else if(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) == Math.pow(r1 - r2, 2)) ans = 1;
            //내접
            else if(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) > Math.pow(r1 + r2, 2)) ans = 0;
            //원이 만나지 않음
            else if(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) < Math.pow(r1 - r2, 2)) ans = 0;
            //원 안에 원, 원이 만나지 않음
            else ans = 2;

            t--;
            System.out.println(ans);
        }
    }
}
//hint 경우의 수는 -1(좌표가 같고 원이 같은경우), 0(좌표가 같거나 다르며 거리가 만나지 않는 경우), 
// 1(원이 한 점에서만 겹치는 경우), 2(원이 두 점에서 겹치는 경우)
// sqrt로 제곱근으로 만들면 실수로 바뀐다 ex)3.4444434 , 실수는 값을 비교하는데 정확성이 떨어지기 때문에 
// 값을 비교하려면 제곱을 풀지 말고 그대로 비교해야 정확하다.