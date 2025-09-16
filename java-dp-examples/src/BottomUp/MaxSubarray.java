class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int c=nums[0];
        int m=c;
        for(int i=1;i<nums.length;i++){
            if(c<0){
                c=0;
            }
            c+=nums[i];
            m=Math.max(m,c);
        }
        return m;
    }
}