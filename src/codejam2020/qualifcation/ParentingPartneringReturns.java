package codejam2020.qualifcation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Activity{
    private int start;
    private int end;
    private String author;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class ParentingPartneringReturns {

    public static void main(String[] args) {

        InputStream is = System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int totalCases = in.nextInt();

        for (int t = 1; t <= totalCases; ++t) {
            int numOfActivities = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> activitiesOriginalOrder = new ArrayList<>();
            int cameronFreeSince = 0;
            int jamieFreeSince = 0;
            boolean possible = true;

            for (int i = 1; i <=numOfActivities; ++i) {
                int start = in.nextInt();
                int end = in.nextInt();
                Activity a = new Activity(start, end);
                activities.add(a);
                activitiesOriginalOrder.add(a);
            }

            activities.sort(Comparator.comparing(Activity::getStart));
            for(Activity activity : activities){
                if(activity.getStart() >= cameronFreeSince){
                    activity.setAuthor("C");
                    cameronFreeSince = activity.getEnd();
                }
                else if(activity.getStart() >= jamieFreeSince){
                    activity.setAuthor("J");
                    jamieFreeSince = activity.getEnd();
                }
                else{
                    possible = false;
                    break;
                }
            }

            String result = "IMPOSSIBLE";
            if (possible){
                result = "";
                for(Activity a: activitiesOriginalOrder)
                    result+=a.getAuthor();
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}

