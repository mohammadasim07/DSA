class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int i = 1; i <= n / 2; i++) {

            if (n % i == 0) {

                String sub = s.substring(0, i);
                StringBuilder str = new StringBuilder();

                while (str.length() < n) {
                    str.append(sub);
                }

                if (str.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}