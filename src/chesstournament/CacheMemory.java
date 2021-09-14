package chesstournament;

import java.util.HashMap;
import java.util.LinkedHashMap;

public enum CacheMemory{
    INSTANCE;

    private LinkedHashMap<Integer,PlayerDetails> playerDetails = new LinkedHashMap<>();

    public void playersData(LinkedHashMap<Integer,PlayerDetails> pointsMap){
        playerDetails = pointsMap;
    }

    public HashMap<Integer,PlayerDetails> pointsData(){
        return playerDetails;
    }
    public void pointupdate(PlayerDetails info){
        playerDetails.put(info.getPlayerId(),info);
    }
}
