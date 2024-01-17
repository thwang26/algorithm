import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Class> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.type.getNum() - o1.type.getNum();
            }
            return o1.time - o2.time;
        });
        while (n-- > 0) {
            sc.nextInt();
            pq.add(new Class(sc.nextInt(), Type.START));
            pq.add(new Class(sc.nextInt(), Type.END));
        }

        int classNumber = 0;
        int maxClassNumber = 0;
        while (!pq.isEmpty()) {
            Class current = pq.poll();

            if (current.type.equals(Type.START)) {
                classNumber++;
            } else {
                classNumber--;
            }
            maxClassNumber = Math.max(maxClassNumber, classNumber);
        }

        System.out.println(maxClassNumber);
    }

    static class Class {
        int time;
        Type type;

        public Class(int time, Type type) {
            this.time = time;
            this.type = type;
        }
    }

    enum Type {
        START(0),
        END(1);

        private final int num;

        Type(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}
