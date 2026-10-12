
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int max = 0;
        int maxChar = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                maxChar = i;
            }
        }

        if (max > (n + 1) / 2) {
            return "";
        }

        char[] result = new char[n];
        int index = 0;

        while (count[maxChar] > 0) {
            result[index] = (char) ('a' + maxChar);
            index += 2;
            count[maxChar]--;
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= n) {
                    index = 1;
                }

                result[index] = (char) ('a' + i);
                index += 2;
                count[i]--;
            }
        }

        return new String(result);
    }
}
