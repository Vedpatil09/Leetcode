class Solution {
    public int totalNumbers(int[] digits) {
        int [] arr=new int[10];
        Arrays.fill(arr,-1);
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<digits.length;i++){
            if(digits[i]%2==0){
                arr[i]=digits[i];
            }
        }

        for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<arr.length;k++){
                    if(i!=j && j!=k && k!=i &&arr[k]!=-1){
                        int num=digits[i]*100+digits[j]*10+arr[k];
                        if(num>99){
                        set.add(num);
                        }
                    }
                }
            }
        }return set.size();

    }
}