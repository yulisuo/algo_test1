package sort

fun main() {
//    testQuickSort()
    testPartition()
}

fun testPartition() {
    for(i in 1..10) {
        val a = Utils.getRandomArray(8, 20);
        Utils.print("生成：")
        Utils.print(a)

        partition(a, 0, a.size - 1)
        Utils.print("分区后：")
        Utils.print(a)
        Utils.print("============")
    }
}

fun testQuickSort() {
    for (x in 1..10) {
        val a = Utils.getRandomArray(12, 100);
//        Utils.print("生成：")
//        Utils.print(a)

        quickSort(a)
//        Utils.print("排序后：")
//        Utils.print(a)
        if (!Utils.isAscend(a)) {
            Utils.print("fail 排序后：")
            Utils.print(a)
        }
    }
}

fun quickSort(a: IntArray) {
    quickSort(a, 0, a.size - 1)
}

fun quickSort(a: IntArray, p: Int, r: Int) {
    if (p >= r) return

    val q = partition(a, p, r)

    quickSort(a, p, q - 1)
    quickSort(a, q + 1, r)
}

/**
 * a  [p, r]
 * 以最后数字作为基准，左边小于基准，右边大于基准，最后返回基准的index
 */
fun partition(a: IntArray, p: Int, r: Int): Int {
    val pivot = a[r]
    var i = p

//    println("pivot=$pivot")

    for (j in p until r) {
        // i的左边都是小于pivot的，右边是大于pivot的。
        // 遍历发现一个小于pivot的，就放到i的左边，方法是：和i交换，i加1
        if (a[j] < pivot) {
            Utils.swap(a, i, j)
            i++
        }
//        println("i=$i, j=$j")
//        Utils.print(a)
//        println("===============")
    }

    Utils.swap(a, i, r)
    return i
}

fun empty() {
    val x = 10
    val y = 3
    if (x in 1..y - 1) {
        println("fits in range")
    }
}