package EventManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class EventRunner {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        runner();
    }

    public static void runner() {
        Logical logical = new Logical();
        System.out.println("Event Management");
        ArrayList<String> initialList = new ArrayList<>(20);
        System.out.println("Enter Number of Events");
        int number = input.nextInt();
        input.nextLine();
        for (int i = 0; i < number; i++) {
            String str = input.nextLine();
            initialList.add(str);
        }
        ArrayList<String> finalList = logical.getTime(initialList);
        for (int i=0;i<finalList.size();i++) {
            System.out.println(finalList.get(i));
        }
    }
}




//number=18;
//        Writing Fast Tests Against Enterprise Rails 60min
//        Overdoing it in Python 45min
//        Lua for the Masses 30min
//        Ruby Errors from Mismatched Gem Versions 45min
//        Common Ruby Errors 45min
//        Rails for Python Developers lightning
//        Communicating Over Distance 60min
//        Accounting-Driven Development 45min
//        Woah 30min
//        Sit Down and Write 30min
//        Pair Programming vs Noise 45min
//        Rails Magic 60min
//        Ruby on Rails: Why We Should Move On 60min
//        Clojure Ate Scala (on my project) 45min
//        Programming in the Boondocks of Seattle 30min
//        Ruby vs. Clojure for Back-End Development 30min
//        Ruby on Rails Legacy App Maintenance 60min
//        A World Without Hacker News 30min User Interface CSS in Rails Apps 30min