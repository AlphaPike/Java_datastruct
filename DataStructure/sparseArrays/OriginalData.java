package DataStructure.sparseArrays;

public class OriginalData {
    int[][] data;

    public int[][] getData() {
        return data;
    }

    public OriginalData() {
        data = new int[20][20];
        data[5][10] = 10;
        data[7][9] = 12;
        data[1][3] = 2;
        data[2][8] = 1;
    }
}
