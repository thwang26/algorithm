class Solution {
    int maxCount = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        recur(k, dungeons, 0);

        return maxCount;
    }

    public void recur(int k, int[][] dungeons, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                recur(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }

        if (maxCount < count) {
            maxCount = count;
        }
    }
}