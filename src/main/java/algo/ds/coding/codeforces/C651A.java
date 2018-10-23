package algo.ds.coding.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class C651A {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");

        int t = Integer.parseInt(next());

        while (t > 0) {
            t -= 1;
            int n = Integer.parseInt(next());
            int a[] = new int[n];
            IntStream.range(0, n).forEach(i -> a[i] = Integer.parseInt(next()));
            int runningSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                runningSum += a[i];
                if (maxSum < runningSum)
                    maxSum = runningSum;
                if (runningSum < 0) {
                    runningSum = 0;
                }
            }
            System.out.println(maxSum);
        }
    }

    public static String next() {
        if (st.hasMoreTokens()) {
            return st.nextToken();
        } else {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
}