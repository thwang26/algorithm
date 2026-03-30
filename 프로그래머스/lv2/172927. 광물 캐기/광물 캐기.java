import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int diamond = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        int maxMineral = Math.min(diamond * 5 + iron * 5 + stone * 5, minerals.length);

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < maxMineral; i += 5) {
            String[] part = Arrays.copyOfRange(minerals, i, Math.min(i + 5, maxMineral));

            list.add(part);
        }

        list.sort((o1, o2) -> {
            int o1DiaCount = (int) Arrays.stream(o1).filter(str -> str.equals("diamond")).count();
            int o1IronCount = (int) Arrays.stream(o1).filter(str -> str.equals("iron")).count();
            int o2DiaCount = (int) Arrays.stream(o2).filter(str -> str.equals("diamond")).count();
            int o2IronCount = (int) Arrays.stream(o2).filter(str -> str.equals("iron")).count();

            if (o1DiaCount == o2DiaCount) {
                return o2IronCount - o1IronCount;
            }
            return o2DiaCount - o1DiaCount;
        });

        int idx = 0;
        int count = 0;
        for (String[] arr : list) {
            while (picks[idx] == 0) {
                idx++;
            }
            picks[idx]--;
            for (String mineral : arr) {
                count += matchMineral(idx + 1, mineral);
            }
        }
        return count;
    }

    public int matchMineral(int pick, String mineral) {
        if (pick == 2 && mineral.equals("diamond")) {
            return 5;
        }
        if (pick == 3) {
            if (mineral.equals("diamond")) {
                return 25;
            }
            if (mineral.equals("iron")) {
                return 5;
            }
        }
        return 1;
    }
}