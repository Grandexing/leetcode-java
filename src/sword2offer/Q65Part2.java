package sword2offer;

public class Q65Part2 {
//    不用新变量交换两个变量的值

    public static void main(String[] args) {
        int[] numbers = {1, 2};
        Q65Part2 q65Part2 = new Q65Part2();
        q65Part2.swap(numbers, 0, 1);
        show(numbers);
        q65Part2.swap1(numbers, 0, 1);
        show(numbers);
    }


    void swap(int[] numbers, int i, int j) {
//        使用加减法
        numbers[i] = numbers[i] + numbers[j];
        numbers[j] = numbers[i] - numbers[j];
        numbers[i] = numbers[i] - numbers[j];
    }


    void swap1(int[] numbers, int i, int j) {
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
    }


    static void show(int[] numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
