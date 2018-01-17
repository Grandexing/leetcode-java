package sword2offer;

public class Q4 {
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        if (str.length() == 0) return str.toString();
        char[] cs = str.toString().toCharArray();
        int spaceCount = 0;
        for (char c : cs) {
            if (c == ' ') spaceCount++;
        }
        if (spaceCount == 0) return str.toString();
        //int newLength = str.length() + 2 * spaceCount;
        StringBuffer sb = new StringBuffer();
        int i = 0;
        //int j = 0;
        while (i < str.length()) {
            if (cs[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(cs[i]);
            }
            i++;
        }
        return sb.toString();
    }
}
