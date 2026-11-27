class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gl = g.length;
        int sl = s.length;
        int i = 0;
        int j = 0;
        while(j < sl && i < gl){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }

        return i ;
    }
}