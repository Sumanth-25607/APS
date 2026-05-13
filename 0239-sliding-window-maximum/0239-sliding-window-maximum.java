import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    /**
     * Finds the maximum value in each sliding window of size k.
     * 
     * @param nums The input array of integers.
     * @param k The size of the sliding window.
     * @return An array containing the maximum values of each window.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}
