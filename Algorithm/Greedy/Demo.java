package Algorithm.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Demo {
    public static void main(String[] args) {

    }
}
// 一天能够安排的最多的会议
class example01 {
    public static class Meeting {
        public int begin;
        public int end;

        public Meeting(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    /**
     *
     * @param begin 会议允许开始的最早时间
     * @param meetings 会议总数
     * @param end 会议允许的最晚时间时间
     * @return 能够容纳的会议数
     */
    public static int most_meetings(int begin, Meeting[] meetings, int end) {
        // 定义最有价值的对象：会议结束的时间，即会议结束时间越早，越有可能让会议总数更大
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end - o2.end;
            }
        });
        int sum = 0;
        for(Meeting meeting : meetings) {
            if(meeting.begin < begin || meeting.end > end) continue; // 过滤满足标准的会议对象
            begin += meeting.begin; // 更新标准
            sum ++;
        }
        return sum;
    }
}

// 最大字典序的字符串序列
class example02 {
    public static void max_Lexicographic(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        // 定义有价值的东西为：在保证字符串长度相同的情况下，字典序越大的越有价值（即：能够保证最终字符串的字典序越大）
    }
}

class example03 {
    /**
     * 思路：哈夫曼编码为最低的价格
     * @param scale 要切成的比例
     * @return 切金条需要花费的最低价格
     */
    public static int cut_goldBar(int[] scale) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 小根堆：一般贪心算法都需要使用类排序算法，用于获取最有价值的对象
        for(int x : scale) heap.add(x);
        while(heap.size() > 1) {
            heap.add(heap.poll() + heap.poll()) ;
        }
        return heap.poll();
    }
}

class example04 {
    public static class Project {
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int max_profit(int fund, Project[] projects) {
        PriorityQueue<Project> costHeap = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.cost - o2.cost;
            }
        });
        PriorityQueue<Project> profitHeap = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });
        costHeap.addAll(Arrays.asList(projects)); // 定义价值为：在能够执行的前提下，利润越高越有价值
        do {
            while(!costHeap.isEmpty() && costHeap.peek().cost <= fund) profitHeap.add(costHeap.poll());
            if(!profitHeap.isEmpty()) fund += profitHeap.poll().profit; // 如果costHeap本来就是空就有可能导致空指针异常,不断更新初始标准
        } while(!profitHeap.isEmpty());
        return fund;
    }
}



















