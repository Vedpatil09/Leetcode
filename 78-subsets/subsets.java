class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        f(nums,0,new ArrayList<>());
        return ans;
    }
    void f(int [] arr,int index,List<Integer> l){
        if(index==arr.length){
            ans.add( new ArrayList <>(l));
            return;
        }if(arr.length>=index){
            l.add(arr[index]);
            f(arr,index+1,l);
            l.removeLast();
        }
        f(arr,index+1,l);
        
    }
}