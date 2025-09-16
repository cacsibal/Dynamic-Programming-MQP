class JumpGame2 {
    public int jump(int[] nums) {
        if(nums.length<=1)
            return 0;

        int lastDist=0;
        int dist = 0;
        for(int i = 1;true;i++){
            int newdist=dist;
            for(int j = lastDist;j<=dist;j++){
                if(j+nums[j]>=nums.length-1)
                    return i;
                newdist = Math.max(newdist, j+nums[j]);
            }
            lastDist=dist;
            dist=newdist;
        }
    }

}
