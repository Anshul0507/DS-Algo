class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int durationSoFar = 0;
        int coursesSoFar = 0;
        for(int i =0; i< courses.length;i++){
            int courseDuration = courses[i][0];
            int completeBefore = courses[i][1];
            if(courseDuration > completeBefore)
                continue;
            durationSoFar += courseDuration;
            coursesSoFar++;
            if(durationSoFar > completeBefore){
                coursesSoFar--;
                int maxDurationOfCourseSoFar = pq.peek();
                if(maxDurationOfCourseSoFar > courseDuration){
                    pq.poll();
                    durationSoFar -= maxDurationOfCourseSoFar;
                    pq.add(courseDuration);
                }
                else
                    durationSoFar -= courseDuration;
            }
            else
                pq.add(courseDuration);
        }
        return coursesSoFar;
    }
}