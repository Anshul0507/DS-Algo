class Plant{
    int plantTime;
    int growTime;
    public Plant(int x, int y){
        this.plantTime=x;
        this.growTime=y;
    }
}
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Plant[] plants = new Plant[plantTime.length];
        for(int i=0;i<plantTime.length;i++)
            plants[i] = new Plant(plantTime[i],growTime[i]);
        Arrays.sort(plants, (p1,p2) -> p2.growTime - p1.growTime);
        int totalPlantTime=0, extraGrowthTime=0;
        for(Plant p: plants){
            totalPlantTime+=p.plantTime;
            extraGrowthTime = Math.max(extraGrowthTime-p.plantTime, p.growTime);
            // System.out.println("Total Plant and Growth time - " + totalPlantTime + " " + extraGrowthTime);
        }
        return totalPlantTime + extraGrowthTime;
    }
}