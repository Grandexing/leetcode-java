import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] steps = line.toCharArray();
//        scanner.nextLine();
        int q = scanner.nextInt();
        initial();
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            res[i] = find(n, m, x, y, steps);
        }
        for (int i = 0; i < q; i++) {
            System.out.println(res[i]);
        }
    }
    static HashMap<Character, int[]> map = new HashMap<>();


    static int find(int n, int m, int x, int y, char[] steps) {
        int count = 0;
        for (int i = 0; i < steps.length; i++) {
            int[] direct = map.get(steps[i]);
//            System.out.println("direct: "+steps[i]+" "+direct[0] + " "+direct[1]);
            count++;
            if (!in(n, m, x + direct[0], y + direct[1])) {
                break;
            }
            x = x + direct[0];
            y = y + direct[1];
        }
        if (in(x, y, n, m)) {
            return 0;
        }
        return count;
    }


    static boolean in(int n, int m, int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }


    static void initial() {
        map.put('r', new int[] {0, 1});
        map.put('l', new int[] {0, -1});
        map.put('d', new int[] {1, 0});
        map.put('u', new int[] {-1, 0});
    }
}
/*
uuurrdddddl
3
5 6 3 3
5 6 4 2
6 6 4 2
 */