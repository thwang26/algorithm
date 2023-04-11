import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tool {
    int progress;
    int speed;

    public Tool(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Tool tool;
        Queue<Tool> queue = new LinkedList();
        ArrayList<Integer> list = new ArrayList();
        int totalDay = 0; // 기능이 100이상이 될 수 있게하는 최소날짜
        int cnt = 0;

        for (int i = 0 ; i < progresses.length ; i++) {
            tool = new Tool(progresses[i], speeds[i]);
            queue.add(tool);
        }

        tool = queue.peek();
        totalDay = (int)Math.ceil((100 - tool.progress) / (double)tool.speed);

        while(!queue.isEmpty()){
            tool = queue.peek();

            if(tool.progress + (totalDay * tool.speed) >= 100) { // totalDay로 계산시 100넘으면

                cnt++;
                queue.poll();

                if (queue.isEmpty()) {
                    list.add(cnt);
                }

            } else {

                if(cnt != 0) {
                    list.add(cnt);
                    cnt = 0;
                }

                totalDay = (int)Math.ceil((100 - tool.progress) / (double)tool.speed);
            } // 100이상이 아니면 이전까지의 cnt를 list에 넣은 후 totalDay 다시계산
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}