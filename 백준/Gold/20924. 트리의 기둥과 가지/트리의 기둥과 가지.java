import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static List<List<Vertex>> vertexList = new ArrayList<>();
    static List<Node> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        IntStream.rangeClosed(0, n).forEach(i -> vertexList.add(new ArrayList<>()));
        IntStream.rangeClosed(0, n).forEach(i -> nodeList.add(new Node(i)));

        while (--n > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            vertexList.get(a).add(new Vertex(a, b, d));
            vertexList.get(b).add(new Vertex(b, a, d));
        }

        int gigaNode = findGigaNode(r);
        int gigaNodeCost = nodeList.get(gigaNode).collectedCost;

        int maxLeafNodeCost = findMaxLeaf(gigaNode);

        System.out.println(gigaNodeCost + " " + maxLeafNodeCost);
    }

    private static int findMaxLeaf(int gigaNode) {
        Queue<Node> queue = new LinkedList<>();

        Node giga = nodeList.get(gigaNode);
        giga.collectedCost = 0;
        queue.add(nodeList.get(gigaNode));

        int maxLeafNodeCost = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            List<Vertex> nextVertex = current.getNext();

            if (nextVertex.size() == 0) {
                maxLeafNodeCost = Math.max(maxLeafNodeCost, current.collectedCost);
                continue;
            }

            for (Vertex each : current.getNext()) {
                Node nextNode = nodeList.get(each.to);

                if (!nextNode.visited) {
                    nextNode.visited = true;
                    nextNode.collectedCost += current.collectedCost + each.cost;
                    queue.add(nextNode);
                }
            }
        }

        return maxLeafNodeCost;
    }

    private static int findGigaNode(int r) {
        int current = r;
        int gigaNode;
        while (true) {
            nodeList.get(current).visited = true;

            List<Vertex> leaf = vertexList.get(current).stream()
                    .filter(vertex -> !nodeList.get(vertex.to).visited)
                    .collect(Collectors.toList());

            if (leaf.size() != 1) {
                gigaNode = current;
                break;
            }

            int next = leaf.get(0).to;

            nodeList.get(next).collectedCost += nodeList.get(current).collectedCost
                    + leaf.get(0).cost;
            current = next;
        }

        return gigaNode;
    }

    static class Vertex {
        int from;
        int to;
        int cost;

        public Vertex(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node {
        int number;
        boolean visited;
        int collectedCost;

        public Node(int number) {
            this.number = number;
        }

        public List<Vertex> getNext() {
            return vertexList.get(number).stream()
                    .filter(vertex -> !nodeList.get(vertex.to).visited)
                    .collect(Collectors.toList());
        }
    }
}
