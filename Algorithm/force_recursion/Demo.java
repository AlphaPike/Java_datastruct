package Algorithm.force_recursion;

public class Demo {
    public static void main(String[] args) {
        Hanno.func(3, "左", "右", "中");
    }
}

class Hanno {
    private static void print(String from, String to) {
        System.out.println("将盘子从" + from + "移动到" + to);
    }

    public static void func(int i, String from, String to, String other) {
        if(i == 1) {
            print(from, to);
            return ;
        }
        func(i - 1, from, other, to);
        print(from, to);
        func(i - 1, other, to, from);
    }
}
