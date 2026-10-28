class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] fre1 = new int[26];
        int[] fre2 = new int[26];
        if(s1.length() > s2.length()) return false ;
        for(int i = 0;i<s1.length();i++){
            fre1[s1.charAt(i) - 'a']++;
            fre2[s2.charAt(i) - 'a']++;
        }
        // for(int a : fre1){
        //     System.out.println(a);
        // }
        // System.out.println("next");
        // for(int a : fre2){
        //     System.out.println(a);
        // }
        if(Arrays.equals(fre1, fre2)) {

        return true;
        }
        int n = s1.length();

        for(int i = n;i<s2.length();i++){
            fre2[s2.charAt(i) - 'a']++;
            fre2[s2.charAt(i - n) - 'a']--;

           if(Arrays.equals(fre1, fre2)) return true;
        }

        return false ;
    }
}