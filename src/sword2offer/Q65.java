package sword2offer;

public class Q65 {
// 面试题65：不用加减乘除做加法
// 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
// 四则运算符号。

    public static void main(String[] args) {
        Q65 q65 = new Q65();
        System.out.println(q65.add(-1, -2));
    }


    public int add(int num1,int num2) {
        int sum = 0;
        int carry = 0;
        do {
//            无进位加法
            sum = num1 ^ num2;
//            与运算后左移一位，相当于算出进位
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
