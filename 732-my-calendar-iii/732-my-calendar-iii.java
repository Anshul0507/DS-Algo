class MyCalendarThree {
SegmentTree tree;
    public MyCalendarThree() {
        tree = new SegmentTree(0, (int) 1e9);
    }
    
    public int book(int start, int end) {
        return tree.book(start, end, 0);
    }
    
    private static final class SegmentTree{
        private int start;
        private int end;
        private int middle;
        
        private int bookings;
        private int lazyLeft;
        private int lazyRight;
        
        SegmentTree leftChild;
        SegmentTree rightChild;
        SegmentTree(int start, int end){
            this.start = start;
            this.end = end;
            this.middle = start + (end - start) / 2;
        }
        
        public int book(int bookStart, int bookEnd, int lazy){
            if(lazy != 0){
                this.bookings += lazy;
                this.lazyLeft += lazy;
                this.lazyRight += lazy;
            }
            
            if(bookStart <= this.start && this.end <= bookEnd){
                this.bookings += 1;
                this.lazyLeft += 1;
                this.lazyRight += 1;
                return this.bookings;
            }
            int maxBooking = Integer.MIN_VALUE;
            if(bookStart < this.middle){
                if(this.leftChild == null){
                    this.leftChild = new SegmentTree(this.start, this.middle);
                }
                int lazyChild = this.lazyLeft;
                this.lazyLeft = 0;
                maxBooking = this.leftChild.book(bookStart, bookEnd, lazyChild);
            }
            
            
            if(bookEnd > this.middle){
                if(this.rightChild == null){
                    this.rightChild = new SegmentTree(this.middle, this.end);
                }
                int lazyChild = this.lazyRight;
                this.lazyRight = 0;
                maxBooking = Math.max(maxBooking, this.rightChild.book(bookStart, bookEnd, lazyChild));
            }
            this.bookings = Math.max(this.bookings, maxBooking);
            return bookings;
        }
    } 
}