import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] square = new int[6];
        int[] news = new int[6];
        int maxWidth = 0;
        int maxHeight = 0;
        int maxH = 0;        
        int maxW = 0;       
        int maxIndex = 0;
        int cutH = 0;
        int cutW = 0;

        for(int i = 0 ; i < 6 ; i++){
            news[i] = scan.nextInt();
            square[i] = scan.nextInt();
            if(news[i] > 2 && square[i] > maxHeight) {
                maxHeight = square[i]; //높이 최대값
                maxH = i; //높이 최대값의 인덱스               
            }
            if(news[i] <= 2 && square[i] > maxWidth) {
                maxWidth = square[i]; //길이 최대값
                maxW = i; //길이 최대값의 인덱스
            }
        }
        if(maxH == 0 && maxW == 5 || maxH == 5 && maxW == 0) maxIndex = 0; // 최대값의 인덱스가 0,5라면 최대인덱스는0
        else maxIndex = Math.max(maxH, maxW); //최대인덱스는 두 숫자 중에 더 큰 값

        if(maxIndex > 3) { // 자르는 곳의 높이, 길이 크기 구하기
            cutH = square[maxIndex-3];
            cutW = square[maxIndex-4];
        }
        else if(maxIndex < 3){
            cutH = square[maxIndex+2];
            cutW = square[maxIndex+3];
        }
        else {
            cutH = square[5];
            cutW = square[0];
        }
        System.out.println(n*(maxHeight*maxWidth-cutH*cutW)); //계산
    }
}