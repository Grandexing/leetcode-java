import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        String a = new String("123");
//        String b = new String("123");
        char[] cs = "1   2".toCharArray();
        int end = removeExtraSpace(cs);
        System.out.println(end);
        System.out.println(new String(Arrays.copyOf(cs, 3)));
    }


    private static int removeExtraSpace(char[] cs) {
        int end = 0;
        int index = 0;
        while (index < cs.length) {
            if (cs[index] == ' ' && index > 0 && cs[index - 1] == ' ') {
                index++;
            } else {
//                end++;
                if (index != end) {
                    System.out.println(end);
                    System.out.println(index);
                    cs[end] = cs[index];
                }
                index++;
                end++;
            }
        }
        return end;
    }
}
