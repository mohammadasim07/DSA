class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int[] arr = new int[256];
        

        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            arr[ch] += 1;
        }
        int count = 0;
        int minx = Integer.MAX_VALUE;
        int start = 0;
        int l = 0;
        int r = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(arr[ch] < 1){
                arr[ch] -= 1;
            }else if(arr[ch] > 0 && count < t.length()){
                count++;
                arr[ch] -= 1;
            }

            while(count == t.length()){
           
           if( i - r + 1 < minx){
            minx =i - r + 1;
            start = r;
           }
               char ch2 = s.charAt(r);

                arr[ch2]++;

                if (arr[ch2] > 0) {
                    count--;
                }

                r++;
            }

        System.out.println(minx + " " + r);
        }

        return minx == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minx);
    }
}