import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Room> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.time == o2.time) {
                        return o1.checkIn - o2.checkIn;
                    } else {
                        return o1.time - o2.time;
                    }
                }
        );

        for (String[] timeArr: book_time) {
            int hour = Integer.parseInt(timeArr[0].substring(0, 2)) * 60;
            int minute = Integer.parseInt(timeArr[0].substring(3));
            pq.add(new Room(hour + minute, 1));

            int outHour = Integer.parseInt(timeArr[1].substring(0, 2)) * 60;
            int outMinute = Integer.parseInt(timeArr[1].substring(3)) + 10;
            pq.add(new Room(outHour + outMinute, 0));
        }

        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        while (!pq.isEmpty()) {
            Room room = pq.poll();

            if (room.checkIn == 1) {
                count++;
            } else {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    static class Room {
        int time;
        int checkIn;

        public Room(int time, int checkIn) {
            this.time = time;
            this.checkIn = checkIn;
        }
    }
}