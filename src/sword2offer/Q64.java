package sword2offer;

public class Q64 {

// 面试题64：求1+2+…+n
// 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。

    public int Sum_Solution(int n) {
        int sum = n;
//        利用短路求值原理完成递归终止控制，n = 0 时第一个条件为假，第二个表达式不执行，直接 return。
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}

