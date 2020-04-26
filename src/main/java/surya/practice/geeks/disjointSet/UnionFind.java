package surya.practice.geeks.disjointSet;

import java.util.Set;

public class UnionFind {

    int[] root;
    int[] size;
    int count;

    public UnionFind(int N) {
        root = new int[N]; //number of elements in the set
        size = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            root[i] = i;
            size[i] = 1;
        }


    }

    int find(int p) {
        if (root[p] != p) {
            root[p] = find(root[p]);
        }
        return root[p];
    }
}
