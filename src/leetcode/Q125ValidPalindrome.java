package leetcode;

public class Q125ValidPalindrome {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
    public static boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        //A-Z 65-90
        //a-z 97-122
        int i = 0;
        int j = cs.length - i;
        i = findNextAlpha(cs, i);
        j = findProvAlpha(cs, j);
        while (i < j) {
        	if (cs[i] != cs[j]) return false;
	        i = findNextAlpha(cs, i);
            j = findProvAlpha(cs, j);
        }
        return true;
    }


    static int findNextAlpha(char[] cs, int i){
        for (; i<cs.length; i++) {
        	if (cs[i] > 64 && cs[i] < 91) {
        		//cs[i] is upper case, convert to lower case
        		cs[i] = (char)(cs[i] + 32);
        		return i;
        	} else if (cs[i] > 96 && cs[i] < 123) {
        		return i;
        	}
        }
        return cs.length;    
    }


    static int findProvAlpha(char[] cs, int j){
        for (; j<cs.length; j++) {
        	if (cs[j] > 64 && cs[j] < 91) {
        		//cs[i] is upper case, convert to lower case
        		cs[j] = (char)(cs[j] + 32);
        		return j;
        	} else if (cs[j] > 96 && cs[j] < 123) {
        		return j;
        	}
        }
        return 0;
    }
}
