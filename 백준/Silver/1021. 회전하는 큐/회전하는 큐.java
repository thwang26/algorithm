import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<Integer>();
        //덱 (앞뒤로 삽입과 삭제가 가능)

        int cnt = 0;
        // 2번, 3번 연산을 하는 횟수

        int N = scan.nextInt();
        int M = scan.nextInt();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        } // 숫자 삽입

        int[] findArr = new int[M];

        for(int i = 0; i < M; i++) {
            findArr[i] = scan.nextInt();
        } // 찾아야 하는 숫자


        for(int i = 0; i < M; i++) {

            int target = deque.indexOf(findArr[i]); // 찾아야 하는 숫자의 인덱스
            int half; // 절반지점의 인덱스

            if(deque.size() % 2 == 0) {
                half = deque.size() / 2 - 1;
            }
            else {
                half = deque.size() / 2;
            }

            if(target <= half) {
                for(int j = 0; j < target; j++) {
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            } // 절반지점보다 가까우면 앞으로 땡겨옴 (2번 연산)
            else {
                for(int j = 0; j < deque.size() - target; j++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }

            } // 절반지점보다 멀면 뒤로 밀어냄 (3번 연산)
            deque.pollFirst(); // 계산한 값을 뽑아냄
        }

        System.out.println(cnt);

    }
}
