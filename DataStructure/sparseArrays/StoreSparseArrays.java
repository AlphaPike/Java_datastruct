package DataStructure.sparseArrays;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StoreSparseArrays {
    static String path = Thread.currentThread().getContextClassLoader().getResource("sparseArrays").getPath();

    public static void main(String[] args) {
        int[][] or = new OriginalData().getData();

        int sum = 0;
        List<int[]> store = new ArrayList<>();
        for (int i = 0;i < or.length;i ++) {
             for (int j = 0;j < or[i].length;j ++) {
                 System.out.print(or[i][j] + "\t");
                 if (or[i][j] != 0) {
                     store.add(new int[]{i, j, or[i][j]});
                     sum ++;
                 }
             }
            System.out.println();
        }
        store.add(new int[]{or.length, or[0].length, sum});

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path + "//gameData"));
            oos.writeObject(store);
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
