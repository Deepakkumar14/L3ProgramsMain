package EventManagement;

import java.util.ArrayList;

public class Logical {
    public int morningSession=180;
    public int afternoonSession=240;
    public float startTime=9;
    public void getTime(ArrayList<String> initialList) {
        for (int i=0;i<initialList.size();i++){
            String[] array=initialList.get(i).split("\\s");
                calculateTime(array[array.length-1]);
        }
    }
    public void calculateTime(String time){
        int number=0;
        if(time.equalsIgnoreCase("lightning")){
            number=5;
        }
        else{
        number=Integer.parseInt(time.replaceAll("[^0-9]",""));
        }
        int hours=number/60;
        int minutes=number%60;

    }
}
