class Solution {
    public boolean lemonadeChange(int[] nums) {
        int a5 = 0;
        int b10 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 5) {
                a5++;
            } else if (nums[i] == 10) {
                b10++;
                int k = (nums[i] / 5) - 1;
                if (k <= a5) {
                    a5 -= k;
                } else if (k > a5) {
                    return false;
                }
            } else {
                int item = nums[i];

                int k = ((item / 10) - 1);
                if (k <= b10) {
                    b10 -= k;
                    item = item - (k*10);
                }
                int l = (item / 5) - 1;
                if (l <= a5) {
                    a5 -= l;
                    item = item - (l*5);
                    System.out.println(item + " " + i);
                }
                else if (item > 5) {
                    return false;
                }
            }

        }

        return true;
    }
}