class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] c, int target) {
        Arrays.sort(c);
        f(c, target, 0, new ArrayList<>());
        return ans;
    }

    void f(int[] arr, int target, int index, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        }
        if (index >= arr.length)
            return;
        for (int i = index; i < arr.length; i++) {
            if(i>index && arr[i]==arr[i-1])continue;
            
            if (target >= arr[i]) {
                list.add(arr[i]);
                f(arr, target - arr[i], i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}