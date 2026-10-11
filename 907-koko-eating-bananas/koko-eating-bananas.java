
class Solution {

    int maxElement(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int p : piles) {
            if (max < p) {
                max = p;
            }
        }

        return max;
    }

    long calculate(int[] piles, int mid) {
        long total = 0;

        for (int p : piles) {
            total += (p + (long) mid - 1) / mid;
        }

        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElement(piles);
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long hours = calculate(piles, mid);

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
