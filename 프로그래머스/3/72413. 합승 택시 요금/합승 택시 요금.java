import java.util.*;

class Solution {
    static int N;
    static List<List<Node>> list = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < fares.length; i++) {
            list.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            list.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }
        
        int[] arrS = dijkstra(s);
        int[] arrA = dijkstra(a);
        int[] arrB = dijkstra(b);
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < arrS.length; i++) {
            minCost = Math.min(minCost, arrS[i] + arrA[i] + arrB[i]);
        }
        
        return minCost;
    }
    
    public int[] dijkstra(int n) {
        int[] arr = new int[N + 1];
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.cost > arr[current.to]) {
                continue;
            }
            
            for (Node each : list.get(current.to)) {
                if (current.cost + each.cost < arr[each.to]) {
                    arr[each.to] = current.cost + each.cost;
                    pq.add(new Node(each.to, arr[each.to]));
                }
            }
        }
        
        return arr;
    }
    
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}