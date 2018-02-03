package sword2offer;

public class Q50Part2 {
    int[] exist;
    int index;

    public Q50Part2() {
        exist = new int[256];
        for (int i = 0; i < 256; i++) {
            exist[i] = -1;
        }
        index = 0;
    }

    public void Insert(char ch)
    {
        if (exist[ch] == -1) {
            exist[ch] = index;
        } else if (exist[ch] >= 0) {
            exist[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (exist[i] >= 0 && exist[i] < minIndex) {
                result = (char) i;
                minIndex = exist[i];
            }
        }
        return result;
    }
}
