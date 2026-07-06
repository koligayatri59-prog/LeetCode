import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            Stack<Integer> stack = new Stack<>();
            boolean found = false;

            // Find nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == nums1[i]) {
                    found = true;
                    continue;
                }

                // After finding the element, push all elements to the right
                if (found) {
                    stack.push(nums2[j]);
                }
            }

            ans[i] = -1;

            // The first greater element in the stack is the answer
            while (!stack.isEmpty()) {
                int x = stack.pop();

                if (x > nums1[i]) {
                    ans[i] = x;
                }
            }
        }

        return ans;
    }
}