import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] is = new int[2];
        String[] strings = scan.next().split(" ");
        is[0] = Integer.parseInt(strings[0]);
        is[1] = Integer.parseInt(strings[1]);
        System.out.println("输入的是："+Arrays.toString(is));
    }


}