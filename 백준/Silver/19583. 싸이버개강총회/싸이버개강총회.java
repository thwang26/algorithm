import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Room room = new Room(st.nextToken(), st.nextToken(), st.nextToken());
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);
            room.add(st.nextToken(), st.nextToken());
        }

        System.out.println(room.finalAttendList.size());
    }

    public static int parseTime(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }

    static class Room {
        int startTime;
        int endTime;
        int deleteTime;
        Set<String> attendList;
        Set<String> finalAttendList;

        public Room(String startTime, String endTime, String deleteTime) {
            this.startTime = parseTime(startTime);
            this.endTime = parseTime(endTime);
            this.deleteTime = parseTime(deleteTime);
            this.attendList = new HashSet<>();
            this.finalAttendList = new HashSet<>();
        }

        public void add(String time, String user) {
            int chattingTime = parseTime(time);

            if (chattingTime <= startTime) {
                attendList.add(user);
            } else if (chattingTime >= endTime && chattingTime <= deleteTime
                    && attendList.contains(user)) {
                finalAttendList.add(user);
            }
        }
    }
}
