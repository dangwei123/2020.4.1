private static String maxLenStr(String s){
        char[] c=s.toCharArray();
        int maxlen=0;
        int maxst=0;
        int begin=0;
        int i=0;
        while(i<c.length){
            while(i<c.length&&(c[i]>'9'||c[i]<'0')){
                i++;
            }
            begin=i;
            while(i<c.length&&c[i]>='0'&&c[i]<='9'){
                i++;
            }
            if(i-begin>maxlen){
                maxlen=i-begin;
                maxst=begin;
            }
        }
		 return s.substring(maxst,maxst+maxlen);
		 
有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：

空字符串
连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
嵌套，可以记作 (A)，其中 A 是有效括号字符串
类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：

s 为空时，depth("") = 0
s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。

 

给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。

现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。

返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            char c=seq.charAt(i);
            res[i]=c=='('?i&1:(i+1)&1;
        }
        return res;
    }
}

给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

形式上，斐波那契式序列是一个非负整数列表 F，且满足：

0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
F.length >= 3；
对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res=new LinkedList<>();
        backTrack(S,0,S.length()-1,res);
        return res;
    }
    private boolean backTrack(String s,int begin,int end,LinkedList<Integer> res){
        if(begin>end&&res.size()>2){
            return true;
        }
        for(int i=begin;i<=end;i++){
            String tmp=s.substring(begin,i+1);
            if(tmp.length()>1&&tmp.charAt(0)=='0'){
                return false;
            }
            if(Long.valueOf(tmp)>Integer.MAX_VALUE){
                return false;
            }
            int num=Integer.valueOf(tmp);
            int size=res.size();
            if(size<2||(num==res.get(size-1)+res.get(size-2))){
                res.add(num);
                if(backTrack(s,i+1,end,res)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }
}

		 
		
		