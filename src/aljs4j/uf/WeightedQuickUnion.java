package aljs4j.uf;
import aljs4j.uf.UF;

public class WeightedQuickUnion implements UF {
    private int[] id;//分量id
    private int count;//分量数量
    private int[] sz;//每棵树上的节点数
    private boolean pathCompression = false;

    public WeightedQuickUnion(int size) {
        id = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }


    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        // 将小树作为大树的子树
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            if (pathCompression) {
                // 将p节点的父节点设置为它的爷爷节点
                id[p] = id[id[p]];
            }
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
