import java.util.Scanner;

public class Main {
    static int[] inOrder;
    static int[] postOrder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        inOrder = new int[n];
        for (int i = 0; i < inOrder.length; i++) {
            inOrder[i] = sc.nextInt();
        }
        postOrder = new int[n];
        for (int i = 0; i < postOrder.length; i++) {
            postOrder[i] = sc.nextInt();
        }
        makeTree(0, n, 0, n);
        System.out.println(sb);
    }

    private static void makeTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft == inRight) {
            return;
        }

        int rootIdx = findRootIdx(inLeft, inRight, postRight);
        sb.append(inOrder[rootIdx]).append(" ");

        int leftSize = rootIdx - inLeft;
        makeTree(inLeft, rootIdx, postLeft, postLeft + leftSize);
        makeTree(rootIdx + 1, inRight, postLeft + leftSize, postRight - 1);
    }

    private static int findRootIdx(int inLeft, int inRight, int postRight) {
        int root = postOrder[postRight - 1];
        int rootIdx = -1;
        for (int i = inLeft; i < inRight; i++) {
            if (inOrder[i] == root) {
                rootIdx = i;
                break;
            }
        }
        return rootIdx;
    }

}
