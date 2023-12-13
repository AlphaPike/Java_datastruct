package DataStructure.sparseArrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Other {
    static String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static void main(String[] args) {
        List<D> l = new ArrayList<>();
        int[][] o = new OriginalData().getData();

        int sum = 0;
        for (int i = 0;i < o.length;i ++) {
            for (int j  = 0;j < o[i].length;j ++) {
                l.add(new D(i, j, o[i][j]));
                sum ++;
            }
        }
        l.add(new D(o.length , o[0].length, sum));
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(path + "\\otherData"));
            oos.writeObject(l);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class RecoverOther {
    public static void main(String[] args) {

        ObjectInputStream ois = null;
        List<D> l = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(Other.path + "\\otherData"));
            l = (List<D>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        D s = l.get(l.size() - 1);
        int[][] alk = new int[s.x][s.y];
        int count = s.val;

        while (count != 0) {
            D a = l.get(count - 1);
            alk[a.x][a.y] = a.val;
            count --;
        }

        for(int[] ps : alk) {
            for (int x : ps) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}

class D implements Serializable{
    private final static long serialVersionUID = 12398402394L;

    int x;
    int y;
    int val;

    public D(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

