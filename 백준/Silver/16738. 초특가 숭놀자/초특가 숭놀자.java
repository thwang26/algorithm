import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static Room room;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        room = new Room();
        room.isUsed = new boolean[n + 1];
        while (q-- > 0) {
            String str = sc.next();
            int i = sc.nextInt();
            int j = sc.nextInt();

            if (str.equals("new")) {
                room.add(i, j);
            } else if (str.equals("in")) {
                room.in(i, j);
            } else {
                room.out(i, j);
            }
        }
    }

    static class Room {
        List<Party> list = new ArrayList<>();
        boolean[] isUsed;
        int lastOrder = 0;

        public void add(int count, int width) {
            int roomNumber = checkRoom(width);

            if (roomNumber == -1) {
                System.out.println("REJECTED");
            } else {
                int l = roomNumber;
                int r = roomNumber + width - 1;
                System.out.printf("%d %d\n", l, r);
                bookRoom(roomNumber, width);
                list.add(new Party(++lastOrder, count, l, r, width));
            }
        }

        public void in(int order, int addCount) {
            Party party = findParty(order);
            party.count += addCount;
        }

        public void out(int order, int outCount) {
            Party party = findParty(order);
            party.count -= outCount;
            if (party.count == 0) {
                System.out.printf("CLEAN %d %d\n", party.l, party.r);
                outRoom(party.l, party.r);
            }
        }

        private int checkRoom(int width) {
            int roomNumber = -1;
            int left = 1;
            int right = left + width;
            while (right <= this.isUsed.length) {
                boolean makeAble = true;
                for (int j = left; j < right; j++) {
                    if (this.isUsed[j]) {
                        makeAble = false;
                        left = j + 1;
                        right = left + width;
                        break;
                    }
                }

                if (makeAble) {
                    roomNumber = left;
                    break;
                }
            }

            return roomNumber;
        }

        private void bookRoom(int roomNumber, int width) {
            for (int i = roomNumber; i < roomNumber + width; i++) {
                this.isUsed[i] = true;
            }
        }

        private void outRoom(int l, int r) {
            IntStream.rangeClosed(l, r).forEach(i -> isUsed[i] = false);
        }

        private Party findParty(int order) {
            return list.stream().filter(p -> p.order == order).findFirst().get();
        }
    }
    static class Party {

        int order;
        int count;
        int l;
        int r;
        int width;

        public Party(int order, int count, int l, int r, int width) {
            this.order = order;
            this.count = count;
            this.l = l;
            this.r = r;
            this.width = width;
        }
    }
}
