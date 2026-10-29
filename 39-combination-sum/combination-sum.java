class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] c, int t) {
         
        f(c,t,0,new ArrayList<>());
        return ans;
    }

    void f(int []arr,int t,int index,List<Integer> list){
        if(t==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(index==arr.length)return;

        if(t>=arr[index]){
            list.add(arr[index]);
            f(arr,t-arr[index],index,list);
            list.remove(list.size()-1);
        }

        f(arr,t,index+1,list);
        
        
    }
}