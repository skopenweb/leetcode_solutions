import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MaxMeetings {

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int a, int b) {
            start = a;
            end = b;
        }

        @Override
        public int compareTo(MaxMeetings.Meeting o) {
            return this.start - o.start;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> ll = Arrays.asList(
                Arrays.asList(3, 5),
                Arrays.asList(1, 5),
                Arrays.asList(6, 7),
                Arrays.asList(2, 3),
                Arrays.asList(1, 4));

        List<Meeting> meets = new LinkedList<>();

        for (List<Integer> l : ll) {
            int s = l.get(0);
            int e = l.get(1);
            meets.add(new Meeting(s, e));
        }

        Collections.sort(meets, new Comparator<Meeting>() {
            @Override
            public int compare(MaxMeetings.Meeting o1, MaxMeetings.Meeting o2) {
                return o1.start - o2.start;
            }
        });

        for (Meeting m : meets) {
            System.out.println("[" + m.start + ", " + m.end + "]");
        }

        int max = 0;
        List<Meeting> rooms = new LinkedList<>();

        for (Meeting m : meets) {
            List<Meeting> l1=  new LinkedList<>();
            for (Meeting currMeets: rooms) {
                if (currMeets.end > m.start) {
                    l1.add(currMeets);
                }
            }
            l1.add(m);
            rooms = l1;
            if (rooms.size()> max) {
                max = rooms.size();
            }
            System.out.println("max = "+ max);
        }




    }

}
