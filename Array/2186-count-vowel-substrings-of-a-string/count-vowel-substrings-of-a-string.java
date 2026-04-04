class Solution {
    public int countVowelSubstrings(String word) {
        if(word.length()<5)return 0;
        
        int count=0;
        int n=word.length();
        for(int i=0;i<n;i++){
            HashSet<Character> set=new HashSet<>();
            for(int j=i;j<n;j++){
                char ch=word.charAt(j);
                if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                    break;
                }else{
                    set.add(ch);}
                if(set.size()==5)count++;
            }
        }return count;
    }
}