package EventManagement;

import java.util.ArrayList;

public class Logical {
    public static int startTime=540;
    public static  ArrayList<String > finalEvent=new ArrayList<>();
    public static int k=2;

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
                     if(i==initialList.size()-1){
                         setEvent("end",time);
                     }
        }

//        System.out.println(initialList.size());
//        System.out.println(rejected.size());
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
        if(!event.equals("end")&&(time+startTime<=720 || (time+startTime>780 && time+startTime<=1020)) ){
           String finalTime = timeFormat(startTime);
           String output=finalTime+"  "+event;
            startTime=time+startTime;
           finalEvent.add(output);
            return output;
        }else {
            if(startTime>=705 && startTime< 720){
                startTime =720;
                return "false";
            }
            if (startTime == 720) {
                String finalTime = timeFormat(startTime);
                String output = finalTime + "   " + "Lunch";
                startTime = 60 + startTime;
                finalEvent.add(output);
                return "false";
            }
            if(startTime>960 && startTime<=1020){
                String finalTime = timeFormat(startTime);
                String output1 = finalTime + "   " + "NetworkEvent";
                startTime = 540;
                finalEvent.add(output1);
                finalEvent.add("Track "+k);
                k++;
                return "false";
            }
            if(event.equals("end")){
                if(startTime>=960){
                    String finalTime = timeFormat(startTime);
                    String output = finalTime + "   " + "NetworkEvent";
                    startTime = 540;
                    finalEvent.add(output);
                    return output;
                }
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