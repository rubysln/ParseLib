import Settings.Completed;
import Settings.ParserWorker;
import habr.*;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException {
        ParserWorker<ArrayList<String>> habrParser = new ParserWorker<>(new HabrSettings(1, 1));
        habrParser.setParser(new HabrParser());
        habrParser.getOnCompletedList().add(new Completed());
        habrParser.getOnNewDataList().add(new HabrNewData());
        habrParser.Start();
        habrParser.Abort();
        

    }
}
