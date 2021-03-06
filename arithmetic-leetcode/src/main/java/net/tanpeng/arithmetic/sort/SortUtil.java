package net.tanpeng.arithmetic.sort;

/**
 * 排序用的 工具类，主要包括比较元素大小、交换元素顺序等
 */
public class SortUtil {
    public static boolean less(int v, int w) {
        return v < w;
    }

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
