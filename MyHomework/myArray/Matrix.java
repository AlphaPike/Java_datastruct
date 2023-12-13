package MyHomework.myArray;

public class Matrix {
    public int[][] arr;

    public void set(int x, int y, int n) {
        arr[y][x] = n;
    }

    public int get(int x, int y) {
        return arr[y][x];
    }

    public void tr() {
        int[][] help = new int[arr[0].length][arr.length];
        for(int i = 0;i < arr.length;i ++) {
            for(int j = 0;j< arr[0].length;j ++) {
                help[j][i] = arr[i][j];
            }
        }
        arr = help;
    }

    public void show() {
        for(int[] ar : arr) {
            for(int a : ar) {
                System.out.print(a + ",");
            }
            System.out.println();
        }
    }

    public Matrix (int width, int length) {
        arr = new int[length][width];
    }
}

class test {
    public static void main(String[] args) {
        // 初始化数组
        Matrix matrix = new Matrix(3, 4);
        matrix.set(0, 1, 3);
        matrix.set(2, 1, 4);
        matrix.set(0, 3, 7);
        matrix.set(2, 0, 9);
        matrix.set(1, 1, 6);
        matrix.set(0, 2, 1);
        System.out.println("打印输出矩阵");
        matrix.show();

        System.out.println("转置矩阵");
        matrix.tr();
        matrix.show();

    }
}