package codejam2019.qualifcation;

import java.util.*;
import java.io.*;

public class ForgoneSolution {
    public static void main(String[] args) {

        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = in.nextInt();

        for (int i = 1; i <= totalCases; ++i) {
            String input = in.next();
            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();
            for(int index=0; index<input.length(); index++) {
                char digit = input.charAt(index);
                if (digit == '4') {
                    num1.append('2');
                    num2.append('2');
                } else {
                    num1.append(digit);
                    if (num2.length() != 0)
                        num2.append('0');
                }
            }
            System.out.println("Case #" + i + ": " + num1 + " " + num2);
        }
    }
}

