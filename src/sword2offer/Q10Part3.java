package sword2offer;

public class Q10Part3 {
    public int RectCover(int target) {
        if (target <= 0) return 0;
        if (target <= 2) return target;
        int stepMinusTwo = 1;
        int stepMinusOne = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = stepMinusOne + stepMinusTwo;
            stepMinusTwo = stepMinusOne;
            stepMinusOne = result;
        }
        return result;
    }
}
