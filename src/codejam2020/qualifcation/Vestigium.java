package codejam2020.qualifcation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {

        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = in.nextInt();

        for (int t = 1; t <= totalCases; ++t) {
            int dimension = in.nextInt();
            int [][] matrix = new int [dimension][dimension];

            int trace = 0;
            for(int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++){
                    int value = in.nextInt();
                    if(i==j)
                        trace += value;
                    matrix[i][j] = value;
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            for(int i=0; i<dimension; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < dimension; j++){
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != dimension)
                    rowDuplicates++;
                if (colSet.size() != dimension)
                    colDuplicates++;
            }
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}

