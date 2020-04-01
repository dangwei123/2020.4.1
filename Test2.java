
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        int[] arr={6,8};
        for(int j=0;j<2;j++){
            for(int i=arr[j];i<=n;i++){
            dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
            }
        }
        int res=dp[n]==n+1?-1:dp[n];
        System.out.println(res);
        
    }
}

输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
class Solution {
    List<String> res=new LinkedList<>();
    public String[] permutation(String s) {
        char[] c=s.toCharArray();
        Arrays.sort(c);
        int len=c.length;
        backTrack(c,len,0,"",new boolean[len]);
        int size=res.size();
        String[] arr=new String[size];
        int i=0;
        while(size--!=0){
            arr[i++]=res.remove(0);
        }
        return arr;
    }
    private void backTrack(char[] c,int len,int index,String tmp,boolean[] isVisited){
        if(index==len){
            res.add(tmp);
            return;
        }
        for(int i=0;i<len;i++){
            if(isVisited[i]){
                continue;
            }
            if(i>0&&c[i]==c[i-1]&&!isVisited[i-1]){
                continue;
            }
                tmp+=c[i];
                isVisited[i]=true;
                backTrack(c,len,index+1,tmp,isVisited);
                isVisited[i]=false;
                tmp=tmp.substring(0,index);
        }
    }
}

无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
class Solution {
    List<String> res=new LinkedList<>();
    public String[] permutation(String s) {
        char[] c=s.toCharArray();
        int len=c.length;
        backTrack(c,len,0,"",new boolean[len]);
        int size=res.size();
        String[] arr=new String[size];
        int i=0;
        while(size--!=0){
            arr[i++]=res.remove(0);
        }
        return arr;
    }
    private void backTrack(char[] c,int len,int index,String tmp,boolean[] isVisited){
        if(index==len){
            res.add(tmp);
            return;
        }
        for(int i=0;i<len;i++){
            if(!isVisited[i]){
               tmp+=c[i];
                isVisited[i]=true;
                backTrack(c,len,index+1,tmp,isVisited);
                isVisited[i]=false;
                tmp=tmp.substring(0,index);
            }
                
        }
    }
}


有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
class Solution {
    List<String> res=new LinkedList<>();
    public String[] permutation(String s) {
        char[] c=s.toCharArray();
        Arrays.sort(c);
        int len=c.length;
        backTrack(c,len,0,"",new boolean[len]);
        int size=res.size();
        String[] arr=new String[size];
        int i=0;
        while(size--!=0){
            arr[i++]=res.remove(0);
        }
        return arr;
    }
    private void backTrack(char[] c,int len,int index,String tmp,boolean[] isVisited){
        if(index==len){
            res.add(tmp);
            return;
        }
        for(int i=0;i<len;i++){
            if(isVisited[i]){
               continue;
            }
            if(i>0&&c[i]==c[i-1]&&!isVisited[i-1]){
                continue;
            }
                tmp+=c[i];
                isVisited[i]=true;
                backTrack(c,len,index+1,tmp,isVisited);
                isVisited[i]=false;
                tmp=tmp.substring(0,index);
                
        }
    }
}

