package algo.ds.coding.codeforces;
/*
* 1. Speak less
* 2. Court Attention All Times
* 3. Avoid Unhappy and Unlucky
* 4. Learn To Keep People Dependent On You (Indisposeble)
* */
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

        int a = Integer.parseInt(next());
        int b = Integer.parseInt(next());

        int count = 0;

        while (a > 0 && b > 0) {
            if (a > b) {
                a -= 2;
                b += 1;
                if(a < 0) break;
            } else {
                a += 1;
                b -= 2;
                if(b < 0) break;
            }
           // System.out.println(a+" "+b);
            count++;
        }

        System.out.println(count);

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