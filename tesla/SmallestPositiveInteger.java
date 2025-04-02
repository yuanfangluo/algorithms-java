package tesla;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
class SmallestPositiveInteger {
    public int solution(int[] A) {

        Queue<int[]> queue = new LinkedList<>();
        // Implement your solution here

        // sort the array
        Arrays.sort(A);

        // find the smallest positive integer
        int smallest = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == smallest) {
                smallest++;
            }
        }
        return smallest;
    }
}