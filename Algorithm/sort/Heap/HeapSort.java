package Algorithm.sort.Heap;

import static Tools.MyFunction.swap;

/**
 * 堆：
 *  又称优先级队列，满足完全二叉树树结构
 *  分为大根堆和小根堆
 *
 *  此处用数组的方式来模拟完全二叉树：
 *      当前节点的左子树下标：i * 2 + 1
 *      当前节点的右子树下标：i * 2 + 2
 *
 *      当前节点的父节点下标： (i - 1) / 2
 *
 * 思路：
 *  每一次将堆结构的最大值取出，并保证剩下的结构依旧是堆结构
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        int heapSize =  arr.length;
        for(int i = arr.length - 1;i >= 0;i --) {
            heapify(arr, i, heapSize);
        } // 将数组先整理成堆结构
        while(heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    /**
     * 思路：
     * @param arr  已经满足大根堆结构的数组
     * @param index 要插入堆结构元素的下标
     */
    public static void heapInsert(int[] arr, int index) {
        int father;
        while(arr[index] > arr[father = (index - 1) / 2]) {
            swap(arr, index, father);
            index = father;
        }
    }

    /**
     * 对某个不满足堆结构的节点进行重组
     * 思路：
     *  对一颗树的根左右节点三者进行比较，大的给根节点
     *  直到越界
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int point; // 默认指向左树
        while((point = index * 2 + 1) < heapSize) {
            if(point + 1 < heapSize && arr[point + 1] > arr[point]) point ++; // 右子树如果存在且大于左数就将右树赋给left
            if(arr[point] < arr[index]) break;
            swap(arr, point, index);
            index = point;
        }
    }

    /**
     * 获取下标元素，并使剩下的数组满足堆结构（模拟黑箱）
     */
    public static int get(int[] arr, int index, int heapSize) {
        int ans = arr[-- heapSize];
        swap(arr, heapSize, index);
        heapify(arr, index, heapSize);
        return ans;
    }
}

class BHeap {
    int[] arr;
    int heapSize;

    /**
     * 插入节点
     * 思路：插入到节点的最后一处，并向上维护大根堆，然后依次和父节点进行比较并层层的向上交换
     * 注意：当交换到堆结构的头部的时候，因为自身不会大于自身所以停止交换
     */
    public void add(int val) {
        if(heapSize == arr.length) expandArr();
        int index = heapSize;
        arr[heapSize++] = val;
        int father;
        while(arr[index] > arr[father = (index - 1) / 2]) {
            swap(arr, index, father);
            index = father;
        }
    }

    public int getMax() {
        return get(0);
    }

    /**
     * 从下标处取节点
     * 思路：取出节点将最后节点放入，并向下维护
     * @param index 取节点的下标
     */
    public int get(int index) {
        if(index >= heapSize) throw new RuntimeException("OutOfRange");
        int ans = arr[index];
        swap(arr, index, --heapSize);
        heapify(index);
        return ans;
    }

    private void expandArr() {
        int[] help = new int[arr.length * 2];
        System.arraycopy(arr, 0, help, 0, arr.length);
        arr = help;
    }

    /**
     * 将小的值向下维护大根堆
     * @param index 要维护的值;
     * 思路：依次向下和子节点比较，直到比子节点更小为止
     * 注意：此处将两个子节点进行比较选出较大者进行比较
     */
    private void heapify(int index) {
        int point;
        while((point = index * 2 + 1) < heapSize) {
            if(point + 1 < heapSize && arr[point + 1] > arr[point]) point ++;
            if(arr[point] > arr[index]) return;
            swap(arr, point, index);
            index = point;
        }
    }

    public BHeap() {
        arr = new int[20];
    }

    public BHeap(int[] arr) {
        for (int i = arr.length - 1; i > 0; i++) {
            heapify(arr[i]);
        }
        this.arr = arr;
    }

}
