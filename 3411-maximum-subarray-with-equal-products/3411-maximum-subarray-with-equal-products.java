class Solution {

    int prod(int[] nums, int i, int j) {
        int a = 1;

        for (int k = i; k <= j; k++) {
            a *= nums[k];
        }

        return a;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                int prodre = prod(nums, i, j);

                int k = 0;

                for (int x = i; x <= j; x++) {
                    k = gcd(k, nums[x]);
                }

                int lcmre = 0;
                for (int x = i; x <= j; x++) {
                    lcmre = (lcmre == 0) ? nums[x] : lcm(lcmre, nums[x]);
                }

                if (prodre == k * lcmre) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }
}