package bishi.threesixzero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<long[]> datas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long[] data = new long[3];
            for (int j = 0; j < 3; j++) {
                data[j] = scanner.nextLong();
            }
            datas.add(data);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(find(datas.get(i)));
        }
    }


    private static long find(long[] data) {
        Arrays.sort(data);
        if ((data[0] + data[1]) * 2 <= data[2]) {
            return data[0] + data[1];
        } else {
            return (data[0] + data[1] + data[2]) / 3;
        }
    }
}
