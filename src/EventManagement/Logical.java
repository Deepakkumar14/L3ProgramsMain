package EventManagement;

import java.util.ArrayList;

public class Logical {
    public int morningSession=180;
    public int afternoonSession=240;
    public static int startTime=540;
    public void getTime(ArrayList<String> initialList) {
        for (int i=0;i<initialList.size();i++){
            String[] array=initialList.get(i).split("\\s");
              int time= calculateTime(array[array.length-1]);

        }
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
        if(time+startTime<720){
           String finalTime = timeFormat(new Logical().startTime);
           String output=finalTime+event;
            startTime=time+startTime;
            return output;
        }else {
            if(startTime==720){
                String finalTime = timeFormat(new Logical().startTime);
                String output=finalTime+"Lunch";
                startTime=time+startTime;
                return output;
            }
                if(startTime==1020){
                    //Network
            }

        }
           return event;
       }
}

