import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int dataSize = scanner.nextInt();
        List<List<int[]>> dataList = new ArrayList<>();
        for (int i = 0; i < dataSize; i++){
            int n = scanner.nextInt();
            List<int[]> data = new ArrayList<>();
            for (int j = 0; j < n; j++){
                int[] temp = new int[4];
                for (int k = 0; k < 4; k++){
                    temp[k] = scanner.nextInt();
                }
                data.add(temp);
            }
            dataList.add(data);
        }
        for (List<int[]> data : dataList){
            System.out.println(find(data));
        }
    }
    private static long find(List<int[]> data){
        long res = 0;
        for (int[] a : data){
            res += Math.abs(a[2] - a[0] + 1) * Math.abs(a[3] - a[1] + 1);
        }
        return res;
    }
}