package DataStructure.sparseArrays;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoverData {
    static String path = Thread.currentThread().getContextClassLoader().getResource("sparseArrays").getPath();
    public static void main(String[] args) {

        ObjectInputStream ois = null;
        List<int[]> l = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path + "\\gameData"));
            l = (List<int[]>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

        int[] s = l.get(l.size() - 1);
        int[][] data = new int[s[0]][s[1]];
        int count = s[2];
        while (count != 0) {
            int[] c = l.get(count - 1);
            data[c[0]][c[1]] = c[2];
            count --;
        }

        for (int[] p : data) {
            for (int x : p) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }

    }
}
