package codejam2019.qualifcation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class YouCanGoYourOwnWay {
    public static void main(String[] args) {

        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = in.nextInt();

        for (int i = 1; i <= totalCases; ++i) {
            int size = in.nextInt();
            String path = in.next();
            StringBuilder sb = new StringBuilder((size*2) - 2);
            for(char c : path.toCharArray()){
                sb.append(c == 'E' ? 'S' : 'E');
            }

            System.out.println("Case #" + i + ": " + sb);
        }
    }
}

