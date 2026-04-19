public class BS {
    public static int bs(int[] a, int t) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a[m] == t) return m;
            if (a[m] > t) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
    public static int peak(int[] a) {
        int l = 0, h = a.length - 1;
        while (l < h) {
            int m = (l + h) >>> 1;
            if (a[m + 1] > a[m]) l = m + 1;
            else h = m;
        }
        return l;
    }
    public static int pivot(int[] a) {
        int l = 0, h = a.length - 1;
        while (l < h) {
            int m = (l + h) >>> 1;
            if (a[m] > a[h]) l = m + 1;
            else h = m;
        }
        return l;
    }
}
