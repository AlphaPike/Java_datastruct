package MyHomework.link;



public class MyLinkedList {
    private Link head;
    private int size;

    public void insert(Link node, int index) {
        index --;
        if(index < size) {
            Link temp = head;
            while(index >= 0) {
                temp = temp.next;
                index --;
            }
            Link next = temp.next;
            temp.next = node;
            node.next = next;
            size ++;
        }

    }

    public void delete(int index) {
        if(index < size) {
            Link temp = head;
            while(index > 0) {
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
            size --;
        }
    }

    public void delete(int begin, int end) {
        Link eNode = get(end);
        Link bNode = head.next;
        for(int i = 0;i < begin - 1;i ++) bNode = bNode.next;
        bNode.next = eNode;
        size -= end - begin;
    }

    public Link get(int index) {
        if(index < size) {
            Link temp = head;
            while(index >=0) {
                temp = temp.next;
                index --;
            }
            return temp;
        }
        return null;
    }

    public void change(Link node, int index) {
        if(index < size) {
            Link temp = head;
            while(index > 0) {
                temp = temp.next;
                index --;
            }
            Link next = temp.next;
            temp.next = node;
            node.next = next.next;
        }
    }

    public void destroy() {
        size = 0;
        this.head = new Link(-1);
    }

    public int getSize() {
        return size;
    }

    public Link getHead() {
        return head.next;
    }

    public MyLinkedList(MyLinkedList list) {
        head = new Link(-1);
        Link n = list.getHead();
        Link node = head;
        while(n != null) {
            node.next = new Link(n.val);
            node = node.next;
            n = n.next;
        }
        size = list.getSize();
    }

    public MyLinkedList() {
        head = new Link(-1);
        size = 0;
    }
}

class Link{
    int val;
    Link next;
    public Link(int val) {this.val = val;}
    public Link(int val, Link next) {this.val = val;this.next = next;}
}

class Main{
    public static void main(String[] args) {
        // 初始化线性表
        System.out.println("向线性表中插入元素");
        MyLinkedList mll = new MyLinkedList();
        for(int i = 0;i < 10;i ++) {
            mll.insert(new Link(i),i);
        }
        System.out.println();

        System.out.println("根据下标获取链表中的元素");
        for(int i = 0;i < mll.getSize();i ++) {
            System.out.print(mll.get(i).val + ",");
        }
        System.out.println();

        System.out.println("删除指定下标位置的元素");
        mll.delete(3);
        for(int i = 0;i < mll.getSize();i ++) {
            System.out.print(mll.get(i).val + ",");
        }
        System.out.println();

        System.out.println("删除指定区间位置的元素");
        mll.delete(1, 3);
        for(int i = 0;i < mll.getSize();i ++) {
            System.out.print(mll.get(i).val + ",");
        }
        System.out.println();

        System.out.println("初始化线性表");
        MyLinkedList copyList = new MyLinkedList(mll);
        for(int i = 0;i < copyList.getSize();i ++) {
            System.out.print(copyList.get(i).val + ",");
        }
        System.out.println();

        System.out.println("清空线性表");
        mll.destroy();
        System.out.println(mll.getSize());
        System.out.println();

    }
}
