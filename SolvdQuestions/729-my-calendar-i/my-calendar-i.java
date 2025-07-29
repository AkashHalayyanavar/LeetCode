class MyCalendar {

    // Using TreeMap as we need the entries to be sorted, and also we want to use higherEntry method, 
    // which returns the first entry with key strictly greater than the given key
    TreeMap<Integer, Integer> mp = new TreeMap<>();

    public MyCalendar() {
        // key will be the end time and value will be the start time
        mp.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer, Integer> e = mp.higherEntry(startTime);
        if (endTime <= e.getValue()) {
            mp.put(endTime, startTime);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */