import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<Integer, Integer> rootIdx = new HashMap<>();
    static int[] preOrder;
    static int[] inOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String read = br.readLine();
            preOrder = toArray(read);
            read = br.readLine();
            inOrder = toArray(read);
            saveRootIdx();
            getPostOrder(0, preOrder.length, 0, inOrder.length);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void saveRootIdx() {
        for (int i = 0; i < inOrder.length; i++) {
            rootIdx.put(inOrder[i], i);
        }
    }

    private static void getPostOrder(int pStart, int pEnd, int iStart, int iEnd) throws IOException {
        if (pStart >= pEnd || iStart >= iEnd) {
            return;
        }
        int root = preOrder[pStart];
        int rootIdxInOrder = rootIdx.get(root);
        int leftSize = rootIdxInOrder - iStart;

        getPostOrder(pStart + 1, pStart + 1 + leftSize, iStart, rootIdxInOrder);         // 왼쪽 서브트리
        getPostOrder(pStart + 1 + leftSize, pEnd, rootIdxInOrder + 1, iEnd);             // 오른쪽 서브트리
        bw.write(root + " ");
    }

    private static int[] toArray(String read) {
        return Arrays.stream(read.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
