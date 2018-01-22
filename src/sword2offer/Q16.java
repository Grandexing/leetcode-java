package sword2offer;

public class Q16 {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            if (base == 0) return 0;
            else return 1;
        }
        //未处理异常：指数为负
        if (base == 0) return 0;
        boolean isMinus = exponent < 0;
        if (isMinus) exponent = -exponent;
        double result = powerWithUnsignedExponent1(base, exponent);
        if (isMinus) result = 1 / result;
        return result;
    }


//    算法导论中的解法
    private double power(double base, int exponent){
        if (exponent < 0) return 0;
        if (exponent == 0) return 1;
        if (exponent % 2 == 0){
            return power(base, exponent/2) * power(base, exponent/2);
        } else {
            return power(base, exponent/2) * power(base, exponent/2) * base;
        }
    }


//  更快的乘方函数
    private double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;
        return result;
    }


//基本的乘方函数
    private double powerWithUnsignedExponent1(double base, int exponent) {
        double result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
}
