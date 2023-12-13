package MyHomework.stack;

public class MyStack {
    int size;
    int[] arr;
    int top;

    public int pop() {
        if(isEmpty()) throw new RuntimeException("栈空");
        return arr[-- top];
    }

    public int getTop() {
        if(isEmpty()) throw new RuntimeException("NullElementException");
        return arr[top - 1];
    }

    public void push(int x) {
        if(isFull()) throw new RuntimeException("栈已满");
        arr[top ++] = x;
    }

    public boolean isFull() {
        return top == size;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
        top = 0;
    }
}

class test {
    public static void main(String[] args) {
        // 创建栈
        MyStack myStack = new MyStack(10);

        System.out.println("判断栈是否为空");
        System.out.println(myStack.isEmpty());

        System.out.println("压栈");
        for(int i = 0;i < 10;i ++) {
            myStack.push(i);
        }
        System.out.println("获取栈顶元素");
        System.out.println(myStack.getTop());

        System.out.println("获取栈内元素的个数");
        System.out.println(myStack.size());

        System.out.println("判断栈是否为满");
        System.out.println(myStack.isFull());

        System.out.println("弹栈");
        while(!myStack.isEmpty()) System.out.print(myStack.pop());

    }
}
