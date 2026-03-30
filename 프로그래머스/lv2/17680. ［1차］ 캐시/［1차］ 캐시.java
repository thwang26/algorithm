import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> cache = new LinkedList<>();

        int idx = 0;
        int totalTime = 0;
        while (idx < cities.length) {
            String city = cities[idx].toLowerCase();

            if (cache.contains(city)) {
                totalTime++;
                cache.remove(city);
            } else {
                totalTime += 5;
            }

            cache.add(city);

            if (cache.size() > cacheSize) {
                cache.poll();
            }

            idx++;
        }

        return totalTime;
    }
}