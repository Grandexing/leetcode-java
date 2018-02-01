package sword2offer;

/**
 * Created by grande on 2018/2/1.
 */
public class Q50 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        //只有字母，就是26，任意字符。则是256，Unicode则应该用map来做
        int[] countOfChar = new int[256];
        for (int i = 0; i < str.length(); i++) {
            countOfChar[str.charAt(i)]++;
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (countOfChar[str.charAt(i)] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
