import java.util.Scanner;

public class Main {
    static int count = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Person[] arr = new Person[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Person();
        }

        int target1 = sc.nextInt();
        int target2 = sc.nextInt();

        int m = sc.nextInt();
        while(m-- > 0) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            arr[child].parent = arr[parent];
        }

        find(arr[target1], 0);
        find(arr[target2], 0);

        System.out.println(count);
    }

    static void find(Person target, int currentCount) {
        if (target.visited) {
            count = currentCount + target.count;
            return;
        }

        target.visited = true;
        target.count = currentCount;

        if (target.parent != null) {
            find(target.parent, currentCount + 1);
        }
    }

    static class Person {
        Person parent;
        int count;
        boolean visited;
    }
}