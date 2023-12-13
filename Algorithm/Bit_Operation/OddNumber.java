package Algorithm.Bit_Operation;

/**
 * 题目：
 *  查找一个数组中的两个个数为奇数个的数字
 */
public class OddNumber {
    public void twoOdd (int[] source) {
        int eor = 0;
        for (int num: source) {
            eor ^= num;
        }
        // eor = a ^ b;(a和b分别代表数组中的目标数字)  ---我们可以将计算的结果用数学表达式表达出来可以便利后续的推理

        /*
            a ^ b在此处有1说明两数在此处的二进制位不同
            说明a或者b在这个位置必有一个数的二进制位是1
            因此我们只需要在原数组中筛选出即可
         */
        int firstOne = eor & (~eor + 1); // 取得从右边开始的第一个1
        int firstNum = 0;
        for (int num: source) {
            if ((num & firstOne) == firstOne) { // 筛选此处为1的数字
                firstNum ^= num; // 筛选个数为奇数个的数字
            }
        }
        int secondNum = firstNum ^ eor;
        System.out.println(secondNum + " " + firstNum);

    }
}
