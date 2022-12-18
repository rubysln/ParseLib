import aggregator.AggregatorHtmlLoader;
import aggregator.AggregatorNewData;
import aggregator.AggregatorParser;
import aggregator.AggregatorSettings;
import settings.Completed;
import settings.ParserWorker;
import habr.*;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
//        HabrSettings habrSettings = new HabrSettings(1, 1);
//        ParserWorker<ArrayList<String>> habrParser = new ParserWorker<>(habrSettings);
//        habrParser.setParser(new HabrParser());
//        habrParser.setLoader(new HabrHtmlLoader(habrSettings));
//        habrParser.getOnCompletedList().add(new Completed());
//        habrParser.getOnNewDataList().add(new HabrNewData());
//        habrParser.Start();
//        habrParser.Abort();

        AggregatorSettings aggregatorSettings = new AggregatorSettings();
        ParserWorker<ArrayList<String>> aggregatorParser = new ParserWorker<>(aggregatorSettings);
        aggregatorParser.setParser(new AggregatorParser());
        aggregatorParser.setLoader(new AggregatorHtmlLoader(aggregatorSettings));
        aggregatorParser.getOnCompletedList().add(new Completed());
        aggregatorParser.getOnNewDataList().add(new AggregatorNewData());
        aggregatorParser.Start();
        aggregatorParser.Abort();
    }
}
