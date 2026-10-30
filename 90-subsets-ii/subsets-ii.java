class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        f(nums,0,new ArrayList<>());
        return ans;
    }
    void f(int [] arr,int index,List<Integer> list){
        if(arr.length==index){
            if(!ans.contains(list)){
 ans.add(new ArrayList<>(list));
            }
           
            return;
        }
        list.add(arr[index]);
        f(arr,index+1,list);
        list.removeLast();
        f(arr,index+1,list);
    }
}