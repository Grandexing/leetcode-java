public class Wine {
    public static void main(String[] args) {
        int n = 148;
        int k = 5;
        System.out.println(wine(n, k));
        System.out.println(wine1(n, k));
    }


    public static int wine1(int n, int k) {
        System.out.println((n / k) * (k - 1) + 1);
        return ((n / k) * (k - 1) + 1) + (n - n / k);
    }


    public static int wine(int n, int k){
        if(k<=0 || n<=0)
            return -1;

        //当前买酒数量
        int buy = 0;
        //当前喝的酒数
        int cur = 0;
        //当前空瓶子数量
        int empty = 0;

        while(cur <= n){
            buy++;
            cur++;
            empty++;

            //空瓶子每够k个就去换1瓶酒
            if(empty % k == 0){
                cur++;
                empty = 1;
            }
        }

        return buy;
    }
}
