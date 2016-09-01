public class JumpFloorII {
    public int jumpFloorII(int target) {
        if(target<=0)
            return 0;
        if(target == 1)
            return 1;
        return (int)Math.pow(2,target-1);
    }
}
