package codejam2018.qualification;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SavingTheUniverseAgain {
    public static void main(String[] args) {

        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = in.nextInt();

        for (int i = 1; i <= totalCases; ++i) {
            int maxDamage = in.nextInt();
            String input = in.next();
            String result = result(input, maxDamage);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String result(String input, int maxDamage){
        int changes = 0;
        while(true){
            int totalDamage = 0;
            int missleDamage = 1;
            for (int j = 0; j < input.length(); j++){
                if(input.charAt(j) == 'C')
                    missleDamage*=2;
                else
                    totalDamage += missleDamage;
            }
            if (totalDamage <= maxDamage)
                return String.valueOf(changes);
            int lastIndex = input.lastIndexOf("CS");
            if (lastIndex == -1)
                return "IMPOSSIBLE";
            input = input.substring(0,lastIndex) + "SC" + input.substring(lastIndex+2);
            changes++;
        }
    }
}

