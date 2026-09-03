import java.util.*;

class Solution {
    public int solution(int[] elements) {

        int N = elements.length;

        int[] arr = new int[N * 2];

        for (int i = 0; i < N * 2; i++) {
            arr[i] = elements[i % N];
        }

        HashSet<Integer> set = new HashSet<>();

        for (int start = 0; start < N; start++) {

            int sum = 0;

            for (int len = 0; len < N; len++) {

                sum += arr[start + len];

                set.add(sum);
            }
        }

        return set.size();
    }
}