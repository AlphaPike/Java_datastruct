package demo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int d = sca.nextInt();
        MoonCake[] moonCakes = new MoonCake[n];
        for(int i = 0;i < n;i ++) moonCakes[i] = new MoonCake(sca.nextFloat());
        for(int i = 0;i < n;i ++) moonCakes[i].sale = sca.nextFloat();
        Arrays.sort(moonCakes);
        int p = 0; float sum = 0;
        do {
            sum += moonCakes[p].sale;
            d -= moonCakes[p ++].store;
        } while(d > 0 && p < n);
        if(d < 0) sum += ((float) d / moonCakes[-- p].store) * moonCakes[p].sale;
        System.out.printf("%.2f\n", sum);
    }
}

class MoonCake implements Comparable<MoonCake>{
    float store;
    float sale;

    public MoonCake(float store) {
        this.store = store;
    }

    public MoonCake(float store, float sale) {
        this.store = store;
        this.sale = sale;
    }

    @Override
    public int compareTo(MoonCake o) {
        float x = o.sale / o.store  - sale / store;
        return x > 0? 1 : -1;
    }
}
