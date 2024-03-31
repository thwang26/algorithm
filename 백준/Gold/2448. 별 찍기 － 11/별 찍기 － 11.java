import java.util.Scanner;

public class Main {
    static char[][] arr;
    static char[][] base = {
            {' ', ' ', '*', ' ', ' '},
            {' ', '*', ' ', '*', ' '},
            {'*', '*', '*', '*', '*'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n * 2 - 1];
        dfs(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                sb.append(arr[i][j] == '*' ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int i, int j, int n) {
        if (n == 3) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 5; l++) {
                    arr[k + i][l + j] = base[k][l];
                }
            }
        } else {
            dfs(i, j + n / 2, n / 2); // top
            dfs(i + n / 2, j, n / 2); // left
            dfs(i + n / 2, j + n, n / 2); // right
        }
    }
}
