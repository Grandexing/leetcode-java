package sword2offer;

public class Q47 {
    public static void main(String[] args) {
        Q47 q47 = new Q47();
        q47.test();
    }


    public int getMaxValue_solution1(int[][] values, int rows, int cols) {
        if (values == null || values.length == 0|| rows != values.length || cols != values[0].length) return 0;
        int[][] dp = new int[rows][cols];
//        初始化
        dp[0][0] = values[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + values[0][i];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + values[i][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }



    public int getMaxValue_solution2(int[][] values, int rows, int cols) {
        if (values == null || values.length == 0|| rows != values.length || cols != values[0].length) return 0;
//        循环的实质是按行更新，因此只维护一个一维数组即可，当前位置左边已更新，是当前行左边的结果，当前位置代表上一行最大的结果
//        left 和 up 分别对应 maxValues[j - 1] 和 maxValues[j]
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (j > 0) {
                    left = maxValues[j - 1];
                }
                if (i > 0) {
                    up = maxValues[j];
                }
                maxValues[j] = Math.max(left, up) + values[i][j];
            }
        }
        return maxValues[cols - 1];
    }


    void test(String testName, int[][] values, int rows, int cols, int expected)
    {
        if(getMaxValue_solution1(values, rows, cols) == expected)
            System.out.println(testName + ": solution1 passed.");
        else
            System.out.println(testName + ": solution1 FAILED.");

        if(getMaxValue_solution2(values, rows, cols) == expected)
            System.out.println(testName + ": solution2 passed.");
        else
            System.out.println(testName + ": solution2 FAILED.");
    }


    void test1()
    {
        // 三行三列
        int values[][] = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };
        int expected = 29;
        test("test1", values, 3, 3, expected);
    }

    void test2()
    {
        //四行四列
        int values[][] = {
        { 1, 10, 3, 8 },
        { 12, 2, 9, 6 },
        { 5, 7, 4, 11 },
        { 3, 7, 16, 5 }
    };
        int expected = 53;
        test("test2", values, 4, 4, expected);
    }

    void test3()
    {
        // 一行四列
        int values[][] = {
        { 1, 10, 3, 8 }
    };
        int expected = 22;
        test("test3", values, 1, 4, expected);
    }

    void test4()
    {
        int values[][] = {
        { 1 },
        { 12 },
        { 5 },
        { 3 }
    };
        int expected = 21;
        test("test4", values, 4, 1, expected);
    }

    void test5()
    {
        // 一行一列
        int values[][] = {
        { 3 }
    };
        int expected = 3;
        test("test5", values, 1, 1, expected);
    }

    void test6()
    {
        // 空指针
        int expected = 0;
        test("test6", null, 0, 0, expected);
    }

    void test()
    {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
