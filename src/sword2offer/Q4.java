package sword2offer;

public class Q4 {

    static boolean find(int target, int [][] array) {
        boolean found = false;
        if(array == null || array.length == 0 || array[0].length == 0) return found;
        int rows = array.length;
        int columns = array[0].length;
        int row = 0;
        int column = columns- 1;
        while (row < rows && column >= 0) {
            if (array[row][column] == target) {
                found = true;
                break;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return found;
    }
}
