class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<words.size();i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<words.get(i).length();j++){
                char ch=words.get(i).charAt(j);
                if(ch!=separator){
                    sb.append(ch);
                }else if(sb.length()!=0){
                    list.add(sb.toString());
                    sb=new StringBuilder("");
                }
            }if(sb.length()!=0)list.add(sb.toString());
        }
        return list;
    }
}