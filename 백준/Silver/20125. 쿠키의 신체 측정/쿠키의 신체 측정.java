import java.util.Scanner;

public class Main {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new char[n][n];
        for (int i = 0; i < map.length; i++) {
            map[i] = sc.next().toCharArray();
        }

        int[] heart = findHeart();
        Cookie cookie = findBody(heart);
        System.out.printf("%d %d\n", heart[0] + 1, heart[1] + 1);
        System.out.println(cookie);
    }

    public static int[] findHeart() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == '*') {
                    return new int[]{i + 1, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    public static Cookie findBody(int[] heart) {
        Cookie cookie = new Cookie();

        Part leftArm = findPart(new int[]{heart[0], heart[1] - 1}, new int[]{0, -1});
        cookie.leftArm = leftArm.length;

        Part rightArm = findPart(new int[]{heart[0], heart[1] + 1}, new int[]{0, 1});
        cookie.rightArm = rightArm.length;

        Part belly = findPart(new int[]{heart[0] + 1, heart[1]}, new int[]{1, 0});
        cookie.belly = belly.length;

        Part leftLeg = findPart(new int[]{belly.end[0] + 1, belly.end[1] - 1}, new int[]{1, 0});
        cookie.leftLeg = leftLeg.length;

        Part rightLeg = findPart(new int[]{belly.end[0] + 1, belly.end[1] + 1}, new int[]{1, 0});
        cookie.rightLeg = rightLeg.length;

        return cookie;
    }

    public static Part findPart(int[] start, int[] add) {
        int partLength = 0;
        int[] part = {start[0], start[1]};
        while (map[part[0]][part[1]] == '*') {
            partLength++;

            int[] nextPart = new int[]{part[0] + add[0], part[1] + add[1]};
            if (isOk(nextPart) && map[nextPart[0]][nextPart[1]] == '*') {
                part[0] = nextPart[0];
                part[1] = nextPart[1];
            } else {
                break;
            }
        }

        return new Part(part, partLength);
    }

    public static boolean isOk(int[] part) {
        return part[0] >= 0 && part[0] < map.length && part[1] >= 0 && part[1] < map.length;
    }

    static class Cookie {
        int leftArm;
        int rightArm;
        int belly;
        int leftLeg;
        int rightLeg;

        @Override
        public String toString() {
            return leftArm
                    + " " + rightArm
                    + " " + belly
                    + " " + leftLeg
                    + " " + rightLeg;
        }
    }

    static class Part {
        int[] end;
        int length;

        public Part(int[] end, int length) {
            this.end = end;
            this.length = length;
        }
    }
}
