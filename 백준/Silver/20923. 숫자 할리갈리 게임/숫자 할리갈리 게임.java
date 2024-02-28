import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int card = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        Deque<Integer> dodo = new ArrayDeque<>();
        Deque<Integer> susu = new ArrayDeque<>();

        while (card-- > 0) {
            st = new StringTokenizer(br.readLine());
            dodo.addFirst(Integer.parseInt(st.nextToken()));
            susu.addFirst(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> doGround = new ArrayDeque<>();
        Deque<Integer> suGround = new ArrayDeque<>();

        boolean doTurn = true;
        while (turn-- > 0) {
            if (doTurn) {
                doGround.addLast(dodo.pollFirst());
            } else {
                suGround.addLast(susu.pollFirst());
            }

            if (dodo.isEmpty()) {
                System.out.println("su");
                return;
            }

            if (susu.isEmpty()) {
                System.out.println("do");
                return;
            }

            if (!doGround.isEmpty() && !suGround.isEmpty()
                    && doGround.peekLast() + suGround.peekLast() == 5) {
                susu.addAll(doGround);
                susu.addAll(suGround);
                doGround.clear();
                suGround.clear();
            }

            if (!doGround.isEmpty() && doGround.peekLast() == 5
                    || !suGround.isEmpty() && suGround.peekLast() == 5) {
                dodo.addAll(suGround);
                dodo.addAll(doGround);
                doGround.clear();
                suGround.clear();
            }

            doTurn = !doTurn;
        }

        if (susu.size() > dodo.size()) {
            System.out.println("su");
        } else if (susu.size() < dodo.size()) {
            System.out.println("do");
        } else {
            System.out.println("dosu");
        }
    }

}
