package sword2offer;

public class Q53 {
    public static void main(String[] args) {
        Q53 q53 = new Q53();
        int[] array = {1,2,3,3,3,3,4,5};
        System.out.println(q53.GetNumberOfK(array, 3));
    }


    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        if (array != null && array.length != 0) {
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);
            System.out.println("first: "+first);
            System.out.println("last: "+last);
            if (first != -1 && last != -1) {
                count = last - first + 1;
            }
        }
        return count;
    }


    int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == k) {
            if ((mid - 1 > 0 && array[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (array[mid] > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(array, k, start, end);
    }


    int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        System.out.println(mid);
        if (array[mid] == k) {
            if ((mid + 1 < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (array[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastK(array, k, start, end);
    }
}
