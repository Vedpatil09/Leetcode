class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // User function Template for Java

        int N=arr.length;
        if(arr.length==0)return arr;
        // code here
        int sorted[]=Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        HashMap <Integer,Integer> map=new HashMap<>();
        
        int num=sorted[0];
        int rank=1;
        map.put(sorted[0],rank);
        for(int i=1;i<N;i++){
            if(sorted[i]!=sorted[i-1]){
                rank++;
            }
            map.put(sorted[i],rank);
        }
        for(int i=0;i<N;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}
