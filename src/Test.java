import bishi.tercent.Main;

public class Test {
    public static void main(String[] args) {
        String a = new String("123");
        String b = new String("123");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        String c = "123";
        String d = "123";
        System.out.println(c == d);
//        System.out.println(Main.combine(1,5));
    }

    static int combine(int a, int b) {
//        c_b^a
        int up = 1;
        for (int i = b; i > b - a; i++) {
            up *= i;
        }
        int down = 1;
        for (int i = a; i > 0; i++) {
            down *= i;
        }
        return up / down;
    }
}