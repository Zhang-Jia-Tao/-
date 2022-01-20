package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_quickUnion {
    private int[] id;
    private int count;

    public UF_quickUnion(int N) {
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {   //返回值为该分量的根结点
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        id[pRoot] = qRoot;

        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF_quickUnion uf = new UF_quickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            StdOut.println(p + "\t" + q);
        }
        StdOut.println(uf.count() + " components");
    }
}