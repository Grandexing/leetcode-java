package sword2offer;

public class Q10Part2 {
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        int result = 1;
        for (int i = 2; i <= target; i++) {
            result *= 2;
        }
        return result;
    }
}
