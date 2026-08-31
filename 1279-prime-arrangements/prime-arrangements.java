class Solution {
    private static final int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        int primeCount = countPrimes(n);
        int nonPrimeCount = n - primeCount;
        
        long primeFactorial = factorial(primeCount);
        long nonPrimeFactorial = factorial(nonPrimeCount);
        
        return (int) ((primeFactorial * nonPrimeFactorial) % MOD);
    }

    private int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        java.util.Arrays.fill(isPrime, true);
        int count = 0;
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }

    private long factorial(int num) {
        long res = 1;
        for (int i = 2; i <= num; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }
}
