给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/regular-expression-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=2;i<=n;i++){
            dp[0][i]=p.charAt(i-1)=='*'&&dp[0][i-2];
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p.charAt(j)=='*'){
                    dp[i+1][j+1]=dp[i+1][j-1]||(isMatch(s,p,i,j-1)&&dp[i][j+1]);
                }else{
                    dp[i+1][j+1]=dp[i][j]&&isMatch(s,p,i,j);
                }
            }
        }
        return dp[m][n];
    }
    private boolean isMatch(String a,String b,int i,int j){
        return a.charAt(i)==b.charAt(j)||b.charAt(j)=='.';
    }
}

            
   
假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/beautiful-arrangement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    private int count;
    public int countArrangement(int N) {
        backTrack(N,1,new LinkedList<>(),new boolean[N+1]);
        return count;
    }
    private void backTrack(int n,int len,LinkedList<Integer> res,boolean[] isVisited){
        if(len>n){
            count++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!isVisited[i]&&(i%len==0||len%i==0)){
                res.add(i);
                isVisited[i]=true;
                backTrack(n,len+1,res,isVisited);
                isVisited[i]=false;
                res.remove(res.size()-1);
            }
        }
    }
}

你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
class Solution {
    private int count;
    private List<LinkedList<Character>> res=new LinkedList<>();
    public int numTilePossibilities(String tiles) {
        char[] c=tiles.toCharArray();
        Arrays.sort(c);
        int len=tiles.length();
        backTrack(c,len,0,new boolean[len],new LinkedList<Character>());
        return res.size()-1;
    }
    private void backTrack(char[] c,int len,int index,boolean[] isVisited,    
        LinkedList<Character> row){
        res.add(new LinkedList(row));
        if(index>=len){
            return;
        }
        for(int i=0;i<len;i++){
            if(isVisited[i]){
                continue;
            }
            if(i>0&&c[i]==c[i-1]&&!isVisited[i-1]){
                continue;
            }
            row.add(c[i]);
            isVisited[i]=true;
            backTrack(c,len,index+1,isVisited,row);
            isVisited[i]=false;
            row.remove(row.size()-1);
        }
    }
}


class Solution {
    private int count;
    public int numTilePossibilities(String tiles) {
        char[] c=tiles.toCharArray();
        Arrays.sort(c);
        int len=tiles.length();
        backTrack(c,len,0,new boolean[len]);
        return count-1;
    }
    private void backTrack(char[] c,int len,int index,boolean[] isVisited){
        count++;
        if(index>=len){
            return;
        }
        for(int i=0;i<len;i++){
            if(isVisited[i]){
                continue;
            }
            if(i>0&&c[i]==c[i-1]&&!isVisited[i-1]){
                continue;
            }
            isVisited[i]=true;
            backTrack(c,len,index+1,isVisited);
            isVisited[i]=false;
        }
    }
}

