package Tools;

import java.util.Random;

public class GenerateRandomArr {
    public static void main(String[] args) {
        new GenerateRandomArr(5,7).generate();
    }

    int minSize;
    int maxSize;
    int minNum;
    int maxNum;


    public int[] generate () {
        Random random = new Random();
        int[] ans = new int[random.nextInt(maxSize - minSize + 1) + minSize];
        for (int i = 0;i < ans.length;i ++) {
            ans[i] = random.nextInt(maxNum - minNum + 1) + minNum;
        }
        return ans;
    }

    /**
     * 设置成默认的随机算法
     */
    public GenerateRandomArr(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        minNum = 0;
        maxNum = Integer.MAX_VALUE;
    }

    public GenerateRandomArr(int minSize, int maxSize, int minNum, int maxNum) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.minNum = minNum;
        this.maxNum = maxNum;
    }
}
