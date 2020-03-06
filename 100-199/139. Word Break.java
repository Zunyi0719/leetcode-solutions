// solution 1： DP, dp[i] stands for the s's subarray start from head with length i is a breakable word or not.
// to verify dp[i] is true or false, iterate wordDict, and if(dp[i-str.length()] && str.equals(s.substring(i-str.length(),i)) )
// then dp[i] = true
// solution 2: similar

// solution 1
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            for(String str:wordDict){
                if(str.length()<=i){
                    if(dp[i-str.length()] && str.equals(s.substring(i-str.length(),i)) ){
                        dp[i] = true;
                        break;
                    }
                }
            }    
        }
        return dp[s.length()];
    }
}

// solution 2
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i)) ){
                    dp[i] = true;
                    break;
                }
            }    
        }
        return dp[s.length()];
    }
}