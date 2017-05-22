/**
 * Created by grande on 2017/5/18.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10+x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    public static void main(String[] args) {
        int x = 232;
        System.out.println(isPalindrome(x));
    }
}
