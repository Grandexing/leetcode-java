package lintcode;

public class Q895FriendRequest {
//    http://www.lintcode.com/en/problem/friend-request/

    public int friendRequest(int[] ages) {
        // Write your code here
        int ans = 0;
        for (int a = 0; a < ages.length; a++) {
            for (int b = 0; b < ages.length; b++) {
                if (a == b || ages[b] <= ages[a] / 2 + 7 || ages[b] > ages[a]
                        || (ages[b] < 100 && ages[a] > 100)) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}
