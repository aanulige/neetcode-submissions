class Solution {
    public int MAXN = 1001;
    public double stack[] = new double[MAXN];
    public int r;

    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for(int i = 0; i < position.length; i++){
            time[position[i]] = (target - position[i])/(double) speed[i];
        }

        r = 0;
        for(int i = 0; i < target; i++){
            if(time[i] > 0){
                while(r > 0 && stack[r - 1] <= time[i]){
                    double cur = stack[--r];
                }
                stack[r++] = time[i];
            }
        }
        return r;

    }
}
