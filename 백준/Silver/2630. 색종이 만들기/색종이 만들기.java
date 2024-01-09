import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int totalWhite = 0;
    static int totalBlue = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][];

        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
        }

        dfs(paper, 0, 0, n, n);
        System.out.println(totalWhite);
        System.out.println(totalBlue);
    }

    private static void dfs(int[][] paper, int startX, int startY, int endX,
                            int endY) {
        int blue = 0;
        int n = endY - startY;
        
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (paper[i][j] == 1) {
                    blue++;
                }
            }
        }

        if (blue == n * n) {
            totalBlue++;
            return;
        }
        if (blue == 0) {
            totalWhite++;
            return;
        }
        dfs(paper, startX, startY, startX + n/2, startY + n/2);
        dfs(paper, startX + n/2, startY, startX + n, startY + n/2);
        dfs(paper, startX, startY + n/2, startX + n/2, startY + n);
        dfs(paper, startX + n/2, startY + n/2, startX + n, startY + n);
    }

}
