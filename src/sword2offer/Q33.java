package sword2offer;

public class Q33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }


    boolean VerifySquenceOfBST(int [] sequence, int start, int end) {
        if (end <= start) return true;
        int root = sequence[end];
        int i = start;
        //检查左子树
        while (i < end && sequence[i] < root) {
            i++;
        }
        int rightStart = i;
        //检查右子树
        while (i < end) {
            if (sequence[i] < root) {
                return false;
            }
            i++;
        }
        return VerifySquenceOfBST(sequence, start, rightStart - 1)
                && VerifySquenceOfBST(sequence, rightStart, end - 1);
    }
}
