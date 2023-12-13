package MyHomework.queue;


// 环形队列的关键是取模运算的小算法
public class CircleArrayQueue {
    int front = 0; // front 指向的是第一个元素
    // 指针最好指向最后一个元素的后一个元素，不然不好区分空和满
    int rear = 0;
    int maxSize;
    int[] arr;


    public boolean isEmpty () {
        return front == rear;
    }

    public boolean isFull () {
        return ((rear + 1) % maxSize) == front;
        // 取模表当大于或者等于maxSize的时候从头开始（此处注意，从头开始表示从0开始）
        // rear值的后一个 是front 表示队列已满
    }

    public int poll () {
        if (isEmpty()) throw new RuntimeException("队列已空");
        int val = arr[front]; // 指向之前元素需要一个中间变量记录front对应的值
        // 表示front自加1 并通过取模的方式来达成循环
        front = (front + 1) % maxSize;
        return val;
    }

    public boolean offer (int val) {
        if (isFull()) return false;
        arr[rear] = val;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public int top () {
        if (isEmpty()) throw new RuntimeException("队列已空");
        return arr[(front + 1) % maxSize];
    }
    public int size () {
        // 表示队列中还存放的数据个数

        // 理解：rear - front + 1永远表示rear和front中间元素的个数，当中间元素为负数的时候，表示中间空的元素的个数，减掉最大值干好就是剩下元素的个数
        return (rear - front + maxSize) % maxSize;
    }

    public void show () {
        for (int i = front;i < front + size();i ++) { // 表示的使元素个数所以取不到
            int t = i % maxSize;
            System.out.println(arr[t]);
        }
    }

    public CircleArrayQueue (int maxSize) {
        this.maxSize = maxSize + 1;// 预留一个空间来保证rear指向的是最后一个元素 + 1
        arr = new int[maxSize + 1];
    }
}

class test{
    public static void main(String[] args) {
        // 初始化队列，队列初始化容量为3
        CircleArrayQueue a = new CircleArrayQueue(3);
        System.out.println("判断队列是否为空");
        System.out.println(a.isEmpty());
        // 添加队列
        a.offer(1);
        a.offer(2);
        a.offer(3);

        System.out.println("判断队列是否为满");
        System.out.println(a.isFull());
        System.out.println("取队列顶元素");
        System.out.println(a.top());

        System.out.println("出队列");
        while(!a.isEmpty()) {
            System.out.print(a.poll());
        }


    }
}
