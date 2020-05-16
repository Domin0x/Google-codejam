package codejam2018.qualification;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class TroubleSort {
    public static void main(String[] args) {

        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = in.nextInt();

        for (int i = 1; i <= totalCases; ++i) {
            int size = in.nextInt();
            int[] arr = new int[size];
            for(int j = 0; j < size; j ++){
                arr[j] = in.nextInt();
            }

            int[] troubleArr = troubleSort(arr);
            Arrays.sort(arr);

            int firstDifference = -1;
            for(int j = 0; j < size ; j++){
                if (arr[j] != troubleArr[j]){
                    firstDifference = j;
                    break;
                }
            }
            if (firstDifference >= 0)
                System.out.println("Case #" + i + ": " + firstDifference);
            else
                System.out.println("Case #" + i + ": OK");

        }
    }

    private static int[] troubleSort(int[] arr) {
        int size = arr.length;
        int[] evens = new int [(size+1)/2];
        int[] odds = new int [size/2];
        int[] troubledArr  = new int[size];

        for(int j = 0; j < size ; j++){
            if(j%2 == 0)
                evens[j/2] = arr[j];
            else
                odds[j/2] = arr[j];
        }

        Arrays.sort(evens);
        Arrays.sort(odds);

        for(int j = 0; j < size ; j++){
            if(j%2 == 0)
                troubledArr[j] = evens[j/2];
            else
                troubledArr[j] = odds[j/2];
        }
        return troubledArr;
    }
}

