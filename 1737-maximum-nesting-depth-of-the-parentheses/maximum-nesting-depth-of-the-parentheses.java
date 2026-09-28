class Solution {
    public int maxDepth(String s) {
    //     Deque<Character> stack = new ArrayDeque<>();
    //     int Max=Integer.MIN_VALUE;
    //     for(int i=0;i<s.length();i++){
    //         char ch=s.charAt(i);
            
    //         if(ch=='('){
    //             stack.push(ch);
    //             int count=stack.size();
    //             Max=Math.max(Max,count);
    //         }else if(ch==')'){
    //             stack.pop();
    //         }else continue;

    //     }
    //     if (Max==Integer.MIN_VALUE)return 0;
    // return Max;


          
          int count=0;
          int max=0;
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
                 if(ch=='('){
                    count++;
                }else if(ch==')'){
                    count--;
                }
                max=Math.max(max,count);
        }return max;
}
}