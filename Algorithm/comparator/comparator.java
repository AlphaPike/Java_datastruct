package Algorithm.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class comparator implements Comparator<Integer> {
    /**
     *  比较器： 某些方法会调用比较器中的比较方法进行排序
     *  规则：
     *      1.负数的时候第一个数在前
     *      2.正数的时候第二个数在前
     *      3.0无所谓谁在前
     */
    public int compare(Integer a, Integer b) {
        return b - a;
    }

    public static void main(String[] args) {

    }

}


/**
 * Comparable：自己减掉别人是递增，反之是递减
 */
class MyComparator implements Comparable<MyComparator>{
    int a;
    int b;

    public MyComparator(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public int compareTo(MyComparator o) {
        return a - o.a;
    }
}

class demo{
    public static void main(String[] args) {
        MyComparator[] myComparators = {new MyComparator(1, 2), new MyComparator(2, 3), new MyComparator(3, 5)};
        Arrays.sort(myComparators);
        for(MyComparator myComparator : myComparators) {
            System.out.println(myComparator.a);
        }
    }
}
