class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                // First and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of two numbers from previous row
                    int value = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }
}