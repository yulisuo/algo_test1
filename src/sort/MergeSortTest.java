package sort;

import java.util.Arrays;

public class MergeSortTest {


    /**
     * 将数组a和b，合并到src
     * <p>
     * a:       [p,     r]
     * <p>
     * a1:      [p,     q]          i
     * a2:      [q+1,   r]          j
     * tmp                          k
     * <p>
     */
    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[k] = a[i];
                i++;
            } else {
                tmp[k] = a[j];
                j++;
            }
            k++;
        }

        int start = i;  // 包含
        int end = q;   // 不包含
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k] = a[start];
            start++;
            k++;
        }

        for (int l = 0; l <= r - p; l++) {
            a[p + l] = tmp[l];
        }
    }

    public void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    // a: [p, r]
    public void mergeSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;

        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);

        merge(a, p, q, r);
    }

    public static void main(String[] args) {
        MergeSortTest test = new MergeSortTest();
        for (int i = 0; i < 10; i++) {
//            test.testMerge();
            test.testMergeSort();
        }
    }

    public void testMergeSort() {
        int[] a = Utils.getRandomArray(8, 50);
//        Utils.print("生成数组：");
//        Utils.print(a);


        mergeSort(a);
//        Utils.print("排序后：");
//        Utils.print(a);
//        Utils.print("result：" + Utils.isAscend(a));
//        Utils.print("====================");
        if (!Utils.isAscend(a)) {
            Utils.print("fail 排序后：");
            Utils.print(a);
        }
    }

    public void testMerge() {
        int[] a = Utils.getRandomArray(3, 10);
        Utils.print("生成数组：");
        Utils.print(a);

        int mid = 1;
        Arrays.sort(a, 0, mid);
        Arrays.sort(a, mid, a.length);
        Utils.print("前后分段排序：");
        Utils.print(a);

        merge(a, 0, mid, a.length);
        Utils.print("merge 之后：");
        Utils.print(a);

        Utils.print("result：" + Utils.isAscend(a));
        Utils.print("====================");
    }
}
