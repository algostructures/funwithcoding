package algo.ds.coding.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class C545C{
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");

        int n = Integer.parseInt(next());

        int x[] = new int[n];
        int h[] = new int[n];
        int c[] = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(next());
            c[i] = x[i];
            h[i] = Integer.parseInt(next());
        }
        int count = 2;
        if(n == 1)
            count = 1;

        for(int i = 1; i < n-1; i++) {
            if(c[i-1] < x[i] - h[i]) {
                count++;
            } else {
                if(x[i] + h[i] < c[i+1]) {
                    count++;
                    c[i] = x[i]+h[i];
                }
            }
        }
        System.out.print(count);

    }

    public static String next() {
        if(st.hasMoreTokens()) {
            return st.nextToken();
        } else {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
}