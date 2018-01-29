package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51NQueens {
    public static void main(String[] args) {
        Q51NQueens q51NQueens = new Q51NQueens();
        List<List<String>> result = q51NQueens.solveNQueens_1(4);
        for (List<String> l : result) {
            for (String s:l) {
                System.out.println(s);
            }
            System.out.println();
        }
    }


    public List<List<String>> solveNQueens_1(int n) {
        List<List<String>> lists = new ArrayList<List<String>>();
//        List<String> list = new ArrayList<String>();
        int[] colIndex = new int[n];
        solveNQueens(n, 0, lists, colIndex);
        return lists;
    }

    public void solveNQueens(int n, int row, List<List<String>> lists, int[] colIndex){
//        char[] rowArray = new char[n];
//        for(int i = 0; i < n; i++){
//            rowArray[i] = '.';
//        }
        if(row == n) {
//            lists.add(new ArrayList<String>(list));
            lists.add(construct(colIndex));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(checkValid(row, i, colIndex)){
                colIndex[row] = i;
//                rowArray[i] = 'Q';
//                list.add(new String(rowArray));
                solveNQueens(n, row + 1, lists, colIndex);
//                list.remove(list.size() - 1);
//                rowArray[i] = '.';
            }
        }
    }

    private List<String> construct(int[] colIndex) {
        List<String> one = new ArrayList<>();
        for(int i=0;i<colIndex.length;i++){
            StringBuilder s=new StringBuilder();
            for(int j=0;j<colIndex.length;j++){
                s.append(".");
            }
            s.setCharAt(colIndex[i],'Q');
            one.add(s.toString());
        }
        return one;
    }

    public boolean checkValid(int row, int col, int[] colIndex){
        for(int i = 0; i < row; i++){
            if(col == colIndex[i]){
                return false;
            }

            if(row - i == Math.abs(col - colIndex[i])){
                return false;
            }
        }
        return true;
    }


    public List<List<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        for(int i = 0; i < n; i++) {
            cols[i] = i;
        }
        List<int[]> allResult = new ArrayList<>();
        permitation(cols, allResult, 0);
        List<List<String>> result = new ArrayList<>();
        char[] initial = new char[n];
        for (int i = 0; i < n; i++) {
            initial[i] = '.';
        }
        for (int[] r : allResult) {
            List<String> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                initial[r[i]] = 'Q';
                one.add(new String(initial));
                initial[r[i]] = '.';
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
