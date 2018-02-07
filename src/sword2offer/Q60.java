package sword2offer;

public class Q60 {
// 面试题60：n个骰子的点数
// 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
// 的所有可能的值出现的概率。

    public static void main(String[] args) {
        Q60 q60 = new Q60();
        q60.test();
    }


    int maxValue = 6;


    void PrintProbability_Solution1(int n) {
        if (n < 1) return;
        int min = n;
        int max = maxValue * n;
        int[] sumCount = new int[max - min + 1];
        getSumCount(n, sumCount);
        printProbability(sumCount, n);
    }

    void printProbability(int[] sumCount, int n) {
        double total = Math.pow(maxValue, n);
        for (int i = 0; i < sumCount.length; i++) {
            double prob = sumCount[i] / total;
            int sum = i + n;
            System.out.println("The probability of sum equals " + sum + " is " + prob);
        }
    }


    void getSumCount(int n, int[] sumCount) {
        for (int i = 1; i <= maxValue; i++) {
            int sum = i;
            getSumCount(n, 0, sum, sumCount);
        }
    }


    void getSumCount(int n, int current, int sum, int[] sumCount) {
        if (current == n - 1) {
            sumCount[sum - n]++;
            return;
        }
        for (int i = 1; i <= maxValue; i++) {
            getSumCount(n, current + 1, sum + i, sumCount);
        }
    }



    void PrintProbability_Solution2(int n) {
        if (n < 1) return;
        int[][] sumCounts = new int[2][maxValue * n + 1];
        int current = 0;
        for (int i = 1; i <= maxValue; i++) {
//            初始化，第一个骰子的值
            sumCounts[current][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
//                第 i 轮和的最小值为 i，小于 i 的位赋值为 0
                sumCounts[1 - current][j] = 0;
            }
            for (int j = i; j <= maxValue * i; j++) {
                sumCounts[1 - current][j] = 0;
//                第 i 轮，和为 n 的次数等于前一轮和为 n - 1, ..., n - 6 的总和
                for (int k = 1; k <= j && k <= maxValue ; k++) {
                    sumCounts[1 - current][j] += sumCounts[current][j - k];
                }
            }
            current = 1 - current;
        }
        double total = Math.pow(maxValue, n);
        for (int i = n; i < maxValue * n + 1; i++) {
            int count = sumCounts[current][i];
            double prob = count / total;
            System.out.println("The probability of sum equals " + i + " is " + prob);
        }
    }


    // ====================测试代码====================
    void Test(int n) {
        System.out.println(String.format("Test for %d begins:\n", n));

        System.out.println("Test for solution1\n");
        PrintProbability_Solution1(n);

        System.out.println("Test for solution2\n");
        PrintProbability_Solution2(n);

        System.out.println("\n");
    }

    void test() {
        Test(1);
        Test(2);
        Test(3);
        Test(4);

        Test(11);

        Test(0);

    }

}
