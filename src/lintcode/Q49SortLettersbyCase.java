package lintcode;

public class Q49SortLettersbyCase {
//    http://www.lintcode.com/en/problem/sort-letters-by-case/

    public void sortLetters(char[] chars) {
        // write your code here
        if (chars == null || chars.length == 0) {
            return;
        }
        int i = 0;
        int j = chars.length - 1;
        char temp;
        while (i <= j) {
            while (i <= j && Character.isLowerCase(chars[i])) {
                i++;
            }
            while (i <= j && Character.isUpperCase(chars[j])) {
                j--;
            }
            if (i <= j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
        }
    }
}
