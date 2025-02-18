/*
Approach: Greedy , we are comparing based on end , so store start, end and pos in an object and then we sort and apply condition
T.C -> o(n) + o(nlogn)+ o(n)
s -> o(3*n) + o(n)
 */
class Meeting {
    int start, end, pos;
    Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting val1, Meeting val2) {
        return val1.end - val2.end;
    }
}

class Solution {
    public int maxMeetings(int start[], int end[]) {
        ArrayList<Meeting> list = new ArrayList<>();
        
        for(int i = 0; i < start.length; i++){
            list.add(new Meeting(start[i], end[i], i+1));
        }
        
        Collections.sort(list, new MeetingComparator());

        int cnt = 1;
        int freetime = list.get(0).end; 
        
        for(int i = 1; i < start.length; i++){
            if(list.get(i).start > freetime){
                cnt++;
                freetime = list.get(i).end;
            }
        }
        
        return cnt;
    }
}