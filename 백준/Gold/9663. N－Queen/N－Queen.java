import java.util.Scanner;

public class Main {
    
    public static int cnt;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        nQueenPuzzle(N);
        System.out.println(cnt);
    }

    public static void nQueenPuzzle(int N){
        int x = 0;
        int[] y = new int[N];

        while(x < N){
            y[x] = -1;
            x++;
        }//배열 초기화
        makeNQueens(y, 0, N);
    }

    public static void makeNQueens(int[] y, int x, int N){
        int n = 0;//배열에 들어갈 y값

        if(x == N) {
            cnt++;
            return;
        }//x가 N과 같아지면 완성되었으므로 cnt 더한 후 종료
        while(n < N){
            y[x] = n; // x인덱스에 y값으로 n을 넣어봄
            if(queenCheck(x,y)) makeNQueens(y, x+1, N); 
            // 퀸체크를 통과했다면 다음 인덱스로 밀어서 재귀
            n++; // y값을 하나 올려서 다음 경우의 수로 이동(맞든 틀리든 하나 올림)
        }
    }

    public static boolean queenCheck(int x, int[] y){
        int n = 1;
        while(x - n != -1){
            if(Math.abs(x-(x-n)) == Math.abs(y[x]-y[x-n]) || y[x] == y[x-n])
                return false; 
                // 가로 세로 대각선 검증(세로는 어차피 인덱스를 이동해서 걸릴 경우의 수가 없어서 가로와 대각선만 검증)
            n++;
        }
        return true; // 통과했다면 true 반환
    }
}