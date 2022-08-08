class Meeting{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}
    
class MeetingComparator implements Comparator<Meeting>{
    public int compare(Meeting m1, Meeting m2){
        return m1.start-m2.start;
    }
}

class MyCalendar {
    
    TreeSet<Meeting> set;

    public MyCalendar() {
        set = new TreeSet<Meeting>(new MeetingComparator());
    }
    
    public boolean book(int start, int end) {
        if(set.size()==0){
            set.add(new Meeting(start,end));
            return true;
        }
        Meeting curr = new Meeting(start,end);
        Meeting floor = set.floor(curr);
        if(null !=floor && floor.end>curr.start)
            return false;
        Meeting ceil = set.ceiling(curr);
        if(null !=ceil && ceil.start<curr.end)
            return false;
        set.add(curr);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */