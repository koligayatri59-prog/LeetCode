class Solution {
    public boolean validDigit(int n, int x) {
        boolean hasX = false;
        int temp = n;
        
        // Check if the number starts with x by finding the leading digit
        while (temp > 9) {
            hasX = hasX || (temp % 10 == x);
            temp /= 10;
        }
        
        // temp is now the first (most significant) digit
        return hasX && (temp != x);
    }
}