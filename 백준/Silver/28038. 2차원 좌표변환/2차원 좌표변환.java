import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int coordinate = sc.nextInt();
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            Coordinate c = new Coordinate(a, b);
            if (coordinate == 1) {
                c = cartesianToPolar(c);
            } else {
                c = polarToCartesian(c);
            }

            System.out.printf("%.8f %.8f\n", c.a, c.b);
        }
    }

    public static Coordinate polarToCartesian(Coordinate c) {
        double x = c.a * Math.cos(c.b);
        double y = c.a * Math.sin(c.b);
        return new Coordinate(x, y);
    }
    // 극 -> 직교

    public static Coordinate cartesianToPolar(Coordinate c) {
        double r = Math.sqrt(Math.pow(c.a, 2) + Math.pow(c.b, 2));
        double theta = r == 0 ? 0 : Math.atan2(c.b, c.a);
        theta = theta >= 0 ? theta : theta + 2 * Math.PI;
        return new Coordinate(r, theta);
    }
    // 직교 -> 극

    static class Coordinate {
        double a;
        double b;

        public Coordinate(double a, double b) {
            this.a = a;
            this.b = b;
        }
    }
}
