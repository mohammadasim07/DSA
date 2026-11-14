class Solution {
    public boolean canConstruct(String r, String m) {
        int[] r1 = new int[26]; 
        int[] m2 = new int[26]; 
        for(int i = 0;i<r.length();i++){
            char ch = r.charAt(i);
            r1[ch - 'a']++;
        }
        for(int i = 0;i<m.length();i++){
            char ch = m.charAt(i);
            m2[ch - 'a']++;
        }

        for(int i = 0;i<r.length();i++){
           char ch = r.charAt(i);
           if(r1[ch - 'a'] > m2[ch - 'a']){
            return false;
           }
        }

        return true;
    }
}