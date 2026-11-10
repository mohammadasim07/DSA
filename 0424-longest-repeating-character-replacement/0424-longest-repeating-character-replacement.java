
class Solution {
    public int characterReplacement(String s, int k) {

        int ans = 0;

        for (char target = 'A'; target <= 'Z'; target++) {

            int left = 0;
            int count = 0;

            for (int right = 0; right < s.length(); right++) {

                if (s.charAt(right) != target) {
                    count++;
                }

                while (count > k) {

                    if (s.charAt(left) != target) {
                        count--;
                    }

                    left++;
                }

                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}
