class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }

        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[i] = -1;
        }

        for (int rod : rods) {
            int[] curr = dp.clone();

            for (int diff = 0; diff <= sum - rod; diff++) {
                if (curr[diff] == -1) continue;

                dp[diff + rod] = Math.max(dp[diff + rod], curr[diff] + rod);

                int newDiff = Math.abs(diff - rod);
                dp[newDiff] = Math.max(dp[newDiff], curr[diff] + Math.max(0, rod - diff));
            }
        }

        return dp[0];
    }
}