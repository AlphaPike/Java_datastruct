package MyHomework.string;

import java.util.Scanner;

public class MyString {
    private char[] string;
    private int size;

    /**
     * 拷贝传过来的字符串
     * @param s 需要拷贝的字符串
     */
    public MyString(String s) {
        size = s.length();
        string = new char[s.length()];
        for(int i = 0;i < s.length();i ++) {
             string[i] = s.charAt(i);
        }
        // 或者使用API s.toCharArray()
    }

    /**
     * 创建一个长度为length的空串
     * @param length 初始化空串长度
     */
    public MyString(int length) {
        size = 0;
        string = new char[length];
    }

    /**
     * 通过char数组生成串
     */
    public MyString(char[] cs) {
        string = new char[cs.length];
        size = cs.length;
        for(int i = 0;i < cs.length;i ++) {
            string[i] = cs[i];
        }
    }

    /**
     * 以char数组的形式返回String数组
     */
    public char[] toCharArray() {
        char[] copyChars = new char[size];
        for(int i = 0;i < size;i ++) {
            copyChars[i] = string[i];
        }
        return copyChars;
    }

    /**
     * @return 返回字符串的长度
     */
    public int length() {
        return size;
    }

    /**
     * 获取指定下标的元素
     */
    public char charAt(int index) {
        if(index >= size) throw new RuntimeException("下标越界");
        return string[index];
    }

    /**
     * 截取字符串
     * @param begin 开始点（包括）
     * @param end 结束下标（不包括）
     * @return 截取的字符串
     */
    public MyString substring(int begin, int end) {
        if(end > size || begin >= end) throw new RuntimeException("下标异常");
        char[] copyChars = new char[end - begin];
        for(int i = begin;i < end;i ++) {
            copyChars[i - begin] = string[i];
        }
        return new MyString(copyChars);
    }

    /**
     * 删除字符串中的某一段
     * @param begin 起始下标（包括）
     * @param end 结束下标（不包括）
     */
    public void removeString(int begin, int end) {
        if(end > size || begin >= end) throw new RuntimeException("下标异常");
        int length = end - begin;
        for(int i = begin;i + length < size;i ++) {
            string[i] = string[i + length];
        }
        size -= length;
    }

    /**
     * 将字符串B连接到此字符串的末尾
     * @param stringB 要进行插入的字符串
     */
    public void mergeString(MyString stringB) {
        char[] help = new char[size + stringB.length()];
        int index = 0;
        for(int i = 0;i < size;i ++) help[index ++] = string[i];
        for(int i = 0;i < stringB.length();i ++) help[index ++] = stringB.charAt(i);
        this.string = help;
        size += stringB.length();
    }

    /**
     * 在指定下标开始插入字符串
     * @param stringB 待插入的字符串
     * @param begin 插入字符串的下标
     */
    public void insertString(MyString stringB, int begin) {
        if(begin > size) throw new RuntimeException("插入位置异常");
        char[] help = new char[stringB.length() + size];
        int h = 0, t = 0;
        while(t < begin) help[h ++] = string[t ++];
        for(int i = 0;i < stringB.length();i ++) help[h ++] = stringB.charAt(i);
        while(t < size) help[h ++] = string[t ++];
        this.string = help;
        size += stringB.length();
    }

    /**
     * 通过流获取字符串
     * @return 返回从控制台上读入的字符串
     */
    public static MyString scanString() {
        Scanner sca = new Scanner(System.in);
        return new MyString(sca.next());
    }

    /**
     * 通过流输出字符串
     */
    public void showString() {
        for(char c : string) {
            System.out.print(c);
        }
    }
}

class test {
    public static void main(String[] args) {
        /*
        MyString myString = new MyString(new char[]{'a', 'b', 'c', 'd', 'e'});
        System.out.println("创建字符串 & 获取对应下标的字符");
        for(int i = 0;i < myString.length();i ++) {
            System.out.print(myString.charAt(i) + ",");
        }
        System.out.println();

        System.out.println("插入新字符串到旧字符串的末尾");
        MyString mergeString = new MyString(new char[]{'a','c','b'});
        myString.mergeString(mergeString);
        for(int i = 0;i < myString.length();i ++) {
            System.out.print(myString.charAt(i) + ",");
        }
        System.out.println();

        System.out.println("插入新字符串到指定位置");
        MyString insertString = new MyString(new char[]{'t', 'k'});
        myString.insertString(insertString, 3);
        for(int i = 0;i < myString.length();i ++) {
            System.out.print(myString.charAt(i) + ",");
        }
        System.out.println();

        myString.removeString(1, 5);
        System.out.println("删除[1,5)区间上的元素");
        for(int i = 0;i < myString.length();i ++) {
            System.out.print(myString.charAt(i) + ",");
        }
        System.out.println();

        MyString cutString = myString.substring(1, 3);
        System.out.println("截取[1,3)区间上的元素");
        for(int i = 0;i < cutString.length();i ++) {
            System.out.print(cutString.charAt(i) + ",");
        }
        System.out.println();
        */

        MyString createString = new MyString(10);
        System.out.println("创建空串");
        System.out.println("通过流创建空串");
        MyString scanString = MyString.scanString();
        System.out.println("通过流显示空串");
        scanString.showString();

    }
}
