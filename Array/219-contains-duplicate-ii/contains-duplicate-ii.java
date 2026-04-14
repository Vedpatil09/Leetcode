class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int j = 0; j < nums.length; j++){
            for(int i = j + 1; i <= j + k && i < nums.length; i++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}