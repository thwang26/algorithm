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

        for (String[] timeArr : book_time) {
            pq.add(new Room(parseTime(timeArr[0]), 1));
            pq.add(new Room(parseTime(timeArr[1]) + 10, 0));
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

    public int parseTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2)) * 60;
        int minute = Integer.parseInt(time.substring(3));
        return hour + minute;
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
