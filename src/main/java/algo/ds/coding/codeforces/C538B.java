package algo.ds.coding.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class C538B{
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer("");
        ArrayList<Integer> qBinaryNumbers = new ArrayList<>();
        int n = Integer.parseInt(next());

        int dp[] = new int[n+1];
        int dpIndex[] = new int[n+1];

        for(int i = 1; i < 1e6+1; i++) {
            if(quasi(i)) qBinaryNumbers.add(i);
        }

        for(int i = 1; i <= n; i++) {
            if(quasi(i)) dp[i] = 1;
            else {
                int min = 100_000_000;
                int ind = 0;
                while(ind < qBinaryNumbers.size() && qBinaryNumbers.get(ind) <= i) {
                    int current = qBinaryNumbers.get(ind);
                    if(1+dp[i-current] < min) {
                        min = 1+dp[i-current];
                        dpIndex[i] = current;
                    }
                    ind++;
                }
                dp[i] = min;
            }
        }

        StringBuilder sb = new StringBuilder("");
        int ind = n;
        while(dpIndex[ind] != 0) {
            sb.append(dpIndex[ind]+" ");
            ind-=dpIndex[ind];
        }
        sb.append(ind);
        System.out.println(dp[n]);
        System.out.println(sb.toString());
    }

    private static boolean quasi(int n) {
        while(n > 0) {
            int k = n%10;
            if(k != 0 && k != 1)
                return false;
            n/=10;
        }
        return true;
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