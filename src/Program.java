import aggregator.AggregatorHtmlLoader;
import aggregator.AggregatorNewData;
import aggregator.AggregatorParser;
import aggregator.AggregatorSettings;
import settings.Completed;
import settings.ParserWorker;
import habr.*;

import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException {
//
//        AggregatorSettings aggregatorSettings = new AggregatorSettings();
//        ParserWorker<ArrayList<String>> aggregatorParser = new ParserWorker<>(aggregatorSettings);
//        aggregatorParser.setParser(new AggregatorParser());
//        aggregatorParser.setLoader(new AggregatorHtmlLoader(aggregatorSettings));
//        aggregatorParser.getOnCompletedList().add(new Completed());
//        aggregatorParser.getOnNewDataList().add(new AggregatorNewData());
//        aggregatorParser.Start();
//        aggregatorParser.Abort();

        GUI gui = new GUI();
    }
}
