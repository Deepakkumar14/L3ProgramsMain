package EventManagement;

import java.util.ArrayList;

public class Logical {
    public static int startTime=540;
    public static  ArrayList<String > finalEvent=new ArrayList<>();
    public static  ArrayList<String > rejected=new ArrayList<>();
    public ArrayList<String> getTime(ArrayList<String> initialList) {
        finalEvent.add("Track  1");
        for (int i=0;i<initialList.size();i++){
            String event=initialList.get(i);
            String[] array=event.split("\\s");
              int time= calculateTime(array[array.length-1]);
                     String output=setEvent(event,time);
                     if(!(output.equalsIgnoreCase("false"))){
                         initialList.remove(i);
                         i=-1;
                    }
                     else
                         rejected.add(event);

        }
        System.out.println(initialList.size());
        System.out.println(rejected.size());
        return finalEvent;
    }
    public int calculateTime(String time){
        int number=0;
        if(time.equalsIgnoreCase("lightning")){
            number=5;
        }
        else{
        number=Integer.parseInt(time.replaceAll("[^0-9]",""));
        }
        return number;
    }

    public String timeFormat(int time){
        int hour=time/60;
        int minute=time%60;
        String minutes=minute+"";
        if(minute<10){
            minutes="0"+minutes;
        }
        if(hour>12){
            hour=hour%12;
            return hour+":"+minutes+"PM";
        }
        if(hour==12){
            return hour+":"+minutes+"PM";
        }
        return hour+":"+minutes+"AM";
    }


       public String setEvent(String event, int time){
        int i=2;
        if(time+startTime<=720 || (time+startTime>780 && time+startTime<=1020)){
           String finalTime = timeFormat(startTime);
           String output=finalTime+"  "+event;
            startTime=time+startTime;
           finalEvent.add(output);
            return output;
        }else {
            if (startTime == 720) {
                String finalTime = timeFormat(startTime);
                String output = finalTime + "   " + "Lunch";
                startTime = 60 + startTime;
                finalEvent.add(output);
                return "false";
            }
            if (startTime == 1020) {
                String finalTime = timeFormat(startTime);
                String output = finalTime + "   " + "NetworkEvent";
                startTime = 540;
                finalEvent.add(output);
                finalEvent.add("Track "+i);
                i++;
            }
        }
           return "false";
       }
}

//7
//        a 60min
//        b lightning
//        c 55min
//        d 60min
//        e 60min
//        f 60min
//        g 60min