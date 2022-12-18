package aggregator;

import settings.OnNewDataHandler;

import java.util.ArrayList;

public class AggregatorNewData implements OnNewDataHandler<ArrayList<String>> {

    @Override
    public void onNewData(Object sender, ArrayList<String> e) {
        for(var j : e){
            System.out.println(j);
        }
    }
}
