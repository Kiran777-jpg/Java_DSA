package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RotateMatrixBy90 {

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int n=matrix.size(), m=matrix.getFirst().size();
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<m;j++) {
                int temp=matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
            Collections.reverse(matrix.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,2,3)));
        matrix.add(new ArrayList<>(Arrays.asList(4,5,6)));
        matrix.add(new ArrayList<>(Arrays.asList(7,8,9)));

        rotateMatrix(matrix);
        for(ArrayList<Integer> arr : matrix) {
            for(int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
