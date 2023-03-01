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
        }
        makeNQueens(y, 0, N);
    }

    public static void makeNQueens(int[] y, int x, int N){
        int n = 0;

        if(x == N) {
            cnt++;
            return;
        }
        while(n < N){
            y[x] = n;
            if(queenCheck(x,y)) makeNQueens(y, x+1, N);
            n++;
        }
    }

    public static boolean queenCheck(int x, int[] y){
        int n = 1;
        while(x - n != -1){
            if(Math.abs(x-(x-n)) == Math.abs(y[x]-y[x-n]) || y[x] == y[x-n])
                return false;
            n++;
        }
        return true;
    }
}