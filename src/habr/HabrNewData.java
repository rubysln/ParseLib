package habr;

import settings.OnNewDataHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HabrNewData implements OnNewDataHandler<HashMap<String, ArrayList<String>>> {
    @Override
    public void onNewData(Object sender, HashMap<String, ArrayList<String>> args){
        for(Map.Entry<String, ArrayList<String>> pair: args.entrySet()){
            System.out.println("Название статьи: " + pair.getKey());
            for(var e: args.get(pair.getKey())){
                if(e != null) System.out.println(e);
            }
            System.out.println();
        }
    }
}
