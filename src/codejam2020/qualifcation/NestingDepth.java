package codejam2020.qualifcation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestingDepth {
    private static String repeat(char x, int times){
        StringBuilder result = new StringBuilder();
        for (int t = 1; t <= times; t++)
            result.append(x);

        return result.toString();
    }

    public static void main(String[] args) {
        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= totalCases; ++t) {
            String line = in.nextLine();
            line = '0' + line + '0';
            StringBuilder result = new StringBuilder();

            for(int i=1; i<line.length(); i++){
                int current = Character.getNumericValue(line.charAt(i));
                int previous = Character.getNumericValue(line.charAt(i-1));

                if (current > previous)
                    result.append((repeat('(', current - previous))).append(line.charAt(i));
                else if (current < previous)
                    result.append((repeat(')', previous - current))).append(line.charAt(i));
                else
                    result.append(line.charAt(i));
            }
            result.deleteCharAt(result.lastIndexOf("0"));
            System.out.println("Case #" + t + ": " + result);
        }
    }
}

