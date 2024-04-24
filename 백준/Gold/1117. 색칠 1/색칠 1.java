import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int f = sc.nextInt();
        int c = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        long sum = (long) w * h;
        int height = y2 - y1;
        long leftSquare = (long) (Math.min(x2, f) - Math.min(x1, f)) * height;
        long rightSquare = (long) (Math.min(x2, w - f) - Math.min(x1, w - f)) * height;
        long left = leftSquare * (c + 1);
        long right = rightSquare * (c + 1);
        System.out.println(sum - left - right);
    }
}
