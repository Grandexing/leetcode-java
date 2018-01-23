package sword2offer;

public class Q20 {
    public static void main(String[] args) {
        Solution420 solution420 = new Solution420();
//        有bug！
        System.out.println(isNumeric("+.".toCharArray()));
    }


    static boolean isNumeric(char[] str){
        String s = new String(str);
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//                遇到数字
                numberSeen = true;
            } else if(s.charAt(i) == '.') {
//                如果是小数点，不能在e或小数点之后
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
//                如果是e，不能在e之后，且e前面必须有数字
                if(eSeen || !numberSeen) {
                    return false;
                }
//                重新匹配数字，numberSeen置为false
                numberSeen = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
//                如果是符号，必须在第一位，或在e的后一个字符
                if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }
            } else {
//                其他字符，返回false
                return false;
            }
        }
        return numberSeen;
    }
}

class Solution420 {
    public boolean isNumeric(char[] str) {
//        有bug，123.和123e都能通过
        if (str == null || str.length == 0) return false;
        int index = scanInteger(str, 0);
        if (index < str.length && index >= 0 && str[index] == '.') {
            index++;
            index = scanUnsignedInteger(str, index);
        }
        if (index < str.length && index > 0 && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            index = scanInteger(str, index);
        }
        return index == str.length;
    }


    int scanInteger(char[] str, int index) {
        //成功返回下标，失败返回-1
//        if (index >= str.length || index < 0) return -1;
        if (index < str.length && str[index] == '+' || str[index] == '-') {
            index++;
        }
        return scanUnsignedInteger(str, index);
    }


    int scanUnsignedInteger(char[] str, int index) {
        //成功返回下标，失败返回-1
//        if (index >= str.length || index < 0) return -1;
        while (index < str.length && str[index] <= '9' && str[index] >= '0') {
            index++;
        }
        return index;
    }
}
