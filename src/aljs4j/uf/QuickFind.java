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
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
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
