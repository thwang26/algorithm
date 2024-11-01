import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time> timeList = new ArrayList<>();
        while (n-- > 0) {
            String[] time = sc.next().split(":");
            timeList.add(new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1])));
        }

        timeList.sort(null);

        int count = 0;
        int capacity = 0;
        Time taxiTime = new Time(0, 0);
        for (Time each : timeList) {
            if (each.canRideTaxi(taxiTime) && capacity < 3) {
                capacity++;
            } else {
                count++;
                capacity = 1;
                taxiTime = each;
            }
        }

        System.out.println(count);
    }

    static class Time implements Comparable<Time> {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int getTime() {
            return 60 * hour + minute;
        }

        public boolean canRideTaxi(Time taxi) {
            int time = this.getTime();
            int taxiTime = taxi.getTime();

            return time - taxiTime <= 10;
        }

        @Override
        public int compareTo(Time o) {
            if (this.hour == o.hour) {
                return this.minute - o.minute;
            }

            return this.hour - o.hour;
        }
    }
}
