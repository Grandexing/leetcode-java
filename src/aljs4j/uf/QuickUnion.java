package aljs4j.uf;

public class QuickUnion implements UF {
    private int[] id;//分量id
    private int count;//分量数量

    public QuickUnion(int size) {
        id = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }


    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
            count--;
        }
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
