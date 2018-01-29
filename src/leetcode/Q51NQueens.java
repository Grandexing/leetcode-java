package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51NQueens {
    public static void main(String[] args) {
        Q51NQueens q51NQueens = new Q51NQueens();
        List<List<String>> result = q51NQueens.solveNQueens(5);
        for (List<String> l : result) {
            for (String s : l) {
                System.out.println(s);
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        //if (n <= 3) return new ArrayList<>();
        int[] cols = new int[n];
        for(int i = 0; i < n; i++) {
            cols[i] = i;
        }
        // List<int[]> allPossible = new ArrayList<>();
        // permitation(cols, allPossible, 0);
//        for (int[] is: allPossible ) {
//            for (int i : is) {
//                System.out.print(i+",");
//            }
//            System.out.println();
//        }
        List<int[]> allResult = new ArrayList<>();
        permitation(cols, allResult, 0);
        // for (int[] possible : allPossible) {
        //     boolean isPossible = true;
        //     List<String> oneResult = new ArrayList<>();
        //     for (int i = 0; i < n - 1 && isPossible; i++) {
        //         for (int j = i + 1; j < n && isPossible; j++) {
        //             if (Math.abs(j - i) == Math.abs(possible[j] - possible[i])) {
        //                 isPossible = false;
        //                 break;
        //             }
        //         }
        //     }
        //     if (isPossible) {
        //         allResult.add(possible);
        //     }
        // }
//        for (int[] is: allResult) {
//            for (int i : is) {
//                System.out.print(i+",");
//            }
//            System.out.println();
//        }
        List<List<String>> result = new ArrayList<>();
        for (int[] r : allResult) {
            List<String> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (r[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                one.add(sb.toString());
//                System.out.println(sb.toString());
            }
            result.add(one);
        }
        return result;
    }


    void permitation(int[] cols, List<int[]> result, int begin) {
        if (!check(cols, begin)) return;
        if (begin == cols.length && check(cols, begin)) {
            int[] one = Arrays.copyOf(cols, cols.length);
            result.add(one);
            return;
        }
        for (int i = begin; i < cols.length; i++) {
            swap(cols, i, begin);
            permitation(cols, result, begin + 1);
            swap(cols, i, begin);
        }
    }


    boolean check(int[] cols, int begin) {
        boolean isValid = true;
        for (int i = begin - 2; i >= 0; i--) {
            if (Math.abs(cols[i] - cols[begin - 1]) == begin - i - 1) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }


    void swap(int[] cols,int i,int j) {
        int temp = cols[i];
        cols[i] = cols[j];
        cols[j] = temp;
    }
}
