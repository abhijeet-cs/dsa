/*
Problem: https://www.naukri.com/code360/problems/printing-longest-increasing-subsequence_8360670?leftPanelTabValue=SUBMISSION
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int x) {
        int n = arr.length;
        int[] len = new int[n];
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            len[i] = 1;
        }

        int maxLengthIdxSoFar = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        hash[i] = j;
                    }
                    if (len[i] > len[maxLengthIdxSoFar]) {
                        maxLengthIdxSoFar = i;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int i = maxLengthIdxSoFar;
        while (hash[i] != i) {
            st.push(arr[i]);
            i = hash[i];
        }
        st.push(arr[i]);

        while (!st.isEmpty()) ans.add(st.pop());
        return ans;
    }
}
