import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlay = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(genres[i], plays[i], i));
        }

        musicList.sort(((o1, o2) -> {
            if (Objects.equals(o1.genres, o2.genres)) {
                return o2.plays - o1.plays;
            }
            if (o1.plays == o2.plays) {
                return o1.idx - o2.idx;
            }
            return totalPlay.get(o2.genres) - totalPlay.get(o1.genres);
        }));

        Map<String, Integer> maxTwoEachGenre = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (Music each : musicList) {
            int added = maxTwoEachGenre.getOrDefault(each.genres, 0);
            if (added == 2) {
                continue;
            }
            answer.add(each.idx);
            maxTwoEachGenre.put(each.genres, added + 1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Music {
        String genres;
        int plays;
        int idx;

        public Music(String genres, int plays, int idx) {
            this.genres = genres;
            this.plays = plays;
            this.idx = idx;
        }
    }
}