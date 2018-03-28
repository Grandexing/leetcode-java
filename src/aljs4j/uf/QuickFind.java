package aljs4j.uf;

public class QuickFind implements UF {
    private int[] id;//分量id
    private int count;//分量数量

    public QuickFind(int size) {
        id = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
